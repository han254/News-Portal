import com.google.gson.Gson;
import dao.sql2oDepartmentDao;
import dao.sql2oDepartmentNewsDao;
import dao.sql2oNewsDao;
import dao.sql2oUsersDao;
import models.Department;
import models.DepartmentNews;
import models.News;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import spark.Spark;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        sql2oDepartmentDao departmentDao;
        sql2oNewsDao newsDao;
        sql2oUsersDao usersDao;
        sql2oDepartmentNewsDao departmentNewsDao;
        Connection conn;
        Gson gson= new Gson();

        try{
            String connectionString = "jdbc:postgresql://localhost:5432/hulu_news";
            Sql2o sql2o = new Sql2o(connectionString,"moringa","peter254");
            newsDao = new sql2oNewsDao(sql2o);
            departmentDao = new sql2oDepartmentDao(sql2o);
            departmentNewsDao = new sql2oDepartmentNewsDao(sql2o);
            usersDao = new sql2oUsersDao(sql2o);
            conn =sql2o.open();
            conn.setRollbackOnException(false);
        }
        catch (Exception ex){
            throw new RuntimeException(ex);
        }

        post("/users/new","application/json",(request, response) -> {
            Users users = gson.fromJson(request.body(), Users.class);
            usersDao.add(users);
            response.status(201);
            return gson.toJson(users);
        });
        get("/users","application/json", (request, response) -> {
            return gson.toJson(usersDao.getAllUsers());
        });

        Spark.get("users/:id","application/json", (request, response) -> {
            int userId = Integer.parseInt(request.params("id"));
            return gson.toJson(usersDao.findById(userId));
        });

        post("/departments/new","application/json", (request, response) -> {
            Department department = gson.fromJson(request.body(), Department.class);
            departmentDao.add(department);
            return gson.toJson(department);
        });

        Spark.get("/departments", "application/json", (request, response) -> {
            return gson.toJson(departmentDao.getAll());
        });
        delete("/users/:id", "application/json", (request, response) -> {
            int userId = Integer.parseInt(request.params("id"));
            usersDao.deleteById(userId);
            response.status(201);
            return gson.toJson("The user has been deleted successfully!");
        });

        post("/departments/new","application/json", (request, response) -> {
            Department department = gson.fromJson(request.body(), Department.class);
            departmentDao.add(department);
            return gson.toJson(department);
        });

        Spark.get("/departments", "application/json", (request, response) -> {
            return gson.toJson(departmentDao.getAll());
        });
        delete("/departments/:id", "application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("id"));
            departmentDao.deleteById(departmentId);
            response.status(201);
            return gson.toJson("The department has been deleted successfully!");
        });

        post("news/new", "application/json", (request, response) -> {
            News news = gson.fromJson(request.body(), News.class);
            newsDao.add(news);
            response.status(201);
            return gson.toJson(news);
        });

        Spark.get("/news", "application/json", (request, response) -> {
            response.status(201);
            return gson.toJson(newsDao.getAllNews());
        });

        Spark.get("/news/:id", "application/json", (request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            return gson.toJson(newsDao.findById(id));
        });

        delete("/news/:id", "application/json", (request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            return gson.toJson("The news article has been deleted successfully!");
        });

        post("/news/:department/news", "application/json", (request, response) -> {
            DepartmentNews news = gson.fromJson(request.body(), DepartmentNews.class);
            int id = Integer.parseInt(request.params("department"));
            news.setId(id);
            departmentNewsDao.add(news);
            return gson.toJson(news);
        });

        Spark.get("news/departments/all", "application/json", (request, response) -> {
            return gson.toJson(departmentNewsDao.getAllDepartmentNews());
        });

        after((request,response) ->{
            response.type("application/json");
        });

    }

}

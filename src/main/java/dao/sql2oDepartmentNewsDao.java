package dao;

import interfaces.DepartmentNewsDao;
import models.DepartmentNews;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class sql2oDepartmentNewsDao implements DepartmentNewsDao {

    private final Sql2o sql2o;

    public sql2oDepartmentNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(DepartmentNews departmentNews) {
        String sql = "INSERT INTO users (name,position,role,id,email) VALUES (:name,:position ,:role,:id,:email)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(departmentNews)
                    .executeUpdate()
                    .getKey();
            departmentNews.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<DepartmentNews> getAllDepartmentNews() {
        String query = "SELECT * FROM news";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(query)
                    .executeAndFetch(DepartmentNews.class);
        }
    }

    @Override
    public News findById(int id) {
        String query = "SELECT * from news WHERE id = :id";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(query, true)
                    .addParameter("id",id)
                    .executeAndFetchFirst(News.class);
        }
    }

    @Override
    public void clearAllDepartmentNews() {
        String query = "DELETE from news ";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(query)
                    .executeUpdate();
        }
        catch (Sql2oException e){
            System.out.println(e.getMessage());
        }

    }
}

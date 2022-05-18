package dao;

import interfaces.UsersDao;
import models.Department;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class sql2oUsersDao implements UsersDao {
    private final Sql2o sql2o;

    public sql2oUsersDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    public void add(Users users) {
        String sql = "INSERT INTO users (name,position,role,departmentId,email) VALUES (:name,:position ,:role,:departmentId,:email)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(users)
                    .executeUpdate()
                    .getKey();
            users.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public Users findById(int id) {
        String query = "SELECT * from users WHERE id = :id";
        try (Connection conn = sql2o.open()) {
        return conn.createQuery(query, true)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Users.class);
        }
    }
    @Override
    public List<Users> getAllUsers() {
        String query = "SELECT * FROM users";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(query)
                    .executeAndFetch(Users.class);
        }
    }

    @Override
    public List<Users> getAllUsersInDepartments(int departmentId) {
        String query = "SELECT * from users WHERE departmentId = :departmentId";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(query)
                    .addParameter("departmentId",departmentId)
                    .executeAndFetch(Users.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String query = "DELETE from users WHERE id = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(query, true)
                    .addParameter("id",id)
                    .executeUpdate();
        }
        catch (Sql2oException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void clearAllUsers() {
        String query = "DELETE from users ";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(query)
                    .executeUpdate();
        }
        catch (Sql2oException e){
            System.out.println(e.getMessage());
        }
    }
}

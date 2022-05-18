package dao;

import interfaces.DepartmentDao;
import models.Department;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.sql.SQLException;
import java.util.List;

public class sql2oDepartmentDao implements DepartmentDao {
    private final Sql2o sql2o;

    public sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    public void add(Department department) {
        String query = "INSERT INTO department (departmentName,description,numberOfEmployees) VALUES (:departmentName,:description,:numberOfEmployees)";
        try (Connection conn = sql2o.open()) {
            int id = (int) conn.createQuery(query, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        }catch (Sql2oException e){
            System.out.println(e.getMessage());
        }
    }
    public List<Department> getAll() {
        String query = "SELECT * FROM department";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(query)
                    .executeAndFetch(Department.class);
        }
    }
    public void deleteById(int id) {
        String query = "DELETE from department WHERE id = :id";
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
    public void clearAll() {
        String query = "DELETE from department ";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(query)
                    .executeUpdate();
        }
        catch (Sql2oException e){
            System.out.println(e.getMessage());
        }
    }
}


package dao;

import interfaces.DepartmentDao;
import models.Department;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class sql2oDepartmentDao implements DepartmentDao {
    private final Sql2o sql2o;

    public sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    public void add(Department department) {
        String query = "INSERT INTO department (departmentname,description,numberOfEmployees VALUES (:departmentName,:description,:numberOfEmployees)";
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
}

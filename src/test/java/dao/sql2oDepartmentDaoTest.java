package dao;

import interfaces.DepartmentDao;
import models.Department;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class sql2oDepartmentDaoTest {
    private sql2oDepartmentDao DepartmentDao;
    private Connection conn;

    @BeforeEach
    public void setUp() {
        String Connect = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:DB/create.sql'";
        Sql2o sql2o = new Sql2o(Connect, "", "");
        DepartmentDao = new sql2oDepartmentDao(sql2o);
        conn = sql2o.open();
    }
    @Test
    public void addingDepartmentSetsId() throws Exception {
        Department department = setupNewDepartment();
        int id = department.getId();
        assertEquals(1,id);
    }
@Test
public void getAll() throws Exception {
    Department department = setupNewDepartment();
    Department department1 = setupNewDepartment();
    assertEquals(2, DepartmentDao.getAll().size());
}
    @Test
    public void deleteById() throws Exception {
        Department testDepartment = setupNewDepartment();
        Department otherDepartment = setupNewDepartment();
        assertEquals(2, DepartmentDao.getAll().size());
        DepartmentDao.deleteById(testDepartment.getId());
        assertEquals(1, DepartmentDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Department testDepartment = setupNewDepartment();
        Department otherDepartment = setupNewDepartment();
        DepartmentDao.clearAll();
        assertEquals(0, DepartmentDao.getAll().size());
    }

    public Department setupNewDepartment() {
        Department department= new Department("Finance", " acquiring and utilizing money for financing the activities of the tourism business", 20);
        DepartmentDao.add(department);
        return department;
    }

    @AfterEach
    public void tearDown() {
        conn.close();
        System.out.println("connection closed");
    }
}
package dao;

import models.Department;
import models.Users;
import org.h2.engine.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class sql2oUsersDaoTest {
private sql2oUsersDao UsersDao;
private Connection conn;

    @BeforeEach
    void setUp() {
        String Connect = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:DB/create.sql'";
        Sql2o sql2o = new Sql2o(Connect, "", "");
        UsersDao = new sql2oUsersDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    void tearDown() {
        conn.close();
        System.out.println("connection closed");
    }
    @Test
    void add() {
        Users users= setupNewUsers();
        assertEquals(1,users.getId());
    }

    @Test
    void findById() {
        Users users=setupNewUsers();
        assertEquals("Finance", UsersDao.findById(users.getId()).getName());
    }

    @Test
    void getAllUsers() {
        Users users= setupNewUsers();
        assertEquals(1,UsersDao.getAllUsers().size());
    }

    @Test
    void getAllUsersInDepartments() {
        Users users= setupNewUsers();
        assertEquals(1,UsersDao.getAllUsersInDepartments(20).size());
    }

    @Test
    void deleteById() {
        Users users= setupNewUsers();
        assertEquals(1,UsersDao.getAllUsers().size());
        UsersDao.deleteById(users.getId());
        assertEquals(0,UsersDao.getAllUsers().size());
    }

    @Test
    void clearAllUsers() {
        Users users= setupNewUsers();
        assertEquals(1,UsersDao.getAllUsers().size());
        UsersDao.clearAllUsers();
        assertEquals(0,UsersDao.getAllUsers().size());
    }
    public Users setupNewUsers() {
        Users users= new Users("Finance", "Senior", "HR", 20,"peter@gmail.com");
        UsersDao.add(users);
        return users;
    }
}

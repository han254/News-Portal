package dao;

import models.Department;
import models.DepartmentNews;
import models.News;
import models.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class sql2oDepartmentNewsDaoTest {
    private sql2oDepartmentNewsDao DepartmentNewsDao;
    private Connection conn;

    @BeforeEach
    void setUp() {
        String Connect = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:DB/create.sql'";
        Sql2o sql2o = new Sql2o(Connect, "", "");
        DepartmentNewsDao= new sql2oDepartmentNewsDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    void tearDown() {
        conn.close();
        System.out.println("connection closed");
    }

    @Test
    void add() {
            DepartmentNews departmentNews =setupDepartmentNews();
            int id = departmentNews.getId();
            assertEquals(7,departmentNews.getId());
    }

    @Test
    void getAllDepartmentNews() {
        DepartmentNews departmentNews= setupDepartmentNews();
        assertEquals(0,DepartmentNewsDao.getAllDepartmentNews().size());
    }

    @Test
    void clearAllDepartmentNews() {
        DepartmentNews departmentNews=setupDepartmentNews();
        assertEquals(0,DepartmentNewsDao.getAllDepartmentNews().size());
        DepartmentNewsDao.clearAllDepartmentNews();
        assertEquals(0,DepartmentNewsDao.getAllDepartmentNews().size());
    }
    public DepartmentNews setupDepartmentNews() {
        DepartmentNews departmentNews = new DepartmentNews(7, "Kenya Kwanza nominations","Trending","Trends");
        DepartmentNewsDao.add(departmentNews);
        return departmentNews;
    }
}
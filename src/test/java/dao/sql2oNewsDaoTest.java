package dao;

import models.News;
import models.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class sql2oNewsDaoTest {
    private sql2oNewsDao NewsDao;
    private Connection conn;

    @BeforeEach
    void setUp() {
        String Connect = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:DB/create.sql'";
        Sql2o sql2o = new Sql2o(Connect, "", "");
        NewsDao = new sql2oNewsDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    void tearDown() {
        conn.close();
        System.out.println("connection closed");
    }

    @Test
    void add() {
        News news =setupNews();
        assertEquals(1,news.getId());
    }

    @Test
    void getAllNews() {
        News news= setupNews();
        assertEquals(1,NewsDao.getAllNews().size());
    }

    @Test
    void deleteById() {
        News news= setupNews();
        assertEquals(1,NewsDao.getAllNews().size());
        NewsDao.deleteById(news.getId());
        assertEquals(0,NewsDao.getAllNews().size());
    }

    @Test
    void clearAllNews() {
        News news= setupNews();
        assertEquals(1,NewsDao.getAllNews().size());
        NewsDao.clearAllNews();
        assertEquals(0,NewsDao.getAllNews().size());
    }
    public News setupNews() {
        News news = new News("Elections 2022", "UDA", "Trends");
        NewsDao.add(news);
        return news;
    }
}
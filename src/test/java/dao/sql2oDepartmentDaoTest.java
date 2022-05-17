package dao;

import org.junit.jupiter.api.BeforeEach;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class sql2oDepartmentDaoTest {
    private sql2oDepartmentDao sql2oDepartmentDao;
    private Connection conn;

    @BeforeEach
    public void setUp(){
        String Connect ="jdbc:h2:mem:testing:INIT=RUNSCRIPT from 'classpath:dao/create.sql'";
        Sql2o sql2o = new Sql2o(Connect,"","");
        sql2oDepartmentDao = new sql2oDepartmentDao(sql2o);
        conn =sql2o.open();
    }

}
package dao;

import interfaces.NewsDao;
import models.News;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class sql2oNewsDao implements NewsDao {

    private final Sql2o sql2o;

    public sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(News news) {

        String sql = "INSERT INTO news (title, content, departmentName) VALUES (:title,:content ,:departmentName)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<News> getAllNews() {
        String query = "SELECT * FROM news";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(query)
                    .executeAndFetch(News.class);
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
    public void deleteById(int id) {
        String query = "DELETE from news WHERE id = :id";
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
    public void clearAllNews() {
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

package interfaces;

import models.News;

import java.util.List;

public interface NewsDao {
    //CRUD
    void add(News news);

    List<News> getAllNews();
    News findById(int id);

    void deleteById(int id);
    void clearAllNews();

}

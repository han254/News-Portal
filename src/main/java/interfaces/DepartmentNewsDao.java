package interfaces;

import models.DepartmentNews;
import models.News;

import java.util.List;

public interface DepartmentNewsDao {
    //CRUD
    void add(DepartmentNews departmentNews);

    List<DepartmentNews> getAllDepartmentNews();
    News findById(int id);


    void clearAllDepartmentNews();
}

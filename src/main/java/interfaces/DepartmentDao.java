package interfaces;

import models.Department;

import java.util.Collection;
import java.util.List;

public interface DepartmentDao {

    public static void add(Department department) {

    }
    public List<Department> getAll();

    public void deleteById(int id);

    public void clearAll();
}



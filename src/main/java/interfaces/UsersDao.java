package interfaces;

import models.Department;
import models.Users;

import java.util.List;

public interface UsersDao {
    //CRUD
    void add(Users users);

    Users findById(int id);

    List<Users> getAllUsers();


    List<Department> getAllUserInDepartments(int user_id);


    void deleteById(int id);
    void clearAllUsers();

}

package interfaces;

import models.Department;
import models.Users;

import java.util.List;

public interface UsersDao {
    //CRUD
    void add(Users users);

    Users findById(int id);

    List<Users> getAllUsers();


    List<Users> getAllUsersInDepartments(int departmentId);


    void deleteById(int id);
    void clearAllUsers();

}

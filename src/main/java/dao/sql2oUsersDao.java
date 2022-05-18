package dao;

import interfaces.UsersDao;
import models.Department;
import models.Users;

import java.util.List;

public class sql2oUsersDao implements UsersDao {
    @Override
    public void add(Users users) {

    }

    @Override
    public Users findById(int id) {
        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        return null;
    }

    @Override
    public List<Department> getAllUserInDepartments(int user_id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAllUsers() {

    }
}

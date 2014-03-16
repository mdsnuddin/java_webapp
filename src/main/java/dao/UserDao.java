package dao;

import dao.entities.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();
    public UserDao updateUser();
    public void deleteUser(String... dbData);
    public void addUser(String... dbData);
}

package dao;

import dao.entities.User;

import java.util.List;

public interface DaoCommon {

    public List<User> getAllUsers();
    public DaoCommon update();
    public void delete(String ...dbData);
    public void addUser(String... dbData);
}

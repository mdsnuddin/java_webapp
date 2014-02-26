package dao;

import dao.entities.Entities;
import dao.entities.User;

import java.util.List;

public interface Dao {

    public List<User> getAll();
    public Dao update();
    public void delete(String ...dbData);
    public void add(String ...dbData);
}

package web.builder;

import dao.entitiesDb.EntityUserDao;

public class UserBuilder {

    private String name = "";
    private String password = "";

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    private String getName() {
        return this.name;
    }
    private String getPassword() { return this.password; }

    public UserBuilder build() {
        try {
            EntityUserDao entityDao = new EntityUserDao();
            entityDao.connectToDatabase();
            entityDao.addUser(getName(), getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
}


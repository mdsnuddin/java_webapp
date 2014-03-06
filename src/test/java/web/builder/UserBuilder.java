package web.builder;

import dao.entitiesDb.UserDao;

public class UserBuilder {

    // TODO: need to randomise the member variables of this class
    private String name = "RandomValue";

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    private String getName() {
        return this.name;
    }

    public UserBuilder build() {
        try {
            UserDao userDao = new UserDao();
            userDao.connectToDatabase();
            userDao.add(getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
}

// TODO: Look into writing builders

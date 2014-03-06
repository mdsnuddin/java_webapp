package servlet.business;

import dao.entities.User;
import dao.entitiesDb.UserDao;

import java.util.List;

public class RegistrationBusiness {

    public static boolean validateRegistration(String userName, String password) {

        UserDao userDao = new UserDao();
        try {
            userDao.connectToDatabase();
            List<User> allUsers = userDao.getAll();

            for (User user : allUsers) {
                if (userName.equals(user.getUserName())) {
                    return false;
                }
            }

            userDao.add(userName, password);

            return true;

        } catch (Exception e) {}

        return false;
    }
}

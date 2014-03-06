package servlet.business;

import dao.entities.User;
import dao.entitiesDb.UserDao;

import java.util.List;

public class LoginBusiness {

    public static boolean validCredentials(String userName, String password) throws Exception {
        if (userName.length() >= 1 && password.length() >= 1) {

            UserDao userDao = new UserDao();
            userDao.connectToDatabase();
            List<User> allUsers = userDao.getAll();

            for (User user : allUsers) {
                if (user.getUserName().contains(userName) && user.getPassword().contains(password)) {
                    return true;
                }
            }

            return false;
        }
        return false;
    }

}

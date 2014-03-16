package servlet.business;

import dao.entities.User;
import dao.entitiesDb.EntityUserDao;

import java.util.List;

public class LoginBusiness {

    public static boolean validCredentials(String userName, String password) throws Exception {
        if (userName.length() >= 1 && password.length() >= 1) {
            EntityUserDao entityDao = new EntityUserDao();
            entityDao.connectToDatabase();
            List<User> allUsers = entityDao.getAllUsers();

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

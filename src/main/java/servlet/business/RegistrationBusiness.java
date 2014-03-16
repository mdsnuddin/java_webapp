package servlet.business;

import dao.entities.User;
import dao.entitiesDb.EntityUserDao;

import java.util.List;

public class RegistrationBusiness {

    public static boolean validateRegistration(String userName, String password) {
        EntityUserDao entityDao = new EntityUserDao();

        try {
            entityDao.connectToDatabase();
            List<User> allUsers = entityDao.getAllUsers();

            for (User user : allUsers) {
                if (userName.equals(user.getUserName())) {
                    return false;
                }
            }
            entityDao.addUser(userName, password);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

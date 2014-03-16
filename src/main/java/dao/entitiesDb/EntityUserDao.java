package dao.entitiesDb;

import dao.UserDao;
import dao.db.AbstractDao;
import dao.db.DoaController;
import dao.entities.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntityUserDao extends AbstractDao implements UserDao {

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();

        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from users");

            int indexCount = 0;
            while (resultSet.next()) {
                String user_id = resultSet.getString("user_id");
                String user_name = resultSet.getString("user_name");
                String user_password = resultSet.getString("user_password");

                users.add(indexCount, new User(Integer.parseInt(user_id), user_name, user_password));
                indexCount++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public UserDao updateUser() {
        // TODO: complete this method
        return null;
    }

    @Override
    public void deleteUser(String... dbData) {
        try {
            connect.setAutoCommit(true);
            preparedStatement = connect.prepareStatement("delete from users where user_name = (?)");
            preparedStatement.setString(1, dbData[0]);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(String... dbData) {
        try {
            AbstractDao dao = new DoaController();
            connect = dao.connectToDatabase();
            connect.setAutoCommit(true);

            String query = "insert into users (user_name, user_password) \n" +
                    "values ('" + dbData[0] + "', '" + dbData[1] + "')";

            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// TODO: Complete the DAO implementation in this class

package dao;

import dao.entities.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao implements Dao {

    @Override
    public List<User> getAll() {
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
    public Dao update() {
        // TODO: complete this method
        return null;
    }

    @Override
    public void delete(String ...dbData) {
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
    public void add(String ...dbData) {
        try {
            connect.setAutoCommit(true);

            preparedStatement = connect.prepareStatement("insert into users (user_name, user_password) values (?)(?)");
            // TODO: Check if the below statement works
            preparedStatement.setString(1, dbData[0]);
            preparedStatement.setString(2, dbData[1]);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

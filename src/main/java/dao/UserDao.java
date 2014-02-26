// TODO: Complete the DAO implementation in this class

package dao;

import dao.entities.User;

import java.sql.*;
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

                users.add(indexCount, new User(Integer.parseInt(user_id), user_name));
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

            preparedStatement = connect.prepareStatement("insert into users (user_name) values (?)");
            preparedStatement.setString(1, dbData[0]);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

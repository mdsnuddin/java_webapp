package dao.db;

import java.sql.*;

public class AbstractDao {

    public Connection connect = null;
    public Statement statement = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;

    public Connection connectToDatabase() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/tstdb?user=root&password=root");
        } catch (Exception e) {
            throw e;
        }
        return connect;
    }
}

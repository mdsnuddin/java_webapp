package dao;

import java.sql.*;

public class AbstractDao {

    public Connection connect = null;
    public Statement statement = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;

    public void connectToDatabase() throws Exception {
        try {
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/tstdb?user=root&password=root");
        }catch (Exception e) {
            throw e;
        }
    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        System.out.println("The columns in the table are: ");
        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String user_id = resultSet.getString("user_id");
            String user_name = resultSet.getString("user_name");
            String user_password = resultSet.getString("user_password");
            System.out.println("user_id: " + user_id);
            System.out.println("user_name: " + user_name);
            System.out.println("user_password: " + user_password);
        }
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
        }
    }
}

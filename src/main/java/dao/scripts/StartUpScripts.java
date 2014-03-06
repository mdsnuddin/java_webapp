package dao.scripts;

import dao.db.AbstractDao;
import dao.db.DoaController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StartUpScripts {

    public static Connection connect = null;

    public static void updateDB() {
        try {
            runStatements();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void runStatements() {
        // Delete all tables
        runUpdateQuery("drop table users");

        // Create all tables
        runUpdateQuery("create table users (\n" +
                "user_id int auto_increment primary key not null,\n" +
                "user_name varchar(255) not null,\n" +
                "user_password varchar(255) not null\n" +
                ")");

        // Create the required data
        runUpdateQuery("insert into users (user_name, user_password) \n" +
                "values ('admin', 'password')");
    }

    private static void runUpdateQuery(String query) {
        try {
            AbstractDao dao = new DoaController();
            connect = dao.connectToDatabase();
            connect.setAutoCommit(true);
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

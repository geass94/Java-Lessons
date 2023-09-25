package ge.itestep.Lesson_Four;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3309/jdbc";
    private static final String USER = "jdbc";
    private static final String PASSWORD = "secret";

    public static Connection getConnection() throws SQLException {
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

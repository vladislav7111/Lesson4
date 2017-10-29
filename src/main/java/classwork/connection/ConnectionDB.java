package classwork.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/course";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";

    private ConnectionDB() {
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(MYSQL_DRIVER);
            connection = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * The inner class for implementation singleton.
     */
    private static class Holder {
        private final static ConnectionDB INSTANCE = new ConnectionDB();
    }

    /**
     * The method gives ConnectionDB singleton instance.
     */
    public static ConnectionDB getInstance() {
        return Holder.INSTANCE;
    }
}

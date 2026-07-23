import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Config {

    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "internship";
    private static final String USER = "root";
    private static final String PASSWORD = "Mysqlrootpass123#";
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }



}

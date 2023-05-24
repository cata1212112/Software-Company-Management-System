package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    public static Connection conn = null;

    static {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://192.168.100.8:5433/proiectPAO", "cata", "");
        } catch (SQLException e) {
            System.out.println("Could not establish connection!");
            System.exit(0);
        }
    }

    private DatabaseService() {

    }

    public static void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}

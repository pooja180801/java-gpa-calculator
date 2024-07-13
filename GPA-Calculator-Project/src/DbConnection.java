import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
   private static String url = "jdbc:mysql://localhost:3306/gpacalculator";
   private static String username = "root";

   private static String password = "";


   public static Connection getConnection() throws SQLException {
       Connection conn = DriverManager.getConnection(url, username, password);
       return conn;
   }


}

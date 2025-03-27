import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL {
    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Thientam;encrypt=true;trustServerCertificate=true"; // hoặc localhost\\SQLEXPRESS
            String username = "sa";
            String password = "123456";
            Connection sql = DriverManager.getConnection(url, username, password);
            System.out.println("Connect to SQL Server completed!");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
import java.sql.Connection;
import java.sql.DriverManager;
import login.signup.*;

public class setup {
    public static void main(String[] args) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Thientam;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "123";
            Connection con = DriverManager.getConnection(url, username, password);
            if (con != null) {
                System.out.println("ket noi thanh cong");
            }
        } catch (Exception e) {

        }

        new login();
    }
}

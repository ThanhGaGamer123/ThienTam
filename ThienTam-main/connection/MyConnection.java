
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {

    Connection con;
    Statement stm;
    PreparedStatement prestm;

    public static Connection createConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Thientam;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "123";
            Connection sql = DriverManager.getConnection(url, username, password);
            System.out.println("Create connect to SQL Server completed!");
            System.out.println(sql);
            return sql;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ResultSet runQuerry(String st) {
        try {
            return stm.executeQuery(st);
        } catch (Exception e) {
            return null;
        }
    }

    public int RunUpdate(String st) {
        try {
            return stm.executeUpdate(st);
        } catch (Exception e) {
            return 0;
        }
    }

    public int prepareUpdate(String sql, Object... params) {
        try {
            PreparedStatement prestm = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                prestm.setObject(i + 1, params[i]);
            }
            return prestm.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}


package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyConnection {

    Connection con;
    Statement stm;
    PreparedStatement prestm;

    public boolean openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=Thientam;trustServerCertificate=true";
            String user = "sa";
            String password = "123";
            con = DriverManager.getConnection(url, user, password);

            stm = con.createStatement();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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

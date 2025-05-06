package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQL {
    public static Connection createConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Thientam;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "123456";
            Connection sql = DriverManager.getConnection(url, username, password);
            System.out.println("Create connect to SQL Server completed!");
            System.out.println(sql);
            return sql;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(Connection sql) {
        try {
            if (sql != null) {
                sql.close();
                System.out.println("Close connection to SQL Server completed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection sql = createConnection();
        closeConnection(sql);
    }
}
package Programm;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class pool{
    
    public ResultSet init(String query) throws ClassNotFoundException, SQLException{
        String instanceName = "localhost\\SQLEXPRESS";
        String databaseName = "Construction";
        String connectionUrl = "jdbc:sqlserver://%1$s;databaseName=%2$s;integratedSecurity=true;";
        String connectionString = String.format(connectionUrl, instanceName, databaseName);
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(connectionString);
        Statement stmt = con.createStatement();
        ResultSet executeQuery = stmt.executeQuery(query);
        return executeQuery;
    }
    
    public void insertInto(String query) throws ClassNotFoundException, SQLException{
        String instanceName = "localhost\\SQLEXPRESS";
        String databaseName = "Construction";
        String connectionUrl = "jdbc:sqlserver://%1$s;databaseName=%2$s;integratedSecurity=true;";
        String connectionString = String.format(connectionUrl, instanceName, databaseName);
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(connectionString);
        Statement stmt = con.createStatement();
        stmt.execute(query);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.*;

/**
 *
 * @author PhuNDSE63159
 */
public class MyConnection {

    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=";

    public static Connection getConnection(String user, String password, String databaseName) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection c = DriverManager.getConnection(url + databaseName, user, password);
        return c;
    }

}

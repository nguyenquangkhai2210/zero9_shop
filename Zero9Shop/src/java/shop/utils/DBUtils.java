/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author THANH HUNG
 */
public class DBUtils {

    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=";

    public static Connection getConnection(String user, String password, String databaseName) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url + databaseName, user, password);
        return conn;
    }

    public static void closeConnection(Connection conn, PreparedStatement stm, ResultSet rs) throws ClassNotFoundException, SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
        public static void closeConnection(Connection conn, PreparedStatement stm) throws ClassNotFoundException, SQLException {
        if (stm != null) {
            stm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}

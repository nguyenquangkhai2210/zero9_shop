/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.employee;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import shop.customer.CustomerDTO;

/**
 *
 * @author THANH HUNG
 */
public class EmployeeDAO implements Serializable {

    public static ArrayList<EmployeeDTO> executeQuery(String query, Connection c) throws SQLException, NoSuchAlgorithmException {
        PreparedStatement psm = null;
        ResultSet rs = null;
        ArrayList<EmployeeDTO> listEmp = null;
        try {
            psm = c.prepareStatement(query);
            rs = psm.executeQuery();
            listEmp = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("EmpID");
                String username = rs.getString("EmpUsername");
                String pass = rs.getString("EmpPassword");
                String name = rs.getString("EmpName");
                String phone = rs.getString("EmpPhone");
                String mail = rs.getString("EmpMail");
                String address = rs.getString("EmpAddress");
                String gender = rs.getString("EmpGender");
                String birthdate = rs.getString("EmpBirthdate");
                String startdate = rs.getString("StartDate");
                String enddate = rs.getString("EndDate");
                String role = rs.getString("RoleID");
                EmployeeDTO emp = new EmployeeDTO(id, username, pass, name, phone, mail, address, gender, birthdate, startdate, enddate, role);
                listEmp.add(emp);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }
        }
        return listEmp;
    }

    public static int executeUpdate(String query, Connection c) throws SQLException {
        PreparedStatement psm = null;
        int result;
        try {
            psm = c.prepareStatement(query);
            result = psm.executeUpdate();
        } finally {
            if (psm != null) {
                psm.close();
            }
        }
        return result;
    }

    public static boolean changePassword(String username, String oldPass, String newPass) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = shop.utils.DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "UPDATE tblEmployee SET EmpPassword = ? Where EmpPassword = ? AND EmpUsername = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, newPass);
            stm.setString(2, oldPass);
            stm.setString(3, username);
            int result = stm.executeUpdate();
            if (result > 0) {
                return true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public static boolean checkLogin(String username, String password) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = shop.utils.DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "SELECT * FROM tblEmployee WHERE username = ? AND password = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            boolean result = rs.next();
            rs.close();
            if (result) {
                return true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    /**
     * This function is used to get profile of a employee who has <i>username<i>.
     * <br>
     * Username of employee is unique key so you can use to find customer
     * @param username: username in the database
     * @return EmployeeDTO with all information except password is set to null
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws NoSuchAlgorithmException
     */
    public static EmployeeDTO getEmployeeProfile(String username) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        Connection c = null;
        PreparedStatement psm = null;
        EmployeeDTO employee = null;
        ResultSet rs = null;
        try {
            c = shop.utils.DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "Select * from tblEmployee where EmpUsername = ?";
            psm = c.prepareStatement(sql);
            psm.setString(1, username);
            rs = psm.executeQuery();
            String id = rs.getString("EmpID");
            String name = rs.getString("EmpName");
            String phone = rs.getString("EmpPhone");
            String mail = rs.getString("EmpMail");
            String address = rs.getString("EmpAddress");
            String gender = rs.getString("EmpGender");
            String birthdate = rs.getString("EmpBirthdate");
            String startDate = rs.getString("StartDate");
            String endDate = rs.getString("EndDate");
            String role = rs.getString("RoleID");
            employee = new EmployeeDTO(mail, username, "", name, phone, mail, address, gender, birthdate, startDate, endDate, role);
        } finally {
            if (c != null) {
                c.close();
            }
            if (psm != null) {
                psm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return employee;
    }


//    public boolean signUp(String username, String password, String email, String fullName, String phone, String gender, String address)
//    {
//        try {
//         Connection conn = sample.utils.DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
//         String sql = "INSERT INTO";
//         PreparedStatement stm = conn.prepareStatement(sql);
//        } catch (Exception e) {

//        }
//     return false;
//    }
}

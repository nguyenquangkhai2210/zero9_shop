<<<<<<< HEAD:Zero9Shop/src/java/sample/employee/EmployeeDAO.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.employee;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
            rs.close();
            psm.close();
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
            psm.close();
        }
        return result;
    }

    public boolean changePassword(String username, String oldPass, String newPass) {
        try {
            Connection conn = sample.utils.DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "UPDATE tblEmployee SET EmpPassword = ? Where EmpPassword = ? AND EmpUsername = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, newPass);
            stm.setString(2, oldPass);
            stm.setString(3, username);
            int result = stm.executeUpdate();
            stm.close();
            conn.close();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean checkLogin(String username, String password) {
        try {
            Connection conn = sample.utils.DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "SELECT * FROM Registration WHERE username = ? AND password = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            boolean result = rs.next();
            rs.close();
            stm.close();
            conn.close();
            if (result) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
//    public boolean signUp(String username, String password)
//    {
//        
//    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.EmployeeDTO;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PhuNDSE63159
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

}
>>>>>>> 02657d3e7e4f393db31e7f8f5f02ff9414ab9b06:ShoppingOnlineProject/src/dao/EmployeeDAO.java

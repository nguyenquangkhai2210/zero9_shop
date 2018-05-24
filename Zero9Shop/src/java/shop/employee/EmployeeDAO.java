/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.employee;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import shop.utils.DBUtils;
import shop.utils.EncryptionUtils;

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

    public static boolean changePassword(String username, String oldPass, String newPass) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = shop.utils.DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "UPDATE tblEmployee SET EmpPassword = ? Where EmpPassword = ? AND EmpUsername = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, EncryptionUtils.md5(newPass));
            stm.setString(2, EncryptionUtils.md5(oldPass));
            stm.setString(3, username);
            int result = stm.executeUpdate();
            if (result > 0) {
                return true;
            }
        } finally {
            DBUtils.closeConnection(conn, stm);
        }
        return false;
    }

    public static boolean checkLogin(String username, String password) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = shop.utils.DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "SELECT * FROM tblEmployee WHERE EmpUsername = ? AND EmpPassword = ? AND RoleID = 1";
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, EncryptionUtils.md5(password));
            rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } finally {
            DBUtils.closeConnection(conn, stm, rs);
        }
        return false;
    }

    /**
     * This function is used to get profile of a employee who has <i>username<i>.
     * <br>
     * Username of employee is unique key so you can use to find customer
     *
     * @param idEmp: username in the database
     * @return EmployeeDTO with all information except password is set to null
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws NoSuchAlgorithmException
     */
    public static EmployeeDTO getEmployeeProfile(String idEmp) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        Connection c = null;
        PreparedStatement psm = null;
        EmployeeDTO employee = null;
        ResultSet rs = null;
        try {
            c = shop.utils.DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "Select * from tblEmployee where EmpID = ?";
            psm = c.prepareStatement(sql);
            psm.setString(1, idEmp);
            rs = psm.executeQuery();
            while (rs.next()) {
                String empUsername = rs.getString("EmpUsername");
                String empName = rs.getString("EmpName");
                String empPhone = rs.getString("EmpPhone");
                String empMail = rs.getString("EmpMail");
                String empAddress = rs.getString("EmpAddress");
                String empGender = rs.getString("EmpGender");
                String empBirthdate = rs.getString("EmpBirthdate");
                String startDate = rs.getString("StartDate");
                String endDate = rs.getString("EndDate");
                String role = rs.getString("RoleID");
                employee = new EmployeeDTO(idEmp, empUsername, empName, empPhone, empMail, empAddress, empGender, empBirthdate, startDate, endDate, role);
            }
        } finally {
            DBUtils.closeConnection(c, psm, rs);
        }
        return employee;
    }

    public List<EmployeeDTO> listEmployee() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EmployeeDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "SELECT TOP 12 * FROM tblEmployee";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String empID = rs.getString("EmpID");
                String empUsername = rs.getString("EmpUsername");
                String empName = rs.getString("EmpName");
                String empPhone = rs.getString("EmpPhone");
                String empMail = rs.getString("EmpMail");
                String empAddress = rs.getString("EmpAddress");
                String empGender = rs.getString("EmpGender");
                String empBirthdate = rs.getString("EmpBirthdate");
                String startDate = rs.getString("StartDate");
                String endDate = rs.getString("EndDate");
                String role = rs.getString("RoleID");
                EmployeeDTO tmp = new EmployeeDTO(empID, empUsername, empName, empPhone, empMail, empAddress, empGender, empBirthdate, startDate, endDate, role);
                list.add(tmp);
            }
        } finally {
            DBUtils.closeConnection(conn, stm, rs);
        }
        return list;
    }

    public static EmployeeDTO getEmployeeProfileWithUsernam(String username) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
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
            while (rs.next()) {
                String empID = rs.getString("EmpID");
                String empName = rs.getString("EmpName");
                String empPhone = rs.getString("EmpPhone");
                String empMail = rs.getString("EmpMail");
                String empAddress = rs.getString("EmpAddress");
                String empGender = rs.getString("EmpGender");
                String empBirthdate = rs.getString("EmpBirthdate");
                String startDate = rs.getString("StartDate");
                String endDate = rs.getString("EndDate");
                String role = rs.getString("RoleID");
                employee = new EmployeeDTO(empID, username, empName, empPhone, empMail, empAddress, empGender, empBirthdate, startDate, endDate, role);
            }
        } finally {
            DBUtils.closeConnection(c, psm, rs);
        }
        return employee;
    }

    public List<EmployeeDTO> findByNameEmployee(String search) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EmployeeDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "SELECT * FROM tblEmployee WHERE EmpName LIKE ?";
            stm = conn.prepareStatement(sql);
            search = new String(search.getBytes(), Charset.forName("UTF-8"));
            stm.setString(1, "%" + search + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                String empID = rs.getString("EmpID");
                String empUsername = rs.getString("EmpUsername");
                String empName = rs.getString("EmpName");
                String empPhone = rs.getString("EmpPhone");
                String empMail = rs.getString("EmpMail");
                String empAddress = rs.getString("EmpAddress");
                String empGender = rs.getString("EmpGender");
                String empBirthdate = rs.getString("EmpBirthdate");
                String startDate = rs.getString("StartDate");
                String endDate = rs.getString("EndDate");
                String role = rs.getString("RoleID");
                EmployeeDTO tmp = new EmployeeDTO(empID, empUsername, empName, empPhone, empMail, empAddress, empGender, empBirthdate, startDate, endDate, role);
                list.add(tmp);
            }
        } finally {
            DBUtils.closeConnection(conn, stm, rs);
        }
        return list;
    }

    public static boolean updateCustomerProfile(String empID, EmployeeDTO emp) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        Connection conn = null;
        PreparedStatement psm = null;
        try {
            conn = DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "UPDATE tblEmployee SET EmpName = ?, EmpPhone = ?, EmpMail = ?, EmpAddress = ?, EmpGender = ?, EmpBirthdate = ? WHERE EmpID = ?";
            psm = conn.prepareStatement(sql);
            psm.setNString(1, emp.getEmpName());
            psm.setString(2, emp.getEmpPhone());
            psm.setString(3, emp.getEmpMail());
            psm.setNString(4, emp.getEmAddress());
            psm.setString(5, emp.getEmpGender());
            psm.setString(6, emp.getEmpBirthdate());
            psm.setString(7, empID);
            int result = psm.executeUpdate();
            if (result > 0) {
                return true;
            }
        } finally {
            DBUtils.closeConnection(conn, psm);
        }
        return false;
    }

    public static String getIdEmployee() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        String idEmp = null;
        String idTmp = null;
        try {
            conn = DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "SELECT TOP 1 EmpID FROM tblEmployee ORDER BY EmpID DESC";
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            while (rs.next()) {
                idTmp = rs.getString("EmpID");
            }
            int index = Integer.parseInt(idTmp.substring(1)) + 1;
            if (index < 100) {
                idEmp = "E0" + index;
            } else {
                idEmp = "E" + index;
            }
        } finally {
            DBUtils.closeConnection(conn, psm);
        }
        return idEmp;
    }
}

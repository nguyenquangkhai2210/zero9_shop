/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.customer;

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
public class CustomerDAO implements Serializable {

    public static ArrayList<CustomerDTO> executeQuery(String query, Connection c) throws SQLException, NoSuchAlgorithmException {
        PreparedStatement psm = null;
        ResultSet rs = null;
        ArrayList<CustomerDTO> listCustomer = null;
        try {
            psm = c.prepareStatement(query);
            rs = psm.executeQuery();
            listCustomer = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("CusID");
                String username = rs.getString("CusUsername");
                String pass = rs.getString("CusPassword");
                String name = rs.getString("CusName");
                String phone = rs.getString("CusPhone");
                String mail = rs.getString("CusMail");
                String address = rs.getString("CusAddress");
                String gender = rs.getString("CusGender");
                String birthdate = rs.getString("CusBirthdate");
                String startdate = rs.getString("StartDate");
                int point = rs.getInt("Point");
                CustomerDTO customer = new CustomerDTO(id, username, pass, name, phone, mail, address, gender, birthdate, startdate, point);
                listCustomer.add(customer);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }
        }
        return listCustomer;
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

    public static boolean signUp(String username, String password, String email, String fullName, String phone, String gender, String address) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = shop.utils.DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "INSERT INTO tblCustomer(CusUsername, CusPassword, CusMail, CusName, CusPhone, CusGender, CusAddress, Point)"
                    + "Values(?,?,?,?,?,?,?,0)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setString(3, email);
            stm.setString(4, fullName);
            stm.setString(5, phone);
            stm.setString(6, gender);
            stm.setString(7, address);
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

    /**
     * This function is used to get profile of a customer who has
     * <i>username<i>.
     * <br>
     * Username of customer is unique key so you can use to find customer
     *
     * @param username: username in the database
     * @return CustomerDTO with all information except password is set to null
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws NoSuchAlgorithmException
     */
    public static CustomerDTO getCustomerProfile(String username) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        Connection c = null;
        PreparedStatement psm = null;
        CustomerDTO customer = null;
        ResultSet rs = null;
        try {
            c = shop.utils.DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "Select * from tblCustomer where CusUsername = ?";
            psm = c.prepareStatement(sql);
            psm.setString(1, username);
            rs = psm.executeQuery();
            String id = rs.getString("CusID");
            String cusName = rs.getString("CusName");
            String cusPhone = rs.getString("CusPhone");
            String cusMail = rs.getString("CusMail");
            String cusAddress = rs.getString("CusAddress");
            String cusGender = rs.getString("CusGender");
            String cusBirthdate = rs.getString("CusBirthdate");
            String startDate = rs.getString("StartDate");
            int point = rs.getInt("Point");
            customer = new CustomerDTO(id, username, "", cusName, cusPhone, cusMail, cusAddress, cusGender, cusBirthdate, startDate, point);
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
        return customer;
    }

}

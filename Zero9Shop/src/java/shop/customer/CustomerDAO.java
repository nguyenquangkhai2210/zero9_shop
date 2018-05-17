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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import shop.utils.DBUtils;

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
        ResultSet rs = null;
        String finalID = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        try {
            conn = shop.utils.DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sqlGetID = "SELECT TOP 1 CusID FROM tblCustomer ORDER BY CusID DESC";
            stm = conn.prepareStatement(sqlGetID);
            rs = stm.executeQuery();
            while (rs.next()) {
                String ID = rs.getString("CusID");
                int index = Integer.parseInt(ID.substring(1)) + 1;
                finalID = "C0" + index;
            }
            String sql = "INSERT INTO tblCustomer(CusID,CusUsername , CusPassword, CusMail, CusName, CusPhone, CusGender, CusAddress,StartDate, Point) Values (?,?,?,?,?,?,?,?,?,0)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, finalID);
            stm.setString(2, username);
            stm.setString(3, password);
            stm.setString(4, email);
            stm.setString(5, fullName);
            stm.setString(6, phone);
            stm.setString(7, gender);
            stm.setString(8, address);
            stm.setString(9, dtf.format(now));
            System.out.println(stm);
            int result = stm.executeUpdate();
            if (result > 0) {
                return true;
            }
        } finally {
            DBUtils.closeConnection(conn, stm, rs);
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
            DBUtils.closeConnection(c, psm, rs);
        }
        return customer;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.customer;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;

import shop.utils.DBUtils;

/**
 *
 * @author THANH HUNG
 */
public class CustomerDAO implements Serializable {

//    public static ArrayList<CustomerDTO> executeQuery(String query, Connection c) throws SQLException, NoSuchAlgorithmException {
//        PreparedStatement psm = null;
//        ResultSet rs = null;
//        ArrayList<CustomerDTO> listCustomer = null;
//        try {
//            psm = c.prepareStatement(query);
//            rs = psm.executeQuery();
//            listCustomer = new ArrayList<>();
//            while (rs.next()) {
//                String id = rs.getString("CusID");
//                String username = rs.getString("CusUsername");
//                String pass = rs.getString("CusPassword");
//                String name = rs.getString("CusName");
//                String phone = rs.getString("CusPhone");
//                String mail = rs.getString("CusMail");
//                String address = rs.getString("CusAddress");
//                String gender = rs.getString("CusGender");
//                String birthdate = rs.getString("CusBirthdate");
//                String startdate = rs.getString("StartDate");
//                int point = rs.getInt("Point");
//                CustomerDTO customer = new CustomerDTO(id, username, pass, name, phone, mail, address, gender, birthdate, startdate, point);
//                listCustomer.add(customer);
//            }
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (psm != null) {
//                psm.close();
//            }
//        }
//        return listCustomer;
//    }
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
                if (index < 100) {
                    finalID = "C0" + index;
                } else {
                    finalID = "C" + index;
                }
                // bug
            }
            String sql = "INSERT INTO tblCustomer(CusID,CusUsername , CusPassword, CusMail, CusName, CusPhone, CusGender, CusAddress,StartDate, Point) Values (?,?,?,?,?,?,?,?,?,0)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, finalID);
            stm.setString(2, username);
            stm.setString(3, password);
            stm.setString(4, email);
            fullName = new String(fullName.getBytes(), Charset.forName("UTF-8"));
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
     * <i>CusID<i>.
     * <br>
     * CusID of customer is unique key so you can use to find customer
     *
     * @param cusID: ID in the database
     * @return CustomerDTO with all information except password is set to null
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws NoSuchAlgorithmException
     */
    public static CustomerDTO getCustomerProfile(String cusID) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        Connection c = null;
        PreparedStatement psm = null;
        CustomerDTO customer = null;
        ResultSet rs = null;
        try {
            c = shop.utils.DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "Select * from tblCustomer WHERE CusID = ?";
            psm = c.prepareStatement(sql);
            psm.setString(1, cusID);
            rs = psm.executeQuery();
            while (rs.next()) {
                String cusUsername = rs.getString("CusUsername");
                String cusName = rs.getString("CusName");
                String cusPhone = rs.getString("CusPhone");
                String cusMail = rs.getString("CusMail");
                String cusAddress = rs.getString("CusAddress");
                String cusGender = rs.getString("CusGender");
                String cusBirthdate = rs.getString("CusBirthdate");
                String startDate = rs.getString("StartDate");
                int point = rs.getInt("Point");
                customer = new CustomerDTO(cusID, cusUsername, cusName, cusPhone, cusMail, cusAddress, cusGender, cusBirthdate, startDate, point);
            }

        } finally {
            DBUtils.closeConnection(c, psm, rs);
        }
        return customer;
    }

    public List<CustomerDTO> listCustomer() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<CustomerDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "SELECT TOP 12 * FROM tblCustomer";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String cusID = rs.getString("CusID");
                String cusUsername = rs.getString("CusUsername");
                String cusName = rs.getString("CusName");
                String cusPhone = rs.getString("CusPhone");
                String cusMail = rs.getString("CusMail");
                String cusAddress = rs.getString("CusAddress");
                String cusGender = rs.getString("CusGender");
                String cusBirthdate = rs.getString("CusBirthdate");
                String startDate = rs.getString("StartDate");
                int point = rs.getInt("Point");
                CustomerDTO tmp = new CustomerDTO(cusID, cusUsername, cusName, cusPhone, cusMail, cusAddress, cusGender, cusBirthdate, startDate, point);
                list.add(tmp);
            }
        } finally {
            DBUtils.closeConnection(conn, stm, rs);
        }
        return list;
    }

    public List<CustomerDTO> findByNameCustomer(String search) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<CustomerDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "SELECT * FROM tblCustomer WHERE CusName LIKE ?";
            stm = conn.prepareStatement(sql);
            search = new String(search.getBytes(), Charset.forName("UTF-8"));
            stm.setString(1, "%" + search + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                String cusID = rs.getString("CusID");
                String cusUsername = rs.getString("CusUsername");
                String cusName = rs.getString("CusName");
                String cusPhone = rs.getString("CusPhone");
                String cusMail = rs.getString("CusMail");
                String cusAddress = rs.getString("CusAddress");
                String cusGender = rs.getString("CusGender");
                String cusBirthdate = rs.getString("CusBirthdate");
                String startDate = rs.getString("StartDate");
                int point = rs.getInt("Point");
                CustomerDTO tmp = new CustomerDTO(cusID, cusUsername, cusName, cusPhone, cusMail, cusAddress, cusGender, cusBirthdate, startDate, point);
                list.add(tmp);
            }
        } finally {
            DBUtils.closeConnection(conn, stm, rs);
        }
        return list;
    }

    public static boolean updateCustomerProfile(String cusID, CustomerDTO cus) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        Connection c = null;
        PreparedStatement psm = null;
        try {
            c = shop.utils.DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "UPDATE tblCustomer SET CusName = ?, CusPhone = ?, CusMail = ?, CusAddress = ?, CusGender = ?, CusBirthdate = ? WHERE CusID = ?";
            psm = c.prepareStatement(sql);
            psm.setNString(1, cus.getCusName());
            psm.setString(2, cus.getCusPhone());
            psm.setString(3, cus.getCusMail());
            String adress = cus.getCusAddress();
            psm.setNString(4, adress);
            psm.setString(5, cus.getCusGender());
            psm.setString(6, cus.getCusBirthdate());
            psm.setString(7, cusID);
            int result = psm.executeUpdate();
            if (result > 0) {
                return true;
            }

        } finally {
            DBUtils.closeConnection(c, psm);
        }
        return false;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CustomerDTO;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PhuNDSE63159
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
            rs.close();
            psm.close();
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
            psm.close();
        }
        return result;
    }

}

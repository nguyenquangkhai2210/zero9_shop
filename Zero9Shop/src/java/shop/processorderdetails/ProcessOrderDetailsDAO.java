/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.processorderdetails;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PhuNDSE63159
 */
public class ProcessOrderDetailsDAO implements Serializable {

    public static ArrayList<ProcessOrderDetailsDTO> executeQuery(String query, Connection c) throws SQLException, NoSuchAlgorithmException {
        PreparedStatement psm = null;
        ResultSet rs = null;
        ArrayList<ProcessOrderDetailsDTO> listProcessOrderDetails = null;
        try {
            psm = c.prepareStatement(query);
            rs = psm.executeQuery();
            listProcessOrderDetails = new ArrayList<>();
            while (rs.next()) {
                String orderId = rs.getString("OrderID");
                String modifiedBy = rs.getString("ModifiedBy");
                String modifiedTime = rs.getString("ModifiedTime");
                String status = rs.getString("Status");
                String des = rs.getString("Description");
                ProcessOrderDetailsDTO processOrder = new ProcessOrderDetailsDTO(orderId, modifiedBy, modifiedTime, status, des);
                listProcessOrderDetails.add(processOrder);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }
            
        }
        return listProcessOrderDetails;
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

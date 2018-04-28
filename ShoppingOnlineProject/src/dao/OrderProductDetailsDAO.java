/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.OrderProductDetailsDTO;
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
public class OrderProductDetailsDAO implements Serializable {

    public static ArrayList<OrderProductDetailsDTO> executeQuery(String query, Connection c) throws SQLException, NoSuchAlgorithmException {
        PreparedStatement psm = null;
        ResultSet rs = null;
        ArrayList<OrderProductDetailsDTO> listOrderProductDetail = null;
        try {
            psm = c.prepareStatement(query);
            rs = psm.executeQuery();
            listOrderProductDetail = new ArrayList<>();
            while (rs.next()) {
                String orderId = rs.getString("OrderID");
                int quantity = rs.getInt("Quantity");
                String proId = rs.getString("ProID");
                OrderProductDetailsDTO orderproduct = new OrderProductDetailsDTO(orderId, proId, quantity);
                listOrderProductDetail.add(orderproduct);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }
            
        }
        return listOrderProductDetail;
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

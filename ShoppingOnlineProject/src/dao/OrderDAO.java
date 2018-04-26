/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.OrderDTO;
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
public class OrderDAO implements Serializable {

    public static ArrayList<OrderDTO> executeQuery(String query, Connection c) throws SQLException, NoSuchAlgorithmException {
        PreparedStatement psm = null;
        ResultSet rs = null;
        ArrayList<OrderDTO> listOrder = null;
        try {
            psm = c.prepareStatement(query);
            rs = psm.executeQuery();
            listOrder = new ArrayList<>();
            while (rs.next()) {
                String orderId = rs.getString("OrderID");
                String createdTime = rs.getString("CreatedTime");
                int point = rs.getInt("Point");
                boolean isAvaiable = rs.getBoolean("isAvailable");
                String code = rs.getString("Code");
                String cusId = rs.getString("CusID");
                OrderDTO order = new OrderDTO(orderId, createdTime, point, isAvaiable, code, cusId);
                listOrder.add(order);
            }
        } finally {
            rs.close();
            psm.close();
        }

        return listOrder;
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

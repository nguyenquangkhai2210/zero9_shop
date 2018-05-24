/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.order;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import shop.customer.CustomerDTO;
import shop.utils.DBUtils;

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
                double orderSum = rs.getFloat("Catefories");
                int point = rs.getInt("Point");
                boolean isAvaiable = rs.getBoolean("isAvailable");
                String code = rs.getString("Code");
                String cusId = rs.getString("CusID");
                OrderDTO order = new OrderDTO(orderId, createdTime, orderSum, point, isAvaiable, code, cusId);
                listOrder.add(order);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }

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
            if (psm != null) {
                psm.close();
            }
        }
        return result;
    }

    public static List<OrderDTO> listOrder() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<OrderDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "SELECT TOP 12 * FROM tblOrder";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            String orderId;
            String createdTime;
            double orderSum;
            int point;
            boolean isAvailable;
            String code;
            String cusId;
            while (rs.next()) {
                orderId = rs.getString("OrderId");
                createdTime = rs.getString("CreatedTime");
                orderSum = rs.getDouble("OrderSum");
                point = rs.getInt("Point");
                isAvailable = rs.getBoolean("isAvailable");
                code = rs.getString("Code");
                cusId = rs.getString("CusId");
                OrderDTO tmp = new OrderDTO(orderId, createdTime, orderSum, point, isAvailable, code, cusId);
                list.add(tmp);
            }
        } finally {
            DBUtils.closeConnection(conn, stm, rs);
        }
        return list;
    }

    public static CustomerDTO getCustomerByID(String cusID) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        CustomerDTO list = null;
        try {
            conn = DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "SELECT CusUsername FROM tblCustomer WHERE CusID = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, cusID);
            rs = stm.executeQuery();
            while (rs.next()) {
                String cusUsername = rs.getString("CusUsername");
                list = new CustomerDTO(cusID, cusUsername);
            }
        } finally {
            DBUtils.closeConnection(conn, stm, rs);
        }
        return list;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.product;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import shop.utils.DBUtils;

/**
 *
 * @author PhuNDSE63159
 */
public class ProductDAO implements Serializable {

    public static ArrayList<ProductDTO> executeQuery(String query, Connection c) throws SQLException, NoSuchAlgorithmException {
        PreparedStatement psm = null;
        ResultSet rs = null;
        ArrayList<ProductDTO> listProduct = null;
        try {
            psm = c.prepareStatement(query);
            rs = psm.executeQuery();
            listProduct = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("ProID");
                String name = rs.getString("ProName");
                String des = rs.getString("ProDescription");
                String cate = rs.getString("Categeries");
                float price = rs.getInt("ProPrice");
                int stock = rs.getInt("Stock");
                String createdTime = rs.getString("CreatedTime");
                boolean isActive = rs.getBoolean("isActive");
                int saleOff = rs.getInt("SaleOff");
                int point = rs.getInt("ReservedPoint");
                ProductDTO product = new ProductDTO(id, name, des, price, stock, cate, createdTime, isActive, saleOff, point);
                listProduct.add(product);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }
        }

        return listProduct;
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

    public List<ProductDTO> listProduct() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<ProductDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "SELECT TOP 12 * FROM tblProduct";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("ProID");
                String name = rs.getString("ProName");
                float price = rs.getInt("ProPrice");
                int stock = rs.getInt("Stock");
                Date createTime = rs.getDate("CreatedTime");
                String createTimeFormat = new SimpleDateFormat("yyyy-MM-dd").format(createTime);
                boolean isActive = rs.getBoolean("isActive");
                int saleOff = rs.getInt("SaleOff");
                String reseverdPoint = rs.getString("ReservedPoint");
                ProductDTO tmp = new ProductDTO(id, name, reseverdPoint, price, stock, name, createTimeFormat, isActive, saleOff, saleOff);
                list.add(tmp);
            }
        } finally {
            DBUtils.closeConnection(conn, stm, rs);
        }
        return list;
    }

    public ProductDTO getDetailProduct(String idPro) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ProductDTO result = null;
        try {
            conn = DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "SELECT * FROM tblProduct WHERE ProID = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, idPro);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("ProID");
                String name = rs.getString("ProName");
                String des = rs.getString("ProDescription");
                float price = rs.getInt("ProPrice");
                int stock = rs.getInt("Stock");
                String cate = rs.getString("Categories");
                boolean isActive = rs.getBoolean("isActive");
                Date createTime = rs.getDate("CreatedTime");
                String createTimeFormat = new SimpleDateFormat("yyyy-MM-dd").format(createTime);
                int saleOff = rs.getInt("SaleOff");
                int reservedPoint = rs.getInt("ReservedPoint");
                result = new ProductDTO(id, name, des, price, stock, cate, createTimeFormat, isActive, saleOff, reservedPoint);
            }
        } finally {
            DBUtils.closeConnection(conn, stm, rs);
        }
        return result;
    }

}

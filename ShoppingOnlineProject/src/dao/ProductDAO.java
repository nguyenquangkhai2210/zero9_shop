/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CustomerDTO;
import dto.ProductDTO;
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
                float price = rs.getInt("ProPrice");
                String image = rs.getString("ProImage");
                int stock = rs.getInt("Stock");
                String createdTime = rs.getString("CreatedTime");
                boolean isActive = rs.getBoolean("isActive");
                int saleOff = rs.getInt("SaleOff");
                int point = rs.getInt("ReservedPoint");
                ProductDTO product = new ProductDTO(id, name, des, price, image, stock, createdTime, isActive, saleOff, point);
                listProduct.add(product);
            }
        } finally {
            rs.close();
            psm.close();
        }

        return listProduct;
    }

    public static int executeUpdate(String query, Connection c) throws SQLException {
        PreparedStatement psm = c.prepareStatement(query);
        int result = psm.executeUpdate();
        return result;
    }

}

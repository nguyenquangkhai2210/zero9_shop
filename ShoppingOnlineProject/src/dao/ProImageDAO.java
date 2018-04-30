/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ProductImageDTO;
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
public class ProImageDAO {

    public static ArrayList<ProductImageDTO> executeQuery(String query, Connection c) throws SQLException, NoSuchAlgorithmException {
        PreparedStatement psm = null;
        ResultSet rs = null;
        ArrayList<ProductImageDTO> listProductImage = null;
        try {
            psm = c.prepareStatement(query);
            rs = psm.executeQuery();
            listProductImage = new ArrayList<>();
            while (rs.next()) {
                String proId = rs.getString("ProID");
                String proImage = rs.getString("ProImage");
                ProductImageDTO p = new ProductImageDTO(proId, proImage);
                listProductImage.add(p);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }
        }

        return listProductImage;
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

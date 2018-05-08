/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.productmodificationhistory;

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
public class ProductModificationHistoryDAO implements Serializable {

    public static ArrayList<ProductModificationHistoryDTO> executeQuery(String query, Connection c) throws SQLException, NoSuchAlgorithmException {
        PreparedStatement psm = null;
        ResultSet rs = null;
        ArrayList<ProductModificationHistoryDTO> listProductModificationHistory = null;
        try {
            psm = c.prepareStatement(query);
            rs = psm.executeQuery();
            listProductModificationHistory = new ArrayList<>();
            while (rs.next()) {
                String proId = rs.getString("ProID");
                String modifiedBy = rs.getString("ModifiedBy");
                String modifiedTime = rs.getString("ModifiedTime");
                String des = rs.getString("Description");
                ProductModificationHistoryDTO proHis = new ProductModificationHistoryDTO(proId, modifiedBy, modifiedTime, des);
                listProductModificationHistory.add(proHis);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }
        }
        return listProductModificationHistory;
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

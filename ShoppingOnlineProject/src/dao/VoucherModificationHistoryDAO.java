/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.VoucherModificationHistoryDTO;
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
public class VoucherModificationHistoryDAO implements Serializable {

    public static ArrayList<VoucherModificationHistoryDTO> executeQuery(String query, Connection c) throws SQLException, NoSuchAlgorithmException {
        ArrayList<VoucherModificationHistoryDTO> listVoucherModificationHistory = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            psm = c.prepareStatement(query);
            rs = psm.executeQuery();
            listVoucherModificationHistory = new ArrayList<>();
            while (rs.next()) {
                String code = rs.getString("Code");
                String modifiedBy = rs.getString("ModifiedBy");
                String modifiedTime = rs.getString("ModifiedTime");
                String des = rs.getString("Description");
                VoucherModificationHistoryDTO voucherModiHis = new VoucherModificationHistoryDTO(code, modifiedBy, modifiedTime, des);
                listVoucherModificationHistory.add(voucherModiHis);
            }
        } finally {
            rs.close();
            psm.close();
        }
        return listVoucherModificationHistory;
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

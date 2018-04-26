/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.OrderDTO;
import dto.VoucherDTO;
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
public class VoucherDAO implements Serializable {

    public static ArrayList<VoucherDTO> executeQuery(String query, Connection c) throws SQLException, NoSuchAlgorithmException {
        PreparedStatement psm = null;
        ResultSet rs = null;
        ArrayList<VoucherDTO> listVoucher = null;
        try {
            psm = c.prepareStatement(query);
            rs = psm.executeQuery();
            listVoucher = new ArrayList<>();
            while (rs.next()) {
                String code = rs.getString("Code");
                int saleOff = rs.getInt("SaleOff");
                boolean isActive = rs.getBoolean("isActive");
                String createdTime = rs.getString("CreatedTime");
                String endedTime = rs.getString("EndedTime");
                String type = rs.getString("Type");
                String cusId = rs.getString("CusID");
                VoucherDTO v = new VoucherDTO(code, saleOff, isActive, createdTime, endedTime, type, cusId);
                listVoucher.add(v);
            }
        } finally {
            rs.close();
            psm.close();
        }

        return listVoucher;
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

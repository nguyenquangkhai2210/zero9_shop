/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.voucher;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import shop.product.ProductDTO;
import shop.utils.DBUtils;

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
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }
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

            if (psm != null) {
                psm.close();
            }
        }
        return result;
    }

    public List<VoucherDTO> listVoucher() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<VoucherDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "SELECT TOP 12 * FROM tblVoucher";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String code = rs.getString("Code");
                int saleOff = rs.getInt("SaleOff");
                boolean isActive = rs.getBoolean("isActive");
                Date time = rs.getDate("CreatedTime");
                String createTimeFormat = new SimpleDateFormat("yyyy-MM-dd").format(time);
                time = rs.getDate("EndedTime");
                String endedTimeFormat = new SimpleDateFormat("yyyy-MM-dd").format(time);
                String type = rs.getString("Type");
                VoucherDTO tmp = new VoucherDTO(code, saleOff, isActive, createTimeFormat, endedTimeFormat, type);
                list.add(tmp);
            }
        } finally {
            DBUtils.closeConnection(conn, stm, rs);
        }
        return list;
    }

    public VoucherDTO getDetailProduct(String idVoucher) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        VoucherDTO result = null;
        try {
            conn = DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "";
            stm = conn.prepareStatement(sql);
            stm.setString(1, idVoucher);
            rs = stm.executeQuery();
            while (rs.next()) {

            }
        } finally {
            DBUtils.closeConnection(conn, stm, rs);
        }
        return result;
    }
}

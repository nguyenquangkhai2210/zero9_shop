/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.role;

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
public class RoleDAO implements Serializable {

    public static ArrayList<RoleDTO> executeQuery(String query, Connection c) throws SQLException, NoSuchAlgorithmException {
        PreparedStatement psm = null;
        ResultSet rs = null;
        ArrayList<RoleDTO> listRole = null;
        try {
            psm = c.prepareStatement(query);
            rs = psm.executeQuery();
            listRole = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("RoleID");
                String name = rs.getString("RoleName");
                String des = rs.getString("RoleDescription");
                RoleDTO r = new RoleDTO(id, name, des);
                listRole.add(r);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }

        }
        return listRole;
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

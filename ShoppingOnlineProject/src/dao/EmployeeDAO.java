/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.EmployeeDTO;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PhuNDSE63159
 */
public class EmployeeDAO implements Serializable {

    public static ArrayList<EmployeeDTO> executeQuery(String query, Connection c) throws SQLException, NoSuchAlgorithmException {
        PreparedStatement psm = null;
        ResultSet rs = null;
        ArrayList<EmployeeDTO> listEmp = null;
        try {
            psm = c.prepareStatement(query);
            rs = psm.executeQuery();
            listEmp = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("EmpID");
                String username = rs.getString("EmpUsername");
                String pass = rs.getString("EmpPassword");
                String name = rs.getString("EmpName");
                String phone = rs.getString("EmpPhone");
                String mail = rs.getString("EmpMail");
                String address = rs.getString("EmpAddress");
                String gender = rs.getString("EmpGender");
                String birthdate = rs.getString("EmpBirthdate");
                String startdate = rs.getString("StartDate");
                String enddate = rs.getString("EndDate");
                String role = rs.getString("RoleID");
                EmployeeDTO emp = new EmployeeDTO(id, username, pass, name, phone, mail, address, gender, birthdate, startdate, enddate, role);
                listEmp.add(emp);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }

        }
        return listEmp;
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

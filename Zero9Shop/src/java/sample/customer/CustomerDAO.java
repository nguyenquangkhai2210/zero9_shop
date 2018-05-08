/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.customer;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author THANH HUNG
 */
public class CustomerDAO implements Serializable {

    public boolean signUp(String username, String password, String email, String fullName, String phone, String gender, String address) {
        try {
            Connection conn = sample.utils.DBUtils.getConnection("sa", "sa", "SHOPPINGONLINE");
            String sql = "INSERT INTO tblCustomer(CusUsername, CusPassword, CusMail, CusName, CusPhone, CusGender, CusAddress, Point)"
                    + "Values(?,?,?,?,?,?,?,0)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setString(3, email);
            stm.setString(4, fullName);
            stm.setString(5, phone);
            stm.setString(6, gender);
            stm.setString(7, address);
            int result = stm.executeUpdate();
            stm.close();
            conn.close();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import connection.MyConnection;
import dao.CustomerDAO;
import dao.EmployeeDAO;
import dao.OrderDAO;
import dao.OrderProductDetailsDAO;
import dao.ProductDAO;
import dto.CustomerDTO;
import dto.EmployeeDTO;
import dto.OrderDTO;
import dto.OrderProductDetailsDTO;
import dto.ProductDTO;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PhuNDSE63159
 */
public class Test {

    public static void main(String[] args) {
        try {
            String user = "sa";
            String pass = "281176504";
            String databaseName = "SHOPPINGONLINE";
            Connection c = MyConnection.getConnection(user, pass, databaseName);
            String query = "Select * from tblproduct";
            ArrayList<ProductDTO> list = ProductDAO.executeQuery(query, c);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           
        }
    }

}

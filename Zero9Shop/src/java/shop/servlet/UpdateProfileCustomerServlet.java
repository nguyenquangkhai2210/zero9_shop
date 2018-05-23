/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shop.customer.CustomerDAO;
import shop.customer.CustomerDTO;

/**
 *
 * @author THANH HUNG
 */
public class UpdateProfileCustomerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String cusID = request.getParameter("idCus");
        String cusName = request.getParameter("txtName");
        String cusMail = request.getParameter("txtMail");
        String cusGender = request.getParameter("txtGender");
        String cusAddress = request.getParameter("txtAddress");
//        cusAddress = new String(cusAddress.getBytes("UTF-8"), "ISO-8859-1");

        String cusPhone = request.getParameter("txtPhone");
        String cusBirthdate = request.getParameter("txtBirthdate");
        try {
            CustomerDTO cus = new CustomerDTO(cusName, cusPhone, cusMail, cusAddress, cusGender, cusBirthdate);
            boolean result = CustomerDAO.updateCustomerProfile(cusID, cus);
            if (result) {
                RequestDispatcher rd = request.getRequestDispatcher("ViewProfileCustomerServlet");
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException | NoSuchAlgorithmException ex) {
            Logger.getLogger(UpdateProfileCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

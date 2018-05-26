/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import shop.employee.EmployeeDAO;
import shop.employee.EmployeeDTO;

/**
 *
 * @author THANH HUNG
 */
public class LoginServlet extends HttpServlet {

    final static String orderPage = "ViewOrderServlet";
    final static String loginPage = "login.jsp";

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
        PrintWriter out = response.getWriter();
        String url = loginPage;
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String idEmp = EmployeeDAO.getIdEmployee();
            request.setAttribute("idEmp", idEmp);
            request.setAttribute("dateCurrent", dateFormat.format(new Date()));
            boolean result = EmployeeDAO.checkLogin(username, password);
            if (result) {
                url = orderPage;
                HttpSession session = request.getSession();
                EmployeeDTO emp =  EmployeeDAO.getEmployeeProfileWithUsernam(username);
                session.setAttribute("loginUser", emp);
            } 
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (ClassNotFoundException | SQLException | NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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

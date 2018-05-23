/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author THANH HUNG
 */
public class MainControllerServlet extends HttpServlet {

    final static String signUpPage = "signUp.jsp";
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
        try {
            String button = request.getParameter("btAction");
            String url = null;
            if (null == button) {
                //
            } else {
                switch (button) {
                    case "Login":
                        url = "LoginServlet";
                        break;
                    case "SignUp":
                        url = "SignUpServlet";
                        break;
                    case "Logout":
                        url = "LogoutServlet";
                        break;
                    case "Product":
                        url = "ViewProductServlet";
                        break;
                    case "Customer":
                        url = "ViewCustomerServlet";
                        break;
                    case "Employee":
                        url = "ViewEmployeeServlet";
                        break;
                    case "Order":
                        url = "ViewOrderServlet";
                        break;
                    case "Promotion":
                        url = "ViewPromotionServlet";
                        break;
                    case "ChangePassword":
                        url = "ChangePasswordServlet";
                        break;
                    case "SearchProduct":
                        url = "SearchProductServlet";
                        break;
                    case "SearchEmployee":
                        url = "SearchEmployeeServlet";
                    case "SearchCustomer":
                        url = "SearchCustomerServlet";
                    default:
                        break;

                }
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }
        } catch (Exception e) {

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

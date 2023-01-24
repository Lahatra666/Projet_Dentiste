
package controller;

import dao.Admin_dao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;

/**
 *
 * @author PC
 */
public class Admin_controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        login(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	   PrintWriter out = response.getWriter();
           String email = request.getParameter("email");
           String password = request.getParameter("password");
           boolean approved = Admin_dao.LoginAdmin(email,password);
           if(approved==true) {
               HttpSession session = request.getSession();
               Admin admin = new Admin(email,password);
               session.setAttribute("admin", admin);
               response.sendRedirect(request.getContextPath() + "/Accueiladmin.jsp");
               /*RequestDispatcher rd = request.getRequestDispatcher("/Landing_controller");
               rd.forward(request, response);*/
           }
           else if(approved==false) {
               out.println(approved);
           }
    }

}
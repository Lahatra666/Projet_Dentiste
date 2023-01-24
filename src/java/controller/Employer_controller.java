
package controller;

import dao.Employer_dao;
import model.Employer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author itu
 */

public class Employer_controller extends HttpServlet {
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listEmp(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
        insertemp(request, response);
    }
    private void insertemp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	   PrintWriter out = response.getWriter();
           String nom = request.getParameter("nom");
           String prenom = request.getParameter("prenom");
           String birth =request.getParameter("date_naissance");
           int genre = Integer.parseInt(request.getParameter("genre"));
       
           boolean approved = Employer_dao.insert_Employer(nom,prenom,birth,genre);
           if(approved==true) {
               HttpSession session = request.getSession();
               Employer emp = new Employer(nom,prenom,birth,genre);
               session.setAttribute("emp", emp);
               response.sendRedirect(request.getContextPath() + "/Specialite.jsp");
               /*RequestDispatcher rd = request.getRequestDispatcher("/Landing_controller");
               rd.forward(request, response);*/
           }
           else if(approved==false) {
               out.println(approved);
           }
    }	
         private void listEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    List<Employer> produits = Employer_dao.selectAllEmp();
        request.setAttribute("employer", produits);
        RequestDispatcher rd = request.getRequestDispatcher("/employer.jsp");
        rd.forward(request, response);
	}
}

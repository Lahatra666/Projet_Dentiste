/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Employer_dao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Employer;

/**
 *
 * @author PC
 */
public class Specialite_controller extends HttpServlet {

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
        insertcritere(request, response);
    }
 private void insertcritere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	   PrintWriter out = response.getWriter();
           int idniveaux = Integer.parseInt(request.getParameter("niveaux"));
           int salaire = Integer.parseInt(request.getParameter("salaire"));
           int[] spec=null;
           String[] specialites= request.getParameterValues("specialite");
           boolean approved = Employer_dao.insert_Specialite(specialites);
           out.println(specialites);
         // for(int isa=0;isa<specialites.length;isa++){;;
          //  spec[isa]=Integer.parseInt(specialites[isa]);
         // }
           // boolean approved = Employer_dao.insert_Employer(nom,prenom,birth,genre);
           if(approved==true) {
               Employer_dao.insert_Critere(idniveaux, salaire);
               HttpSession session = request.getSession();
             // Employer emp = new Employer(nom,prenom,birth,genre);
//               session.setAttribute("emp", emp);
               response.sendRedirect(request.getContextPath() + "/Accueiladmin.jsp");
               //RequestDispatcher rd = request.getRequestDispatcher("/Landing_controller");
               //rd.forward(request, response);
           }
           else if(approved==false) {
               out.println(approved);
           }
    }
}


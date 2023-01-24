/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Employer_dao;
import dao.Service_dao;
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
public class Service_controller extends HttpServlet {


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
        listEmp(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        benefice(request, response);
    }

     private void benefice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	   PrintWriter out = response.getWriter();
           String idservice = request.getParameter("service");
           String[] employer = request.getParameterValues("employer");
           String[] demployer = request.getParameterValues("demployer");
           String[] nommateriel = request.getParameterValues("materiel");
           String[] prixmateriel = request.getParameterValues("prixmateriel");
           String[] nombremateriel = request.getParameterValues("nombremateriel");
           int marge = Integer.parseInt(request.getParameter("marge"));
           int nombre = Integer.parseInt(request.getParameter("nombre"));
           double salaire = Service_dao.Salaire(employer, demployer);
           double materiaux = Service_dao.Materiaux(nommateriel, prixmateriel,nombremateriel);
           double depense = salaire+materiaux;
           double prix_vente = (((marge*depense)/100)+depense)*nombre;
           double benefice=prix_vente-(depense*nombre);
           out.println("Benefice : "+benefice);
           out.println("Depense : "+depense);
           out.println("Marge : "+marge);
           out.println("Prix de vente : "+prix_vente);
    }

     private void listEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    List<Employer> produits = Employer_dao.selectAllEmp();
        request.setAttribute("employer", produits);
        RequestDispatcher rd = request.getRequestDispatcher("/service.jsp");
        rd.forward(request, response);
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Employer {
    int idEmployer;
    String nom;
    String prenom;
    String date_naissance;
    int genre;
    int niveau;
    String nomniveaux;
    int salaire;

    public Employer(int idemp, String name, String prenom, int idgenre, int idniveaux, int salaire) {
        this.idEmployer = idemp;
        this.nom = name;
        this.prenom = prenom;
        this.genre = idgenre;
        this.niveau = idniveaux;
        this.salaire = salaire;
    }

    public String getNomniveaux() {
        return nomniveaux;
    }

    public void setNomniveaux(String nomniveaux) {
        this.nomniveaux = nomniveaux;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public Employer(int idEmployer, String nom, String prenom, String date_naissance, String nomniveaux, int salaire) {
        this.idEmployer = idEmployer;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.nomniveaux = nomniveaux;
        this.salaire = salaire;
    }
    

    public Employer(int idEmployer, String nom, String prenom, String date_naissance, int genre, int niveau) {
        this.idEmployer = idEmployer;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.genre = genre;
        this.niveau = niveau;
    }

    public Employer(String nom, String prenom, String date_naissance, int genre, int niveau) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.genre = genre;
        this.niveau = niveau;
    }
        public Employer(String nom, String prenom, String date_naissance, int genre) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.genre = genre;
    }

    public int getIdEmployer() {
        return idEmployer;
    }

    public void setIdEmployer(int idEmployer) {
        this.idEmployer = idEmployer;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date date1= sdf.parse(date_naissance);
            Date date2=Employer.calculateDOB(18);
            if(date1.before(date2)){
                this.date_naissance = date_naissance;
                //System.out.println("majeur");
            }
            else{
                System.out.println("error");
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(Employer.class.getName()).log(Level.SEVERE, null, ex);
        }
      
     
    }
    
  public static Date calculateDOB(int age) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        calendar.set(Calendar.YEAR, currentYear - age);
        return calendar.getTime();
    }
  
    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public Employer() {
    }
   

}

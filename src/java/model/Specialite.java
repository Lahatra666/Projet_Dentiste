/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author PC
 */
public class Specialite {
    int idemployer;
    String[] specialite;
    int idniveaux;
    int salaire;

    public Specialite(int idemployer, String[] specialite, int idniveaux, int salaire) {
        this.idemployer = idemployer;
        this.specialite = specialite;
        this.idniveaux = idniveaux;
        this.salaire = salaire;
    }

    public Specialite(String[] specialite, int idniveaux, int salaire) {
        this.specialite = specialite;
        this.idniveaux = idniveaux;
        this.salaire = salaire;
    }

    public Specialite() {
    }

    public int getIdemployer() {
        return idemployer;
    }

    public void setIdemployer(int idemployer) {
        this.idemployer = idemployer;
    }

    public String[] getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String[] specialite) {
        this.specialite = specialite;
    }

    public int getIdniveaux() {
        return idniveaux;
    }

    public void setIdniveaux(int idniveaux) {
        this.idniveaux = idniveaux;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }
    
}

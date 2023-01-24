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
public class Admin {
    int idAdmin;
    String email;
    String mdp;

    public Admin(int idAdmin, String email, String mdp) {
        this.idAdmin = idAdmin;
        this.email = email;
        this.mdp = mdp;
    }

    public Admin(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
}

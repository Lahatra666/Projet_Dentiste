/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.Connectdb;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employer;

/**
 *
 * @author PC
 */
public class Employer_dao {
     public static boolean insert_Employer(String nom,String prenom,String date_naissance,int id_genre)
    {
        boolean val=false;
         SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
        try {
            java.util.Date date1= sdf.parse(date_naissance);
            java.util.Date date2=Employer.calculateDOB(18);
            if(date1.before(date2)){
                String sql ="INSERT INTO Employer(nom,prenom,date_naissance,id_genre)"
                + "values('"+nom+"','"+prenom+"','"+date_naissance+"',"+id_genre+")";
                Connectdb con = new Connectdb();
                PreparedStatement ps = null;
                System.out.println(sql);
            try{
            //stmt = con.getStatement();
           // stmt.executeQuery(sql);
           ps=con.cnt.prepareStatement(sql);
           int x=ps.executeUpdate();
            con.fermer();
           // stmt.close();
            
             val=true;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            val=false;
        }
            }
            else{
                System.out.println("Tsy ampy taona");
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(Employer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return val;
    }
       public static boolean insert_Critere(int idniveaux,int salaire)
    {
        String sql ="UPDATE employer set id_niveaux="+idniveaux+",salaire="+salaire+""
                + " where id_employer in (select max(id_employer) from employer)";
        Connectdb con = new Connectdb();
        PreparedStatement ps = null;
        System.out.println(sql);
        try{
            //stmt = con.getStatement();
           // stmt.executeQuery(sql);
           ps=con.cnt.prepareStatement(sql);
           int x=ps.executeUpdate();
            con.fermer();
           // stmt.close();
            
            return true;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
         public static boolean insert_Specialite(String[] specialite)
    {
        boolean vali=false;
        for(int i=0;i<specialite.length;i++){
                    String sql ="insert into EmployerSpecialite(id_employer,id_specialite) values((select max(id_employer) from employer),"+specialite[i]+")";
        Connectdb con = new Connectdb();
        PreparedStatement ps = null;
        System.out.println(sql);
        try{
            //stmt = con.getStatement();
           // stmt.executeQuery(sql);
           ps=con.cnt.prepareStatement(sql);
           int x=ps.executeUpdate();
            con.fermer();
           // stmt.close();
            
            vali=true;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            vali=false;
        }
        }
        return vali;
    }
	private static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println(((SQLException) e).getSQLState() + "SQLState: ");
				System.err.println(((SQLException) e).getErrorCode() + "Error Code: ");
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
    public static List<Employer> selectAllEmp() {
	List<Employer> users = new ArrayList<>();
		// Step 1: Establishing a Connection
                Connectdb con = new Connectdb();
		try (Connection connection = con.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT*FROM employer join niveaux on employer.id_niveaux=niveaux.id_niveaux");) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs;
                        rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id_employer");
				String name = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String date_naissance = rs.getString("date_naissance");
                                int salaire = rs.getInt("salaire");
                                String niveaux = rs.getString("nomniveaux");
				users.add(new Employer(id, name, prenom, date_naissance,niveaux,salaire));
                               System.out.println(name);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
    }
        
    /* public static void main(String[] args) {
     Employer_dao a=new Employer_dao();
   //  String[] table={"1","2","3"};
     a.selectAllEmp();
    } */

}

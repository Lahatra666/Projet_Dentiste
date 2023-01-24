/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools,Templates
 * and open the template in the editor.
 */
package dao;

import database.Connectdb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Employer;

/**
 *
 * @author PC
 */
public class Service_dao {
    
    public static int CalculePrix(int totalmateriel,String idemployer,String idservice,int dureemp,int marge){
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Employer> users = new ArrayList<>();
                int finalprice=0;
                int ph = 0;
                int benefice;
		// Step 1: Establishing a Connection
                Connectdb con = new Connectdb();
		try (Connection connection = con.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT*FROM employer where id_employer="+idemployer);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs;
                        rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int idemp = rs.getInt("id_employer");
				String name = rs.getString("nom");
				String prenom = rs.getString("prenom");
                                int idgenre = rs.getInt("id_genre");
                                int idniveaux = rs.getInt("id_niveaux");
                                int salaire = rs.getInt("salaire");
				users.add(new Employer(idemp, name, prenom, idgenre,idniveaux,salaire));
                                ph = (salaire*dureemp);
                                //System.out.println(name);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
                benefice = (((totalmateriel+ph)*marge)/100);
                finalprice = totalmateriel+ph+(((totalmateriel+ph)*marge)/100);
		System.out.println(finalprice+" ben:"+(((totalmateriel+ph)*marge)/100));
                
                return benefice;
	}
    
    public static int[] StringArrtoIntArr(String[] s){
    int[] result = new int[s.length];
    for(int i = 0;i<s.length;i++){
        result[i] = Integer.parseInt(s[i]);
    }
    return result;
    }
    
         public static double Salaire(String[] idemployer,String[] heure){
            double benefice=0;
            int[] salaires=null;  
            int[] heures = Service_dao.StringArrtoIntArr(heure);
            for(int i=0;i<idemployer.length;i++){
                Connectdb con = new Connectdb();
		try (Connection connection = con.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT*FROM employer where id_employer="+idemployer[i]+"");) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs;
                        rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id_employer");
				int salaire = rs.getInt("salaire");
                           	///users.add(new Employer(id, name, prenom, date_naissance,niveaux,salaire));
                               
                                benefice+=(salaire*heures[i]);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
            }
                System.out.println(benefice);
                return benefice;
	}
        public static double Materiaux(String[] nommateriaux,String[] prix,String nombre[]){
            double benefice=0;
            int[] salaires=null;
            int[] prixs=Service_dao.StringArrtoIntArr(prix);
            int[] nombres=Service_dao.StringArrtoIntArr(nombre);
            for(int i=0;i<nommateriaux.length;i++){
                benefice += (prixs[i]*nombres[i]);
            }
            System.out.println(benefice);
            return benefice;
  	}
 /* public static void main(String[] args) {
       String[] idemp={"2","1"};
        int[] heure= {1,3};
        int[] nombre={1,3};
        Service_dao.Materiaux(idemp, heure,nombre);
    }*/
}

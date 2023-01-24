/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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

/**
 *
 * @author PC
 */
public class Admin_dao {
        public static boolean LoginAdmin(String email,String password){
		// using try-with-resources to avoid closing resources (boiler plate code)
		boolean valiny = false;
                String sql="SELECT email, passwords FROM Admins where email='"+email+"' and passwords='"+password+"'";
		// Step 1: Establishing a Connection
                Connectdb con = new Connectdb();
		try (Connection connection = con.getConnection();

		// Step 2:Create a statement using connection object
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs;
                        rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
            while(rs.next())
            {
                if((email.compareTo(rs.getString(1)) == 0) && password.compareTo(rs.getString(2)) == 0)
                {
                    valiny = true;
                }
                else{
                    valiny=false;
                }
            }
		}catch(SQLException e) {
			e.printStackTrace();
                        valiny=false;
		}
                System.out.println(valiny);
		return valiny;
	}
   /*  public static void main(String[] args) {
     Admin_dao a=new Admin_dao();
     a.LoginAdmin("Admin@gmail.","mpd");
    } */
}

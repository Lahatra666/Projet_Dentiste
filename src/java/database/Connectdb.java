package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Connectdb {
     
    public Connection cnt;
    private Statement stm;
    private ResultSet res;
    
    public Connectdb(){
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("org.postgresql.Driver");
            this.cnt=DriverManager.getConnection("jdbc:postgresql://localhost/dentiste","postgres","071204");
            this.stm = this.cnt.createStatement();
            
            if(this.cnt == null)
                System.out.println("non connecte");
            else
                System.out.println("connecte");
        }
    catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
            Logger.getLogger(Connectdb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   /* public Connectdb(String string, String user, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public ResultSet getResultset(){
        return this.res;
    }
    
      public static Connection getConnection() {
          try  {
            Class.forName("org.postgresql.Driver");
              Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/dentiste","postgres","071204");
              return con;
          }
          catch(Exception ex) {
              System.out.println("Database.getConnection() Error -->" + ex.getMessage());
              return null;
          }
      }
 
       public static void close(Connection con) {
          try  {
              con.close();
          }
          catch(Exception ex) {
          }
      }
    
    public Statement getStatement(){
        return this.stm;
    }
    
    public void fermer(){
        try{
            cnt.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
   /* public static void main(String[] args) throws SQLException, ClassNotFoundException {
     Connectdb a=new Connectdb();
     a.getConnection();
    } */
}
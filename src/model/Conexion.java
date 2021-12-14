package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    	private static Connection con = null;
	
	private static final String url = "jdbc:postgresql://localhost/sistema_multas";
	private static final String usr = "postgres";
	private static final String pss = "Pepepecas08*";
	
	public static Connection getConnection() throws SQLException {
		  try {
			  if(con==null) {
				  
				  Runtime.getRuntime().addShutdownHook(new MiShDwnHook());
				 
					    Class.forName("org.postgresql.Driver");
					
						con=DriverManager.getConnection(url,usr,pss);
			      }
			     
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("X:"+e.getMessage());
					System.out.println("Y:"+e.getSQLState());
					//e.printStackTrace();
				} 
				  
			  return con;
	}
	
	  static class MiShDwnHook extends Thread{
		  
                  @Override
		  public void run() {
			  try {
                              Connection con=Conexion.getConnection();
                              System.out.println("Conectado");
                              try {
                                  con.close();
                                  System.out.println("Desconectado");
                              } catch (SQLException e) {
                                  // TODO Auto-generated catch block
                                  e.printStackTrace();
                                  System.out.println("Error 1");
                              }
                          } catch (SQLException ex) {
				Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                                System.out.println("Error 2");
			}
		  }
	  }
    
}

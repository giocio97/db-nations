package nations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)throws SQLException {
		// TODO Auto-generated method stub
		
		 String url = "jdbc:mysql://localhost:3306/nations";
		  String user = "root";
		  String password = "";
		  Scanner s=new Scanner(System.in);
		  
		  try (Connection con = DriverManager.getConnection(url, user, password)){
			  
			  System.out.println("Connessione effettuata con successo ");
//			  String email=s.nextLine();
//			  System.out.print("Inserisci la tua password: ");
//			  String pwd=s.nextLine();
			  
			  String sql="SELECT c.name , c.country_id,r.name, c2.name  FROM nations.countries c\n"
			  		+ "INNER JOIN nations.regions r \n"
			  		+ "ON c.region_id = r.region_id \n"
			  		+ "INNER JOIN nations.continents c2 \n"
			  		+ "ON r.continent_id =c2.continent_id \n"
			  		+ "ORDER BY c.name ";
			 
			  try(PreparedStatement ps=con.prepareStatement(sql)) {
					 // ps.setString(1, email);
					 // ps.setString(2, pwd);
					 
					  
				  try(ResultSet rs =ps.executeQuery()) {
						
					  System.out.println("NOME STATO \t\t ID STATO \t\t NOME REGIONE \t\t NOME CONTINENTE");
						 
					  while (rs.next()) { 
							  System.out.println(
									  
												rs.getString(1) + "\t\t" +
												rs.getInt(2) + "\t\t" +
												rs.getString(3) + "\t\t\t" +
												rs.getString(4)
										);
							 					  
						  } 
					  }
					  
				  }
			  } catch (SQLException ex) {
			     ex.printStackTrace();
			  }

		}

	}
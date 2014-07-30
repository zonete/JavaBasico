package banco;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection getConnection(){		
		try{
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21","root",""); 
		}catch(Exception erro){
			System.out.println("Erro Classe ConnectionFactory");
			throw new RuntimeException();
		}				
	} 

}

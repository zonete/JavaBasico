package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import dao.ContatoDao;
import modelo.Contato;

public class Teste {
	public static void main (String[] args){
		System.out.println("Inicio Teste");
		try{
			//Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/fj21","root","");
			/*Connection conexao = new ConnectionFactory().getConnection();
			System.out.println("Conectado");
			conexao.close();
			System.out.println("Fechou Conexão");*/
			
			//Teste incluir contatos
			Contato contato = new Contato();
			contato.setNome("Luis A");
			Calendar dataNas = Calendar.getInstance();
			dataNas.set(Calendar.YEAR,1990);
			dataNas.set(Calendar.MONTH,Calendar.OCTOBER);
			dataNas.set(Calendar.DAY_OF_MONTH,25);
			contato.setDataNascimento(dataNas);
			contato.setEmail("LA@gmail.com");
			contato.setEndereco("Rua das s");
			
			ContatoDao contatoDao = new ContatoDao();
			contatoDao.adiciona(contato);
			System.out.println("Gravado");
			
			System.out.println("NOME : DATANASCIMENTO");
			for (Contato c : contatoDao.getLista()) {
				SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println(c.getNome()+ " : " + dt.format(c.getDataNascimento().getTime()));				
			}
			
			
			
			
		}catch(Exception erroconection){
			System.out.println("\n Ocorreu um erro na conexao \n " + erroconection.getMessage());
		}
	} 
}

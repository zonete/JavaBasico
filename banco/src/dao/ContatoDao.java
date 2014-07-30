package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

import com.mysql.fabric.xmlrpc.base.Data;

import modelo.Contato;
import banco.ConnectionFactory;

public class ContatoDao {
	private Connection conexao;
	
	public ContatoDao(){
		this.conexao = new ConnectionFactory().getConnection();
	}
	public void adiciona(Contato contato){
		String sql = "insert into contatos(nome,email,endereco,dataNascimento) values (?,?,?,?)";
		PreparedStatement stmt ;
		try{
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());			
			stmt.setDate(4, contato.getDataNascimentoDate());
			System.out.println("\n data -> " + contato.getDataNascimentoDate().toString() );
			stmt.execute();	
			stmt.close();
			
		}catch(Exception e){
			throw new RuntimeException(e);
			
		}
	}
	
	public List<Contato> getLista(){
		List<Contato> lista = new ArrayList<Contato>();
		try{
			
			String sql = "select * from contatos"; 
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			Contato contato;
			while(resultado.next()){
				contato = new Contato();
				contato.setId(resultado.getLong("id"));
				contato.setNome(resultado.getString("nome"));
				contato.setEmail(resultado.getString("email"));
				contato.setEndereco(resultado.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(resultado.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				lista.add(contato);
				
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}		
		
		return lista;
	}
}

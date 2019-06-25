package br.com.sensorproject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	
	public static Connection getConexao(){
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","aluno");
			System.out.println("Conectou!!!");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}

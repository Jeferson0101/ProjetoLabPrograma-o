package br.com.sensorproject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	
	public static Connection getConexao(){
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:postgresql://35.247.192.138:5432/postgres","postgres","123");
			System.out.println("Conectou!!!");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}

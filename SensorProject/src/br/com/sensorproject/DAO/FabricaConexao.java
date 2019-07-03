package br.com.sensorproject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	
	public static Connection getConexao(){
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:postgresql://pesquisa02.lages.ifsc.edu.br:5432/thingsboard","postgres","pesquisa@robson2018");
			System.out.println("Conectou!!!");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}

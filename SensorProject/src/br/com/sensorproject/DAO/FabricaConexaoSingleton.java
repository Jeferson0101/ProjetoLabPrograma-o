package br.com.sensorproject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexaoSingleton {
	
	private static FabricaConexaoSingleton fabrica = new FabricaConexaoSingleton();
	private FabricaConexaoSingleton () {}
	private static Connection con = null;
	
	public static FabricaConexaoSingleton getInstance() {
		return fabrica;
	}
	
	private static Connection setConection() {
		
			try {
				con = DriverManager.getConnection("jdbc:postgresql://pesquisa02.lages.ifsc.edu.br:5432/thingsboard","postgres","pesquisa@robson2018");
				System.out.println("Conectou!!!");
			}catch (SQLException e) {
				e.printStackTrace();
			}
		
		return con;
	}
	
	public static Connection getConection() {
		if(con == null) {
			con = setConection();
		}else {
			try {
				if(con.isClosed()) {
					con = setConection();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return con;
	}
	
		
		
	
}

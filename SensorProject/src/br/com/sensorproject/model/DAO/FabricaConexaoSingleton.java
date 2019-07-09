package br.com.sensorproject.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexaoSingleton {
	
	private static FabricaConexaoSingleton fabrica = new FabricaConexaoSingleton();
	private Connection con = null;
	
	private FabricaConexaoSingleton () {
		try {
			con = DriverManager.getConnection("jdbc:postgresql://pesquisa02.lages.ifsc.edu.br:5432/thingsboard","postgres","pesquisa@robson2018");
			System.out.println("Conectou!!!");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static FabricaConexaoSingleton getInstance() {
		return fabrica;
	}

	public Connection getCon() {
		try {
			if(con.isClosed()) {
				this.fabrica = new FabricaConexaoSingleton();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	
}


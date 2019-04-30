package br.com.sensorproject;

import br.com.sensorproject.DAO.FabricaConexao;

public class Main {

	public static void main(String[] args) {
		FabricaConexao con = new FabricaConexao();
		con.getConexao();

	}

}

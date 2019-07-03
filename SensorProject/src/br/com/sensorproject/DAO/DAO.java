package br.com.sensorproject.DAO;

import java.sql.Timestamp;

//DAO - Data Access Object

public interface DAO <T>{
	
	public T pesquisarTodos(Timestamp dtInicio, Timestamp dtFim, String nome);
	
}

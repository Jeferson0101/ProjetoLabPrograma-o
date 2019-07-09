package br.com.sensorproject.model.sensors.DAO;

import java.sql.Timestamp;


public interface DAO <T>{
	
	public T pesquisarTodos(Timestamp dtInicio, Timestamp dtFim, String nome);
	
}

package br.com.sensorproject.DAO;

import java.util.List;

//DAO - Data Access Object

public interface DAO <T>{
	
	public List<T> pesquisarTodos();
	
}

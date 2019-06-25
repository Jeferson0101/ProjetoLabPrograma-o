package br.com.sensorproject.DAO;

import java.util.Date;
import java.util.List;

//DAO - Data Access Object

public interface DAO <T>{
	
	public T pesquisarTodos(Date dtInicio, Date dtFim);
	
}

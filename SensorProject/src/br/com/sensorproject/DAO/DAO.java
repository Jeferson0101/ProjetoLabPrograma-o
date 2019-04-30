package br.com.sensorproject.DAO;

import java.util.List;

//DAO - Data Access Object

public interface DAO <T>{
	
	public void salvar(T obj);
	public void deletar(int id);
	public void alterar(T obj);
	public List<T> pesquisarTodos();
	
}

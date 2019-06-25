package br.com.sensorproject.sensores;

import java.util.List;

public class Sensor {
	private int id;
	private String nome;
	private List<Medida> medidas;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Medida> getMedidas() {
		return medidas;
	}
	public void setMedidas(List<Medida> medidas) {
		this.medidas = medidas;
	}
}

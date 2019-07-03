package br.com.sensorproject.sensores;

import java.util.List;

public class Sensor {
	
	private String nome;
	private List<Integer> medidas;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Integer> getMedidas() {
		return medidas;
	}
	public void setMedidas(List<Integer> medidas) {
		this.medidas = medidas;
	}
}

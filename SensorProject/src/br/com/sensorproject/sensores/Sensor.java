package br.com.sensorproject.sensores;

public class Sensor {
	private int id;
	private Medida medidas = new Medida();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Medida getMedidas() {
		return medidas;
	}
	public void setMedidas(Medida medidas) {
		this.medidas = medidas;
	}
}

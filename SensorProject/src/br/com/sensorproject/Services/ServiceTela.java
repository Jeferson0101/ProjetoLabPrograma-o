package br.com.sensorproject.Services;

import java.sql.Timestamp;
import br.com.sensorproject.DAO.SensorDAO;
import br.com.sensorproject.sensores.Sensor;

public class ServiceTela {
	SensorDAO dao = new SensorDAO();
	Sensor sensor = new Sensor();
	float soma;
	float media;
	public void getMedidas(Timestamp dataInicio, Timestamp datafim, String nome) {
		
		sensor = dao.pesquisarTodos(dataInicio, datafim, nome);
		
	
	}
	public float getMedia() {
		soma = 0;
		for(int i =0; i< sensor.getMedidas().size(); i++) {
			soma = soma + sensor.getMedidas().get(i);
		}
		media = soma/ sensor.getMedidas().size();
		return media;
	}
	
	public float getMediana() {
		if(sensor.getMedidas().size() % 2 == 0) {
			int resultado = sensor.getMedidas().get((int) Math.floor(sensor.getMedidas().size()/2))+sensor.getMedidas().get((int) Math.round(sensor.getMedidas().size()/2));;
			System.out.println(resultado);
		}else {
			if(sensor.getMedidas().size() % 2 == 1) {
				
			}
		}
		return (float) 10.0;
	}
}

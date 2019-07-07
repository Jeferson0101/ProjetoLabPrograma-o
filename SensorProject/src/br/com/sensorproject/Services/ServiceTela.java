package br.com.sensorproject.Services;

import java.sql.Timestamp;
import br.com.sensorproject.DAO.SensorDAO;
import br.com.sensorproject.sensores.Sensor;

public class ServiceTela {
	SensorDAO dao = new SensorDAO();
	Sensor sensor = new Sensor();
	int soma;
	int media;
	public int getMedidas(Timestamp dataInicio, Timestamp datafim, String nome) {
		sensor = dao.pesquisarTodos(dataInicio, datafim, nome);
		
		for(int i =0; i< sensor.getMedidas().size(); i++) {
			soma = soma + sensor.getMedidas().get(i);
		}
		media = soma/ sensor.getMedidas().size();
		return media;
	}
}

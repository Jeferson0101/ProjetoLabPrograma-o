package br.com.sensorproject.controller;

import java.sql.Timestamp;
import java.util.Arrays;

import br.com.sensorproject.model.DAO.SensorDAO;
import br.com.sensorproject.model.sensors.Sensor;
import org.apache.commons.math3.stat.StatUtils;


public class ServiceTela {
	
	private double[] arrayOfDouble;
	private int [] arrayOfInteger;
	private SensorDAO dao = new SensorDAO();
	private Sensor sensor = new Sensor();
	private float soma;
	private float media;
	
	public void getMedidas(Timestamp dataInicio, Timestamp datafim, String nome) {
		
		sensor = dao.pesquisarTodos(dataInicio, datafim, nome);
		arrayOfInteger = sensor.getMedidas().stream().mapToInt(i->i).toArray();
		arrayOfDouble = Arrays.stream(arrayOfInteger).asDoubleStream().toArray();
	
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
		float resultado =0;
		
		if(sensor.getMedidas().size() % 2 == 0) {
			resultado = sensor.getMedidas().get((int) Math.floor(sensor.getMedidas().size()/2))+sensor.getMedidas().get((int) Math.round(sensor.getMedidas().size()/2 -1));
			resultado = resultado/2;
			
		}else {
			if(sensor.getMedidas().size() % 2 == 1) {
				resultado = sensor.getMedidas().get((int) Math.floor(sensor.getMedidas().size()/2));	
				System.out.println(resultado);
				
			}
		}
		return resultado;
	}
	
	public float getModa() {
		int maxCount=0;
		float maxValue=0;
	    for (int i = 0; i < arrayOfInteger.length; ++i) {
	        int count = 0;
	        for (int j = 0; j < arrayOfInteger.length; ++j) {
	            if (arrayOfInteger[j] == arrayOfInteger[i]) ++count;
	        }
	        if (count > maxCount) {
	            maxCount = count;
	            maxValue = arrayOfInteger[i];
	        }
	    }

	    return maxValue;
	}
	
	public double getVariance() {

		return StatUtils.populationVariance(arrayOfDouble);

	}
	
	
}

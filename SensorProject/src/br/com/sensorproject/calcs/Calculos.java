package br.com.sensorproject.calcs;

import java.util.List;

import br.com.sensorproject.sensores.Medida;
import br.com.sensorproject.sensores.Sensor;

public abstract class Calculos {
	public float media(Sensor sensor){
		float media = 0;
		
		for (Medida medida : sensor.getMedidas()) {
			media += medida.medida;
		}
		
		media = media/sensor.getMedidas().size();
		
		return media;
	}
	
	
	
	
}

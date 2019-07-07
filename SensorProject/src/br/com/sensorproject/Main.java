package br.com.sensorproject;

import java.util.Date;
import java.util.GregorianCalendar;
import java.sql.Timestamp;
import br.com.sensorproject.gui.TelaLogin;
import br.com.sensorproject.DAO.*;

import java.text.ParseException;
import java.text.SimpleDateFormat; 

import java.util.Date; 
public class Main {

	public static void main(String[] args) throws ParseException {
		
		
//		String sDate1="2019/06/01";  
//	    Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
//	    Timestamp t = new Timestamp( date1.getTime());
//	    String sDate2="2019/07/06";
//	    Date date2=new SimpleDateFormat("yyyy/MM/dd").parse(sDate2);
//	    Timestamp t2 = new Timestamp( date2.getTime());
//	    SensorDAO dao = new SensorDAO();
//	    dao.pesquisarTodos(t, t2, "umidade");
		new TelaLogin();
//		Date dtInicio = new Date();
//		Date dtFim = new Date();
//		dtInicio.setTime(time);
//		GregorianCalendar gcInicio = new GregorianCalendar();
//		GregorianCalendar gcFim = new GregorianCalendar();
//		gcInicio.setTimeInMillis(dtInicio.getTime());
//		gcFim.setTimeInMillis(dtInicio.getTime());
//		System.out.println(gcInicio);
//		System.out.println(gcFim);

		
	}

}

package br.com.sensorproject.DAO;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.sensorproject.sensores.Sensor;

public class DHT22DAO implements DAO<Sensor>{
	
	@Override
	public final Sensor pesquisarTodos(Date dtInicio, Date dtFim) {
		
		Connection con = FabricaConexao.getConexao();
		String sql = "SELECT * FROM dht22 WHERE dt_reg BETWEEN ? AND ?";
		Sensor s = new Sensor();
		GregorianCalendar gcInicio = new GregorianCalendar();
		GregorianCalendar gcFim = new GregorianCalendar();
		gcInicio.setTimeInMillis(dtInicio.getTime());
		gcFim.setTimeInMillis(dtInicio.getTime());
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, gcInicio.toString());
			ps.setString(2, gcFim.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				s.setId(rs.getInt("id"));
				s.setNome("");
				
			}
			rs.close();
			ps.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

}

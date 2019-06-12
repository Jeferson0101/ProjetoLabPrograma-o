package br.com.sensorproject.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.sensorproject.sensores.Medida;
import br.com.sensorproject.sensores.Sensor;

public class DHT22DAO implements DAO<Sensor>{

	@Override
	public List<Sensor> pesquisarTodos() {
		List<Sensor> list = new ArrayList<Sensor>(); 
		Connection con = FabricaConexao.getConexao();
		String sql = "SELECT * FROM dht22";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Sensor s = new Sensor();
				s.setId(rs.getInt("id"));
				Medida med = new Medida();
				med.setValor(rs.getDouble("valor"));
				med.setTipoMedida("tipomedida");
				s.setMedidas(med);
				list.add(s);
			}
			rs.close();
			ps.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}

package br.com.sensorproject.DAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import br.com.sensorproject.sensores.Sensor;

public class SensorDAO implements DAO<Sensor>{
	
	@Override
	public Sensor pesquisarTodos(Timestamp dtInicio, Timestamp dtFim, String nome) {
		Connection con = FabricaConexao.getConexao();
		String sql = "SELECT * FROM ts_kv Where key = ? and senddata BETWEEN ? and ?";
		Sensor s = new Sensor();
		List<Integer> medidas = new ArrayList<Integer>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setTimestamp(2, dtInicio);
			ps.setTimestamp(3, dtFim);
			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			System.out.println(rs.toString());
			s.setNome(nome);
			while(rs.next()) {
				medidas.add(rs.getInt("long_v"));
			}
			s.setMedidas(medidas);
			rs.close();
			ps.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println(s.getMedidas().toString());
		return s;
	}

}

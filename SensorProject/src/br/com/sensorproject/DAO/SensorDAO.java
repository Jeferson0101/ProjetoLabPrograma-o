package br.com.sensorproject.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.sensorproject.sensores.Sensor;

public class SensorDAO implements DAO<Sensor>{

	@Override
	public void salvar(Sensor obj) {
		
		Connection con = FabricaConexao.getConexao();
		String sql = "INSERT INTO sensores (nome, nascimento, cpf, matricula, endereco, telefone, funcao, setor) VALUES (?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, obj.getNome());
			Date data = new Date(obj.getNascimento().getTimeInMillis());
			ps.setDate(2, data);
			ps.setString(3, obj.getCPF());
			ps.execute();
			ps.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(int id) {
		Connection con = FabricaConexao.getConexao();
		String sql = "DELETE FROM funcionarios WHERE id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void alterar(Sensor obj) {
		Connection con = FabricaConexao.getConexao();
		String sql = "UPDATE funcionarios SET nome = ?, nascimento = ?, cpf = ?, matricula = ?, endereco = ?, telefone = ?, funcao = ?, setor = ? WHERE id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, obj.getNome());
			Date data = new Date(obj.getNascimento().getTimeInMillis());
			ps.setDate(2, data);
			ps.setString(3, obj.getCPF());
			ps.setString(4, obj.getMatricula());
			ps.setString(5, obj.getEndereco());
			ps.setString(6, obj.getTelefone());
			ps.setString(7, obj.getFuncao());
			ps.setString(8, obj.getSetor());
			ps.setInt(9, obj.getId());
			ps.execute();
			ps.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Sensor> pesquisarTodos() {
		List<Sensor> list = new ArrayList<Sensor>(); 
		Connection con = FabricaConexao.getConexao();
		String sql = "SELECT * FROM funcionarios";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Sensor p = new Sensor();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTimeInMillis(rs.getDate("nascimento").getTime());
				p.setNascimento(gc);
				p.setCPF(rs.getString("cpf"));
				p.setMatricula(rs.getString("matricula"));
				p.setEndereco(rs.getString("endereco"));
				p.setTelefone(rs.getString("telefone"));
				p.setFuncao(rs.getString("funcao"));
				p.setSetor(rs.getString("setor"));
				list.add(p);
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

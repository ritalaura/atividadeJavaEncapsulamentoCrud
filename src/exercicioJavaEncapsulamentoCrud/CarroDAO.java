package exercicioJavaEncapsulamentoCrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarroDAO {

	public void deletarCarro(int id) {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
			String sql = "DELETE FROM carro WHERE id=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Carro obterCarro (int id) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
			String sql = "select * from carro where id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()) {
				String modelo = resultado.getString("modelo");
				String placa = resultado.getString("placa");
				String cor = resultado.getString("cor");
				
				Carro carro = new Carro(placa, modelo, cor, id);
				return carro;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void atulizarCarro(int id, Carro carro) {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
			String sql = "update carro set placa = ?, cor = ?, modelo = ? where id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, carro.getPlaca());
			statement.setString(2, carro.getCor());
			statement.setString(3, carro.getModelo());
			statement.setInt(4, id);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void inserirCarro(Carro carro) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
			String sql = "INSERT INTO carro (id, placa, cor, modelo) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, carro.getId());
			statement.setString(2, carro.getPlaca());
			statement.setString(3, carro.getCor());
			statement.setString(4, carro.getModelo());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

import model.Usuario;

public class UsuarioDAO {
	
	private final Connection connection;

	public UsuarioDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public void insert(Usuario usuario) throws Exception {
			String sql = "INSERT INTO usuario (usuario, senha) VALUES (?, ?)";
			PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql);
			
			pstm.setString(1, usuario.getUsuario());
			pstm.setString(2, usuario.getSenha());
			pstm.execute();
	}

	public void update (Usuario usuario) throws Exception {
		String sql = "UPDATE usuario SET usuario = ?, senha = ? WHERE id = ?";
		PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql);
		
		pstm.setString(1, usuario.getUsuario());
		pstm.setString(2, usuario.getSenha());
		pstm.setString(3, usuario.getId());
		pstm.execute();
	}
	
	public void delete (Usuario usuario) throws Exception {
		String sql = "DELETE FROM usuario WHERE id = ?";
		PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql);
		
		pstm.setString(1, usuario.getId());
		pstm.execute();
	}
	
	public void selectAll(Usuario usiario) throws Exception {
		
		
	}
	
	public boolean existePorUsuarioESenha(Usuario usuario) throws Exception {	
		String sql = "SELECT*FROM usuario WHERE usuario = ? and senha = ?";
		PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql);
		pstm.setString(1, usuario.getUsuario());
		pstm.setString(2, usuario.getSenha());
		pstm.execute();
		
		ResultSet resultSet = pstm.getResultSet();
		
		return resultSet.next();
	}

}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	public static Connection getConnection() throws Exception {
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/aplicativo", "root", "");
		return conexao;
	}
	
}
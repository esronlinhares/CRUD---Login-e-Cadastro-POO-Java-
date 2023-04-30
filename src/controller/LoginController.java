package controller;

import java.sql.Connection;
import javax.swing.JOptionPane;
import dao.Conexao;
import dao.UsuarioDAO;
import model.Usuario;
import view.Login;
import view.Menu;

public class LoginController {
	
	private Login view;

	public LoginController(Login view) {
		super();
		this.view = view;
	}

	public void autenticar() throws Exception {
		String usuario = view.getLerUsuario().getText();
		String senha = view.getLerSenha().getText();
		Usuario usuarioAutenticar = new Usuario(usuario, senha);
		
		Connection conexao = new Conexao().getConnection();
		UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
		
		boolean existe = usuarioDao.existePorUsuarioESenha(usuarioAutenticar);
		
		if(existe) {
			Menu telaDeMenu = new Menu();
			telaDeMenu.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(view, "Usuário ou senha inválidos.");
		}
	}
	
}

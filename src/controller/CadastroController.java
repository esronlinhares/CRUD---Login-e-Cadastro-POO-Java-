package controller;

import java.sql.Connection;
import javax.swing.JOptionPane;
import dao.Conexao;
import dao.UsuarioDAO;
import model.Usuario;
import view.Cadastro;
import view.Login;

public class CadastroController {
	
	private Cadastro view;

	public CadastroController(Cadastro view) {
		super();
		this.view = view;
	}
	
	public void salvarUsuario() {
		String usuario = view.getLerUsuario().getText();
		String senha = view.getLerSenha().getText();
		Usuario usuarioCadastro = new Usuario(usuario, senha);
		
		try {
		Connection conexao = new Conexao().getConnection();
		UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
		usuarioDao.insert(usuarioCadastro);
		
		JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
		
		Login telaDeLogin = new Login();
		telaDeLogin.setVisible(true);
		} catch (Exception el) {
			el.printStackTrace();
		}
	}

}

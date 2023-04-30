package controller;

import java.sql.Connection;

import javax.swing.JOptionPane;

import dao.Conexao;
import dao.UsuarioDAO;
import model.Usuario;
import view.Cadastro2;
import view.Menu;

public class Cadastro2Controller {
	
	private Cadastro2 view;

	public Cadastro2Controller(Cadastro2 view) {
		super();
		this.view = view;
	}
	
	public void salvarUsuario2() {
		String usuario = view.getLerUsuario().getText();
		String senha = view.getLerSenha().getText();
		Usuario usuarioCadastro = new Usuario(usuario, senha);
		
		try {
		Connection conexao = new Conexao().getConnection();
		UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
		usuarioDao.insert(usuarioCadastro);
		
		JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
		
		Menu telaDeMenu = new Menu();
		telaDeMenu.setVisible(true);
		} catch (Exception el) {
			el.printStackTrace();
		}
	}

}

package controller;

import java.sql.Connection;
import javax.swing.JOptionPane;
import dao.Conexao;
import dao.UsuarioDAO;
import model.Usuario;
import view.Menu;
import view.Update;

public class UpdateController {
	
	private Update view;

	public UpdateController(Update view) {
		super();
		this.view = view;
	}
	
	public void updateUsuario() {
		String id = view.getLerId().getText();
		String usuario = view.getLerUsuario().getText();
		String senha = view.getLerSenha().getText();
		Usuario updateCadastro = new Usuario(id, usuario, senha);
		
		try {
		Connection conexao = new Conexao().getConnection();
		UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
		usuarioDao.update(updateCadastro);
		
		JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
		
		Menu telaDeMenu = new Menu();
		telaDeMenu.setVisible(true);
		
		} catch (Exception el) {
			el.printStackTrace();
		}
	}

}

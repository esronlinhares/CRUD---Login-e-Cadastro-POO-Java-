package controller;

import java.sql.Connection;
import javax.swing.JOptionPane;
import dao.Conexao;
import dao.UsuarioDAO;
import model.Usuario;
import view.Delete;
import view.Menu;

public class DeleteController {
	
	private Delete view;

	public DeleteController(Delete view) {
		super();
		this.view = view;
	}
	
	public void deletarUsuario() {
		String id = view.getLerId().getText();
		Usuario deleteCadastro = new Usuario(id);
		
		try {
		Connection conexao = new Conexao().getConnection();
		UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
		usuarioDao.delete(deleteCadastro);
		
		JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!");
		
		Menu telaDeMenu = new Menu();
		telaDeMenu.setVisible(true);
		
		} catch (Exception el) {
			el.printStackTrace();
		}
	}

}

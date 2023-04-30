package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
import dao.Conexao;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTable tblCadastro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton testarUsuarioDao = new JButton("Listar");
		testarUsuarioDao.setBounds(10, 45, 89, 23);
		testarUsuarioDao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conexao = new Conexao().getConnection();
					Statement pstm = (Statement) conexao.createStatement();
					String sql = "SELECT*FROM usuario";
					
					ResultSet resultSet = pstm.executeQuery(sql);
					ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
					DefaultTableModel model = (DefaultTableModel) tblCadastro.getModel();

					int cols = rsmd.getColumnCount();
					String[] colUsuario = new String[cols];
					
					for(int i = 0; i < cols; i++)
						colUsuario[i] = rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colUsuario);
					
					String id, usuario, senha;
					while (resultSet.next()) {
						id = resultSet.getString(1);
						usuario = resultSet.getString(2);
						senha = resultSet.getString(3);
						String[] row = {id, usuario, senha};
						model.addRow(row);
					}
					
					resultSet.close();
					conexao.close();
								
				} catch (Exception el) {
					el.printStackTrace();
				}
			
			}
		});
		contentPane.setLayout(null);
		contentPane.add(testarUsuarioDao);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.setBounds(10, 79, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update telaDeUpdate = new Update();
				telaDeUpdate.setVisible(true);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(144, 11, 280, 180);
		contentPane.add(scrollPane);
		
		tblCadastro = new JTable();
		scrollPane.setViewportView(tblCadastro);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Deletar");
		btnNewButton_1.setBounds(10, 113, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete telaDeDelete = new Delete();
				telaDeDelete.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cadastrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro2 telaDeCadastro2 = new Cadastro2();
				telaDeCadastro2.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton_2);
		
	}

	public JTable getTblCadastro() {
		return tblCadastro;
	}

	public void setTblCadastro(JTable tblCadastro) {
		this.tblCadastro = tblCadastro;
	}
}

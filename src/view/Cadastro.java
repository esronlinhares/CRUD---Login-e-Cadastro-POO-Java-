package view;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CadastroController;
import dao.Conexao;
import dao.UsuarioDAO;
import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField lerUsuario;
	private JPasswordField lerSenha;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		
		CadastroController controller = new CadastroController(this);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(174, 50, 59, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(174, 110, 48, 22);
		contentPane.add(lblNewLabel_2);
		
		lerUsuario = new JTextField();
		lerUsuario.setBounds(174, 80, 86, 20);
		contentPane.add(lerUsuario);
		lerUsuario.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.salvarUsuario();
			}
		});
		btnNewButton.setBounds(172, 180, 89, 23);
		contentPane.add(btnNewButton);
		
		lerSenha = new JPasswordField();
		lerSenha.setBounds(174, 145, 86, 20);
		contentPane.add(lerSenha);
	}

	public JTextField getLerUsuario() {
		return lerUsuario;
	}

	public void setLerUsuario(JTextField lerUsuario) {
		this.lerUsuario = lerUsuario;
	}

	public JPasswordField getLerSenha() {
		return lerSenha;
	}

	public void setLerSenha(JPasswordField lerSenha) {
		this.lerSenha = lerSenha;
	}	
	
}

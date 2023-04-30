package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.LoginController;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField lerUsuario;
	private JPasswordField lerSenha;
	private LoginController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		controller = new LoginController(this);
		
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
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(174, 30, 76, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(174, 96, 48, 22);
		contentPane.add(lblNewLabel_2);
		
		lerUsuario = new JTextField();
		lerUsuario.setBackground(new Color(255, 255, 255));
		lerUsuario.setForeground(Color.BLACK);
		lerUsuario.setBounds(174, 65, 86, 20);
		contentPane.add(lerUsuario);
		lerUsuario.setColumns(10);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.autenticar();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(172, 170, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro telaDeCadastro = new Cadastro();
				telaDeCadastro.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(172, 210, 89, 23);
		contentPane.add(btnNewButton_1);
		
		lerSenha = new JPasswordField();
		lerSenha.setBounds(174, 130, 86, 20);
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

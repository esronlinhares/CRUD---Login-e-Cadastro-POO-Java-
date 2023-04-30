package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.UpdateController;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField lerUsuario;
	private JTextField lerSenha;
	private JTextField lerId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	public Update() {
		
		UpdateController controller = new UpdateController(this);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Novo usuário");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(174, 75, 104, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nova senha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(174, 131, 92, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(174, 19, 92, 14);
		contentPane.add(lblNewLabel_2);
		
		lerUsuario = new JTextField();
		lerUsuario.setBounds(174, 100, 86, 20);
		contentPane.add(lerUsuario);
		lerUsuario.setColumns(10);
		
		lerSenha = new JTextField();
		lerSenha.setBounds(174, 157, 86, 20);
		contentPane.add(lerSenha);
		lerSenha.setColumns(10);
		
		lerId = new JTextField();
		lerId.setBounds(174, 44, 86, 20);
		contentPane.add(lerId);
		lerId.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.updateUsuario();
			}
		});
		btnNewButton.setBounds(172, 212, 89, 23);
		contentPane.add(btnNewButton);
	}

	public JTextField getLerUsuario() {
		return lerUsuario;
	}

	public void setLerUsuario(JTextField lerUsuario) {
		this.lerUsuario = lerUsuario;
	}

	public JTextField getLerSenha() {
		return lerSenha;
	}

	public void setLerSenha(JTextField lerSenha) {
		this.lerSenha = lerSenha;
	}

	public JTextField getLerId() {
		return lerId;
	}

	public void setLerId(JTextField lerId) {
		this.lerId = lerId;
	}
	
}

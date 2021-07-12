import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private SistemaGerencia sistema;

	/*
	 construtor da classe TelaInicial que inicia os componentes visuais e acões
	 
	 */

	public TelaInicial(SistemaGerencia sg) {
		
		sistema = sg;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar Funcion\u00E1rio");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCadFuncionario tf = new TelaCadFuncionario(sg);
				tf.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Sair");
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");

		lblNewLabel.setForeground(Color.WHITE);

		lblNewLabel.setBounds(295, 129, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Senha");

		lblNewLabel_1.setForeground(Color.WHITE);

		lblNewLabel_1.setBounds(295, 188, 46, 14);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(273, 154, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Sistema De Ger\u00EAncia De Produtos");

		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));

		lblNewLabel_3.setBounds(159, 75, 390, 14);
		contentPane.add(lblNewLabel_3);

		ImageIcon icon = new ImageIcon("src/sm.jpg");

		passwordField = new JPasswordField();
		passwordField.setBounds(273, 224, 86, 20);
		contentPane.add(passwordField);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String login = textField.getText();
				String senha = passwordField.getText();
				
				try {
					
					Funcionario f = sistema.pesquisaFuncionario(login, senha);
					
					if(f instanceof Operador) {
						
						TelaVenda tv = new TelaVenda(sg);
						tv.setVisible(true);
						dispose();
					}else if( f instanceof Gerente) {
						
						TelaGerente tg = new TelaGerente(sg);
						tg.setVisible(true);
						dispose();
					}
					
					dispose();
					
				}catch(FuncionarioException ee) {
					
					textField.setText("");
					passwordField.setText("");
					
					JOptionPane.showMessageDialog(null, ee.getMessage());
				}
				
			}
		});
		btnNewButton.setBounds(270, 277, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Foto");
		lblNewLabel_2.setIcon(icon);
		lblNewLabel_2.setBounds(0, 0, 624, 419);
		contentPane.add(lblNewLabel_2);

	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class TelaCadFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private ButtonGroup bg;
	private SistemaGerencia sg;
	
	
	private JRadioButton rb1;
	private JRadioButton rb2;
	
	/*
	 construtor da classe TelaCadFuncionario que inicia os componentes visuais e acões
	 
	 */
	public TelaCadFuncionario(SistemaGerencia gf) {

		this.sg = gf;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Sair");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInicial ti = new TelaInicial(sg);
				ti.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(184, 116, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setBounds(184, 141, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cargo:");
		lblNewLabel_2.setBounds(184, 166, 46, 14);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = textField.getText();
				String cpf = textField_1.getText();

				Funcionario f1 = null;

				if (rb1.isSelected()) {

					f1 = new Operador(nome, cpf);
				} else if(rb2.isSelected()){

					f1 = new Gerente(nome, cpf);
				}


				try {
					
					sg.addFuncionario(f1);
					
					int opc = JOptionPane.showConfirmDialog(null,
							"Cadastrado com sucesso.\nDeseja Cadastrar outro funcionário?");

					if (opc == 0) {
						textField.setText("");
						textField_1.setText("");
					} else {

						TelaInicial ti = new TelaInicial(sg);
						ti.setVisible(true);
						dispose();

					} 
					
				} catch (FuncionarioException e1) {

					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

					

			}
		});
		btnNewButton.setBounds(251, 269, 109, 23);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(251, 113, 201, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(251, 138, 201, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		bg = new ButtonGroup();

		 rb1 = new JRadioButton("Operador");
		rb1.setBounds(251, 162, 109, 23);
		contentPane.add(rb1);

		 rb2 = new JRadioButton("Gerente");
		rb2.setBounds(251, 188, 109, 23);
		contentPane.add(rb2);

		bg.add(rb1);
		bg.add(rb2);

		ImageIcon icon = new ImageIcon("src/bg.jpg");

		JLabel lblNewLabel_3 = new JLabel("Foto");


		lblNewLabel_3.setIcon(icon);

		lblNewLabel_3.setBounds(0, 0, 624, 408);
		contentPane.add(lblNewLabel_3);
		
		
	}
}

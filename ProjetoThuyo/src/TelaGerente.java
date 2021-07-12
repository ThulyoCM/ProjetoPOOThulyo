import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;

public class TelaGerente extends JFrame {

	private JPanel contentPane;
	private SistemaGerencia sg;
	private JTable tableLista;
	private JTextField tfNome;
	private JTextField tfPrec;
	private JTextField tfCod;
	
	/*
	 construtor da classe TelaGerente que inicia os componentes visuais e acões
	 
	 */
	public TelaGerente(SistemaGerencia sg) {

		this.sg = sg;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Sair");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInicial ti = new TelaInicial(sg);
				ti.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Lucro Vendas");
		lblNewLabel_1.setBounds(25, 106, 86, 14);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = tfNome.getText();
				String cod = tfCod.getText();
				double preco = Double.parseDouble(tfPrec.getText());

				Produto p = new Produto(nome, cod, preco);

				sg.addProduto(p);

				TelaGerente tg = new TelaGerente(sg);
				tg.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(181, 216, 97, 23);
		contentPane.add(btnNewButton);

		tableLista = new JTable(sg.getTabelaProdutos(), sg.getTitulos());
		tableLista.setBounds(352, 45, 208, 322);
		contentPane.add(tableLista);

		JLabel lblNewLabel_2 = new JLabel("Lista dos Produtos");
		lblNewLabel_2.setBounds(352, 20, 208, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lbLucro = new JLabel("R$: "+sg.getLucroVendas());
		lbLucro.setBounds(25, 129, 46, 14);
		contentPane.add(lbLucro);

		JLabel lblNewLabel_3 = new JLabel("Cadastrar Produto");
		lblNewLabel_3.setBounds(179, 20, 119, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Nome:");
		lblNewLabel_4.setBounds(149, 89, 46, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("C\u00F3digo:");
		lblNewLabel_5.setBounds(149, 161, 46, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Pre\u00E7o:");
		lblNewLabel_6.setBounds(149, 129, 46, 14);
		contentPane.add(lblNewLabel_6);

		tfNome = new JTextField();
		tfNome.setBounds(209, 86, 86, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		tfPrec = new JTextField();
		tfPrec.setBounds(209, 123, 86, 20);
		contentPane.add(tfPrec);
		tfPrec.setColumns(10);

		tfCod = new JTextField();
		tfCod.setBounds(209, 158, 86, 20);
		contentPane.add(tfCod);
		tfCod.setColumns(10);

		ImageIcon icon = new ImageIcon("src/bg.jpg");

		JLabel lblNewLabel = new JLabel("Foto");
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(0, 0, 624, 419);
		contentPane.add(lblNewLabel);

	}

}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaVenda extends JFrame {

	private JPanel contentPane;
	private JTextField tfCod;
	private JTable tableLista1;
	private JTable tableLista2;

	private SistemaGerencia sg;
	
	JLabel lbPrecoVenda;

	/*
	 construtor da classe TelaVenda que inicia os componentes visuais e acões
	 
	 */
	public TelaVenda(SistemaGerencia sg) {
		

		this.sg = sg;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);

		contentPane = new JPanel();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Sair");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				sg.setPrecoVenda(0);
				
				sg.limpaTabelaSelecionados();
				
				TelaInicial ti = new TelaInicial(sg);
				ti.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo Produto");
		lblNewLabel_1.setBounds(24, 328, 219, 14);
		contentPane.add(lblNewLabel_1);

		tfCod = new JTextField();
		tfCod.setBounds(24, 359, 236, 20);
		contentPane.add(tfCod);
		tfCod.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Valor Total");
		lblNewLabel_2.setBounds(469, 163, 72, 14);
		contentPane.add(lblNewLabel_2);
		
		/*
		 botão para adidionar compra na tabela de produtos selecionado pelo cliente pelo operador, 
		 criando o objeto produto da lista da classe SistemaGrencia,
		 a acão dele também mostra o os produtos na tabela de seleção pelo cliente e altera o valor
		 da compra
		 */

		JButton btnNewButton = new JButton("Adicionar produto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String cod = tfCod.getText();
				
				try {
				
				Produto p = sg.pesquisaProdutoPeloCod(cod);
				
				sg.setPrecoVenda(sg.getPrecoVenda()+p.getPreco());
				
				sg.addProdutoSelecionado(p);
				
				TelaVenda tv = new TelaVenda(sg);
				
				tv.setVisible(true);
				dispose();
				
				}catch (ProdutoNaoEncontradoException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
				
			}
		});
		btnNewButton.setBounds(272, 324, 145, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Foto");
		lblNewLabel.setBounds(0, 3, 624, 416);

		JLabel lblNewLabel_3 = new JLabel("Lista dos produtos");
		lblNewLabel_3.setBounds(24, 38, 163, 14);
		contentPane.add(lblNewLabel_3);

		lbPrecoVenda = new JLabel("R$: "+sg.getPrecoVenda());
		lbPrecoVenda.setBounds(469, 204, 46, 14);
		contentPane.add(lbPrecoVenda);
		
		/*
		 botão para finalizar compra, a acão dele mostra o valor total da compra,
		 cria uma nova janela para limpar os valores da tabela selecionados
		 */

		JButton btnNewButton_1 = new JButton("Finalizar compra");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Pago!\nValor total da compra: "+sg.getPrecoVenda());
				
				sg.setLucroVendas(sg.getLucroVendas()+sg.getPrecoVenda());
				sg.setPrecoVenda(0);
				
				sg.limpaTabelaSelecionados();
				
				TelaVenda ti = new TelaVenda(sg);
				ti.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(272, 358, 145, 23);
		contentPane.add(btnNewButton_1);

		tableLista1 = new JTable(sg.getTabelaProdutos(), sg.getTitulos());

		tableLista2 = new JTable(sg.getTabelaProdutosSelecionados(), sg.getTitulos());

		tableLista1.setBounds(24, 63, 150, 220);

		tableLista2.setBounds(197, 63, 150, 220);

		contentPane.add(tableLista1);
		contentPane.add(tableLista2);

		JLabel lblNewLabel_5 = new JLabel("Lista de produtos Do Cliente");
		lblNewLabel_5.setBounds(197, 38, 159, 14);
		contentPane.add(lblNewLabel_5);

		ImageIcon icon = new ImageIcon("src/bg.jpg");

		lblNewLabel.setIcon(icon);
		contentPane.add(lblNewLabel);

	}
	
}

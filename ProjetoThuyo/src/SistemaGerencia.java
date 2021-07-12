import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class SistemaGerencia {

	private List<Funcionario> funcionarios;

	private Map<String, Produto> produtos;

	private List<Produto> produtosSelecionado;
	
	private String nome;
	
	private double precoVenda = 0;
	private double lucroVendas;

	public SistemaGerencia(String nome) {

		this.nome = nome;
		funcionarios = new ArrayList<>();
		produtos = new HashMap<>();
		produtosSelecionado = new ArrayList<>();
	}

	public boolean addFuncionario(Funcionario fu) throws FuncionarioException {

		for (Funcionario f : funcionarios) {
			if (f.getCPF().equals(fu.getCPF()) && f.getNome().equals(f.getNome())) {

				throw new FuncionarioException("Erro! Já existe um funcionário com esse nome.");
			}
		}

		funcionarios.add(fu);

		return true;
	}
	
	

	public double getLucroVendas() {
		return lucroVendas;
	}

	public void setLucroVendas(double lucroVendas) {
		this.lucroVendas = lucroVendas;
	}

	public boolean excluirFuncionario(Funcionario fun) throws FuncionarioException{
		
		for(Funcionario f : funcionarios) {
			if(f.getCPF().equals(fun.getCPF())) {
				
				funcionarios.remove(f);
				return true;
			}

	
		}

		throw new FuncionarioException("Erro! Funcionário não encontrado.");

	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}


	public void setProdutos(Map<String, Produto> produtos) {
		this.produtos = produtos;
	}


	public boolean addProduto(Produto p) {

		produtos.put(p.getCodigo(), p);

		return true;

	}

	private boolean verificaProdutoExiste(String cod) {

		for (Produto p : produtos.values()) {

			if (p.getCodigo().equals(cod)) {
				return true;
			}
		}

		return false;
	}

	public boolean removeProduto(Produto p) {

		for(Produto pp: produtos.values()) {
			if(pp.getCodigo().equals(p.getCodigo())) {
				produtos.remove(p.getCodigo());
				return true;
			}
		}
		return false;
	}

	public Funcionario pesquisaFuncionario(String login, String senha) throws FuncionarioException {

		for (Funcionario f : funcionarios) {
			if (f.getNome().equals(login) && f.getCPF().equals(senha)) {
				return f;
			}
		}
		throw new FuncionarioException("Funcionário não encontrado");
	}

	public String[] getTitulos() {
		return new String[] { "Nome", "Preço", "Código" };
	}

	public Produto pesquisaProdutoPeloCod(String cod) throws ProdutoNaoEncontradoException{

		for (Produto p : produtos.values()) {

			if (p.getCodigo().equals(cod)) {
				return p;
			}
		}
		throw new ProdutoNaoEncontradoException("Produto não encontrado!");
	}

	public void addProdutoSelecionado(Produto p) {

		produtosSelecionado.add(p);

	}

	public Object[][] getTabelaProdutos() {

		Object[][] tabela = new Object[produtos.size()][3];

		int cont = 0;

		List<String> produt = new ArrayList<>();

		for (Produto p : produtos.values()) {

			produt.add(p.getNome());
			produt.add(p.getPreco()+ "");
			produt.add(p.getCodigo());
		}
		
		for (int x = 0; x < tabela.length; x++) {

			for (int y = 0; y < tabela[x].length; y++) {

				tabela[x][y] = produt.get(cont);

				cont++;

			}
		}

		return tabela;
	}
	
	public Object[][] getTabelaProdutosSelecionados() {

		Object[][] tabela = new Object[produtosSelecionado.size()][3];

		int cont = 0;
		
		List<String> produt = new ArrayList<>();

		for (Produto p : produtosSelecionado) {

			produt.add(p.getNome());
			produt.add(p.getPreco()+ "");
			produt.add(p.getCodigo());
		}
		for (int x = 0; x < tabela.length; x++) {

			for (int y = 0; y < tabela[x].length; y++) {

				tabela[x][y] = produt.get(cont);

				cont++;

			}
		}

		return tabela;
	}
	
	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double d) {
		precoVenda = d;
		
	}

	public void limpaTabelaSelecionados() {
		
		produtosSelecionado = new ArrayList<>();
	}
	
	public Map<String, Produto> getProdutos() {
		return produtos;
	}

	public boolean removeFuncionario(Funcionario f1) {
		
		for(Funcionario f: funcionarios) {
			if(f.getCPF().equals(f1.getCPF())) {
				funcionarios.remove(f);
				return true;
			}
		}
		return false;
		
	}

}

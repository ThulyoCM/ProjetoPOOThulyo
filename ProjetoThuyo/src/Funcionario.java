
public abstract class Funcionario {
	
	private String nome, CPF;
	
	public Funcionario(String nome, String CPF) {
		
		this.nome = nome;
		this.CPF = CPF;
	}
	
	public  String getNome() {
		return nome;
	}
	
	public  String getCPF() {
		
		return CPF;
	}
	
	
}

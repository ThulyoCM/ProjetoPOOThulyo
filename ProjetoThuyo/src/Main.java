
public class Main {
	
	/*
	 Classe principal, � aqui que se inicia a primeira tela
	 
	 */
	
	public static void main(String[] args) throws FuncionarioException {
		
		
		//objeto do tipo sistema instanciado com o nome Supermercado Xtest Quase n�o sai
		SistemaGerencia sistema = new SistemaGerencia("Supermercado Xtest Quase n�o sai");
		
		//criando um produto e adicionando ao sistema para a gerencia dos produtos
		Produto p = new Produto("Arroz", "1010", 4.50);
		
		sistema.addProduto(p);
		
		TelaInicial ti = new TelaInicial(sistema);
		ti.setVisible(true);
	}

}

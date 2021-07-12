import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteUnitario {

	// cadastro, remoção e pesquisa

	@Test
	void test() {
		SistemaGerencia sg = new SistemaGerencia("Nome do supermercado teste");

		Produto p1 = new Produto("Macarrão", "2222", 4);
		Funcionario f1 = new Gerente("João", "001");

	
		try {
			
			sg.addProduto(p1);
			sg.addFuncionario(f1);
			
			assertEquals(1, sg.getFuncionarios().size());
			assertEquals(1, sg.getProdutos().size());

			assertNotNull(sg.pesquisaFuncionario(f1.getNome(), f1.getCPF()));
			assertNotNull(sg.pesquisaProdutoPeloCod(p1.getCodigo()));
			
			sg.removeProduto(p1);
			sg.removeFuncionario(f1);
			
			assertEquals(0, sg.getFuncionarios().size());
			assertEquals(0, sg.getProdutos().size());
			
		} catch (ProdutoNaoEncontradoException | FuncionarioException e) {

			e.printStackTrace();
		}
	}

}

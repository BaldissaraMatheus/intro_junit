package carrinho;

import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class CarrinhoTest {

	Carrinho carrinho;
	
	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
	}
	
	@Test
	public void verificaSeSomatorioCalculaValorCorreto() {
		Produto produtoA = new Produto("Produto A", 10);
		Produto produtoB = new Produto("Produto B", 25);
		carrinho.addItem(produtoA);
		carrinho.addItem(produtoB);
		Assertions.assertEquals(35, carrinho.getValorTotal());
	}
	
	@Test
	public void verificaSeQuantidadeDeItemsRetornaValorCorreto() {
		Produto produtoA = new Produto("Produto A", 0);
		Produto produtoB = new Produto("Produto B", 0);
		Produto produtoC = new Produto("Produto C", 0);
		carrinho.addItem(produtoA);
		carrinho.addItem(produtoB);
		carrinho.addItem(produtoC);
		Assertions.assertEquals(3, carrinho.getQtdeItems());
	}
	
	@Test
	public void verificaSeRemocaoDeProdutoRemoveProduto() throws ProdutoNaoEncontradoException {
		Produto produtoA = new Produto("Produto A", 0);
		Produto produtoB = new Produto("Produto B", 0);
		Produto produtoC = new Produto("Produto C", 0);
		carrinho.addItem(produtoA);
		carrinho.addItem(produtoB);
		carrinho.addItem(produtoC);
		Assertions.assertEquals(3, carrinho.getQtdeItems());
		carrinho.removeItem(produtoC);
		Assertions.assertEquals(2, carrinho.getQtdeItems());
		carrinho.removeItem(produtoA);
		Assertions.assertEquals(1, carrinho.getQtdeItems());
	}
	
	@Test
	public void verificaSeValorTotalEhCalculadoCorretamenteAposRemocaoDeProduto() throws ProdutoNaoEncontradoException {
		Produto produtoA = new Produto("Produto A", 10);
		Produto produtoB = new Produto("Produto B", 15);
		Produto produtoC = new Produto("Produto C", 20);
		carrinho.addItem(produtoA);
		carrinho.addItem(produtoB);
		carrinho.addItem(produtoC);
		Assertions.assertEquals(45, carrinho.getValorTotal());
		carrinho.removeItem(produtoC);
		Assertions.assertEquals(25, carrinho.getValorTotal());
	}
	
	@Test
	public void verificaSeExcecaoEhLancadaAoRemoverProdutoInexistente() {
		Produto produtoA = new Produto("Produto A", 10);
		Produto produtoB = new Produto("Produto B", 15);
		carrinho.addItem(produtoA);
		Assertions.assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(produtoB));
	}
	
	@Test
	public void verificaSeEsvaziarCarrinhoRemoveTodosOsItems() {
		Produto produtoA = new Produto("Produto A", 10);
		Produto produtoB = new Produto("Produto B", 15);
		carrinho.addItem(produtoA);
		carrinho.addItem(produtoB);
		carrinho.esvazia();
		Assertions.assertEquals(0, carrinho.getValorTotal());
		Assertions.assertEquals(0, carrinho.getQtdeItems());
	}
	
}

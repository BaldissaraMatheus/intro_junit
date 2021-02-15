package calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testSubtraiDoisNumeros() {
		int subtracao = calc.subtracao(6, 3);		
		Assertions.assertEquals(3, subtracao);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		Assertions.assertEquals(2, divisao);
	}
	
	@Test
	public void testMultiplicaDoisNumeros() {
		int multiplicacao = calc.multiplicacao(2, 4);		
		Assertions.assertEquals(8, multiplicacao);		
	}
	
	@Test
	public void testSomatoria() {
		int somatoria = calc.somatoria(4);		
		Assertions.assertEquals(10, somatoria);		
	}
	
	@Test
	public void verificaSeEhPositivoRetornaTrueParaValorPositivo() {	
		Assertions.assertTrue(calc.ehPositivo(5));		
	}
	
	@Test
	public void verificaSeEhPositivoRetornaFalseParaValorNegativo() {	
		Assertions.assertFalse(calc.ehPositivo(-5));		
	}
	
	@Test
	public void verificaSeComparaRetorna0ParaItemsIguais() {
		Assertions.assertEquals(0, calc.compara(5, 5));		
	}
	
	@Test
	public void verificaSeComparaRetorna1PositivoSePrimeiroValorForMaior() {
		Assertions.assertEquals(1, calc.compara(6, 5));		
	}

	@Test
	public void verificaSeComparaRetorna1NegativoSePrimeiroValorForMenor() {
		Assertions.assertEquals(-1, calc.compara(4, 5));		
	}
	
	@Test
	public void testDivisaoPorZero() {
//		https://stackoverflow.com/a/52085072
		ArithmeticException e = Assertions.assertThrows(ArithmeticException.class, () -> calc.divisao(8, 0));
		Assertions.assertEquals("/ by zero", e.getMessage());
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		Assertions.assertThrows(ArithmeticException.class, () -> calc.divisao(8, 0));
	}

}

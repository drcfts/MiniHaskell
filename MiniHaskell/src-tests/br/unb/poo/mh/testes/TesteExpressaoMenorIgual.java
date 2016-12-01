package br.unb.poo.mh.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoMenorIgual;;

public class TesteExpressaoMenorIgual {
	
	@Test
	public void testeMenorIgual(){
		ValorInteiro v5 = new ValorInteiro(5);
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro n10 = new ValorInteiro(10);
		
		Expressao meigual1 = new ExpressaoMenorIgual(v5, v10);
		Expressao meigual2 = new ExpressaoMenorIgual(v10, v5);
		Expressao meigual3 = new ExpressaoMenorIgual(n10, v10);
		
		Assert.assertEquals(true, meigual1.avaliar());
		Assert.assertEquals(false, meigual2.avaliar());
		Assert.assertEquals(true, meigual3.avaliar());
	}
}

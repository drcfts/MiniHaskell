package br.unb.poo.mh.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoMaiorIgual;

public class TesteExpressaoMaiorIgual {
	
	@Test
	public void testeMaiorIgual(){
		ValorInteiro v5 = new ValorInteiro(5);
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro n10 = new ValorInteiro(10);
		
		Expressao maigual1 = new ExpressaoMaiorIgual(v5, v10);
		Expressao maigual2 = new ExpressaoMaiorIgual(v10, v5);
		Expressao maigual3 = new ExpressaoMaiorIgual(n10, v10);
		
		Assert.assertEquals(false, maigual1.avaliar());
		Assert.assertEquals(true, maigual2.avaliar());
		Assert.assertEquals(true, maigual3.avaliar());
	}
}

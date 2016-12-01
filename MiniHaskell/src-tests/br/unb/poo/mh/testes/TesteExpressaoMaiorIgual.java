package br.unb.poo.mh.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoMaior;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoMaiorIgual;

public class TesteExpressaoMaiorIgual {
	
	@Test
	public void testeMaiorIgual(){
		ValorBooleano v = new ValorBooleano(true);
		ValorBooleano f = new ValorBooleano(false);
		
		ValorInteiro v5 = new ValorInteiro(5);
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro n10 = new ValorInteiro(10);
		
		Expressao maigual1 = new ExpressaoMaiorIgual(v5, v10);
		Expressao maigual2 = new ExpressaoMaiorIgual(v10, v5);
		Expressao maigual3 = new ExpressaoMaiorIgual(n10, v10);
		
		Assert.assertEquals(f, maigual1.avaliar());
		Assert.assertEquals(v, maigual2.avaliar());
		Assert.assertEquals(v, maigual3.avaliar());
	}
	
	@Test
	public void testeMaiorIgualNok(){
		ValorBooleano v = new ValorBooleano(true);
		ValorBooleano f = new ValorBooleano(false);
		ValorInteiro v5 = new ValorInteiro(5);
		Expressao maiorIg = new ExpressaoMaiorIgual(v, v5);
		
		Assert.assertEquals(false, maiorIg.checarTipo());
		maiorIg = new ExpressaoMaiorIgual(v, f);
		
		Assert.assertEquals(false, maiorIg.checarTipo());
	}
}

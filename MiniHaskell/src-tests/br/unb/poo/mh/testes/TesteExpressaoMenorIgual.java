package br.unb.poo.mh.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoMenor;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoMenorIgual;;

public class TesteExpressaoMenorIgual {
	
	@Test
	public void testeMenorIgual(){
		ValorBooleano v = new ValorBooleano(true);
		ValorBooleano f = new ValorBooleano(false);
		
		ValorInteiro v5 = new ValorInteiro(5);
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro n10 = new ValorInteiro(10);
		
		Expressao meigual1 = new ExpressaoMenorIgual(v5, v10);
		Expressao meigual2 = new ExpressaoMenorIgual(v10, v5);
		Expressao meigual3 = new ExpressaoMenorIgual(n10, v10);
		
		Assert.assertEquals(v, meigual1.avaliar());
		Assert.assertEquals(f, meigual2.avaliar());
		Assert.assertEquals(v, meigual3.avaliar());
	}
	
	@Test
	public void testeMenorIgualNok(){
		ValorBooleano v = new ValorBooleano(true);
		ValorBooleano f = new ValorBooleano(false);
		ValorInteiro v5 = new ValorInteiro(5);
		Expressao menorIg = new ExpressaoMenorIgual(v, v5);
		
		Assert.assertEquals(false, menorIg.checarTipo());
		menorIg = new ExpressaoMenorIgual(v, f);
		
		Assert.assertEquals(false, menorIg.checarTipo());
	}
}

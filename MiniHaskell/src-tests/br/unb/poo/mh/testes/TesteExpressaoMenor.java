package br.unb.poo.mh.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoMaiorIgual;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoMenor;

public class TesteExpressaoMenor {
	
	@Test
	public void testeMenor(){
		ValorBooleano v = new ValorBooleano(true);
		ValorBooleano f = new ValorBooleano(false);
		
		ValorInteiro v5 = new ValorInteiro(5);
		ValorInteiro v10 = new ValorInteiro(10);
		
		Expressao menor1 = new ExpressaoMenor(v5, v10);
		Expressao menor2 = new ExpressaoMenor(v10, v5);
		
		Assert.assertEquals(v, menor1.avaliar());
		Assert.assertEquals(f, menor2.avaliar());
	}
	
	@Test
	public void testeMenorNok(){
		ValorBooleano v = new ValorBooleano(true);
		ValorBooleano f = new ValorBooleano(false);
		ValorInteiro v5 = new ValorInteiro(5);
		Expressao menor = new ExpressaoMenor(v, v5);
		
		Assert.assertEquals(false, menor.checarTipo());
		menor = new ExpressaoMenor(v, f);
		
		Assert.assertEquals(false, menor.checarTipo());
	}
}

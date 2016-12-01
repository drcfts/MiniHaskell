package br.unb.poo.mh.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoIgual;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoMaior;

public class TesteExpressaoMaior {
	
	@Test
	public void testeMaior(){
		ValorBooleano v = new ValorBooleano(true);
		ValorBooleano f = new ValorBooleano(false);
		
		ValorInteiro v5 = new ValorInteiro(5);
		ValorInteiro v10 = new ValorInteiro(10);
		
		Expressao maior1 = new ExpressaoMaior(v5, v10);
		Expressao maior2 = new ExpressaoMaior(v10, v5);
		
		Assert.assertEquals(f, maior1.avaliar());
		Assert.assertEquals(v, maior2.avaliar());
	}
	
	@Test
	public void testeMaiorNok(){
		ValorBooleano v = new ValorBooleano(true);
		ValorBooleano f = new ValorBooleano(false);
		ValorInteiro v5 = new ValorInteiro(5);
		Expressao maior = new ExpressaoMaior(v, v5);
		
		Assert.assertEquals(false, maior.checarTipo());
		maior = new ExpressaoMaior(v, f);
		
		Assert.assertEquals(false, maior.checarTipo());
	}
}

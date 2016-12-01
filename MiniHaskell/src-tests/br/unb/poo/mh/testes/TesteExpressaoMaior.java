package br.unb.poo.mh.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoMaior;

public class TesteExpressaoMaior {
	
	@Test
	public void testeMaior(){
		ValorInteiro v5 = new ValorInteiro(5);
		ValorInteiro v10 = new ValorInteiro(10);
		
		Expressao maior1 = new ExpressaoMaior(v5, v10);
		Expressao maior2 = new ExpressaoMaior(v10, v5);
		
		Assert.assertEquals(false, maior1.avaliar());
		Assert.assertEquals(true, maior2.avaliar());
	}
}

package br.unb.poo.mh.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoMenor;

public class TesteExpressaoMenor {
	
	@Test
	public void testeMenor(){
		ValorInteiro v5 = new ValorInteiro(5);
		ValorInteiro v10 = new ValorInteiro(10);
		
		Expressao menor1 = new ExpressaoMenor(v5, v10);
		Expressao menor2 = new ExpressaoMenor(v10, v5);
		
		Assert.assertEquals(true, menor1.avaliar());
		Assert.assertEquals(false, menor2.avaliar());
	}
}

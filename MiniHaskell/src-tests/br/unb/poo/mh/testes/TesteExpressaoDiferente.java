package br.unb.poo.mh.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoDiferente;



public class TesteExpressaoDiferente {
	
	@Test
	public void testeDiferenteInteiro(){
		ValorInteiro v5 = new ValorInteiro(5);
		ValorInteiro v10 = new ValorInteiro(10);
		
		Expressao dif1 = new ExpressaoDiferente(v5, v10);
		Expressao dif2 = new ExpressaoDiferente(v5, v5);
		
		Assert.assertEquals(true, dif1.avaliar());
		Assert.assertEquals(false, dif2.avaliar());
	}
	
	@Test
	public void testeDiferenteBooleano(){
		ValorBooleano v = new ValorBooleano(true);
		ValorBooleano f = new ValorBooleano(false);
		
		Expressao dif1 = new ExpressaoDiferente(v,f);
		Expressao dif2 = new ExpressaoDiferente(f,f);
		
		Assert.assertEquals(true, dif1.avaliar());
		Assert.assertEquals(false, dif2.avaliar());
	}
}

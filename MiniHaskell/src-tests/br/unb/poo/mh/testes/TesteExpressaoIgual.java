package br.unb.poo.mh.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoIgual;

public class TesteExpressaoIgual {
	
	@Test
	public void testeIgualInteiro(){
		ValorInteiro v5 = new ValorInteiro(5);
		ValorInteiro v10 = new ValorInteiro(10);
		
		Expressao igual1 = new ExpressaoIgual(v5, v10);
		Expressao igual2 = new ExpressaoIgual(v5, v5);
		
		Assert.assertEquals(false, igual1.avaliar());
		Assert.assertEquals(true, igual2.avaliar());
	}
	
	@Test
	public void testeIgualBooleano(){
		ValorBooleano v = new ValorBooleano(true);
		ValorBooleano f = new ValorBooleano(false);
		
		Expressao igual1 = new ExpressaoIgual(v,f);
		Expressao igual2 = new ExpressaoIgual(f,f);
		
		Assert.assertEquals(false, igual1.avaliar());
		Assert.assertEquals(true, igual2.avaliar());
	}
}

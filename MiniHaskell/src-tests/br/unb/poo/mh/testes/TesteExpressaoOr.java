package br.unb.poo.mh.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.expressoes.logicas.ExpressaoOr;

public class TesteExpressaoOr {
	
	ValorBooleano v = new ValorBooleano(true);
	ValorBooleano f = new ValorBooleano(false);
		
	@Test
	public void testeOrSimples(){
		Expressao or1 = new ExpressaoOr(v,f);
		Expressao or2 = new ExpressaoOr(f,v);
		Expressao or3 = new ExpressaoOr(v,v);
		Expressao or4 = new ExpressaoOr(f,f);
			
		Assert.assertEquals(true, or1.avaliar());
		Assert.assertEquals(true, or2.avaliar());
		Assert.assertEquals(true, or3.avaliar());
		Assert.assertEquals(false, or4.avaliar());
	}
		
	@Test
	public void testeOrComplexa(){
		Expressao or1 = new ExpressaoOr(f,f);
		Expressao or2 = new ExpressaoOr(or1,f);
		Expressao or3 = new ExpressaoOr(f,v);
		Expressao or4 = new ExpressaoOr(or3,f);
			
		Assert.assertEquals(false, or2.avaliar());
		Assert.assertEquals(true, or4.avaliar());
	}
	
}

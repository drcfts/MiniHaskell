package br.unb.poo.mh.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.expressoes.logicas.ExpressaoAnd;

public class TesteExpressaoAnd {
	
	ValorBooleano v = new ValorBooleano(true);
	ValorBooleano f = new ValorBooleano(false);
	
	@Test
	public void testeAndSimples(){
		Expressao and1 = new ExpressaoAnd(v,f);
		Expressao and2 = new ExpressaoAnd(f,v);
		Expressao and3 = new ExpressaoAnd(v,v);
		Expressao and4 = new ExpressaoAnd(f,f);
		
		Assert.assertEquals(false, and1.avaliar());
		Assert.assertEquals(false, and2.avaliar());
		Assert.assertEquals(true, and3.avaliar());
		Assert.assertEquals(false, and4.avaliar());
	}
	
	@Test
	public void testeAndComplexa(){
		Expressao and1 = new ExpressaoAnd(v,v);
		Expressao and2 = new ExpressaoAnd(and1,v);
		Expressao and3 = new ExpressaoAnd(f,v);
		Expressao and4 = new ExpressaoAnd(and3,v);
		
		Assert.assertEquals(true, and2.avaliar());
		Assert.assertEquals(false, and4.avaliar());
	}
	
}

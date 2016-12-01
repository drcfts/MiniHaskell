package br.unb.poo.mh.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.expressoes.logicas.ExpressaoNot;

public class TesteExpressaoNot {
	
	ValorBooleano v = new ValorBooleano(true);
	ValorBooleano f = new ValorBooleano(false);
	
	@Test
	public void testeNotSimples(){
		Expressao not1 = new ExpressaoNot(v);
		Expressao not2 = new ExpressaoNot(f);
		
		Assert.assertEquals(false, not1.avaliar());
		Assert.assertEquals(true, not2.avaliar());
	}
	
	@Test
	public void testeNotComplexo(){
		Expressao not1 = new ExpressaoNot(f);
		Expressao not2 = new ExpressaoNot(not1);
		Expressao not3 = new ExpressaoNot(v);
		Expressao not4 = new ExpressaoNot(not3);
			
		Assert.assertEquals(false, not2.avaliar());
		Assert.assertEquals(true, not4.avaliar());
	}
}

package br.unb.poo.mh.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.logicas.ExpressaoNot;

public class TesteExpressaoNot {
	
	ValorBooleano v = new ValorBooleano(true);
	ValorBooleano f = new ValorBooleano(false);
	
	@Test
	public void testeNotSimples(){
		Expressao not1 = new ExpressaoNot(v);
		Expressao not2 = new ExpressaoNot(f);
		
		Assert.assertEquals(f, not1.avaliar());
		Assert.assertEquals(v, not2.avaliar());
	}
	
	@Test
	public void testeNotComplexo(){
		Expressao not1 = new ExpressaoNot(f);
		Expressao not2 = new ExpressaoNot(not1);
		Expressao not3 = new ExpressaoNot(v);
		Expressao not4 = new ExpressaoNot(not3);
		Expressao notE = new ExpressaoNot(new ValorInteiro(5));
			
		Assert.assertEquals(f, not2.avaliar());
		Assert.assertEquals(v, not4.avaliar());
		Assert.assertEquals(Tipo.Booleano, not4.tipo());
		Assert.assertEquals(false, notE.checarTipo());
	}
}

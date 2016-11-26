package br.unb.poo.mh.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.matematicas.ExpressaoSoma;
import br.unb.poo.mh.expressoes.matematicas.ExpressaoMultiplicacao;
import br.unb.poo.mh.Identificador;
import br.unb.poo.mh.ExpressaoLet;

public class TesteExpressaoLet {
	private ValorInteiro v5 = new ValorInteiro(5);
	private ValorInteiro v10 = new ValorInteiro(10);
	private Identificador id = new Identificador("x");
	private Expressao soma1 = new ExpressaoSoma(id, v5);
	private Expressao soma2 = new ExpressaoSoma(id, id);
	private Expressao mult = new ExpressaoMultiplicacao(id, v5);
	private ExpressaoLet let = new ExpressaoLet("x", new ValorInteiro(25), soma1);
	private ExpressaoLet let2 = new ExpressaoLet("x", v10, soma2);
	private Expressao let3 = new ExpressaoLet("x", v10, mult);

	
	
	@Test
	public void testeLetSoma() {		
		// let x = 25 in x + 5
		Assert.assertEquals(new ValorInteiro(30), let.avaliar()); 
		// let x = 10 in x + x
		Assert.assertEquals(new ValorInteiro(20), let2.avaliar());
	}
	
	
	@Test
	public void testeLetMult() {
		// let x = 10 in x*5
		Assert.assertEquals(new ValorInteiro(50), let3.avaliar());
	}
	
	@Test
	public void testeLetLet(){
		//let x = 10 in (let x = 5 in x + x)
		
		ExpressaoLet letFinal =  new ExpressaoLet("x", v5, soma2);
		ExpressaoLet let4 = new ExpressaoLet("x", v10 , letFinal);
		Assert.assertEquals(new ValorInteiro(10), let4.avaliar());
	}
	

}

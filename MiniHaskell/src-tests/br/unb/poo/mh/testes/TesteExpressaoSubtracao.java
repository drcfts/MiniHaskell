package br.unb.poo.mh.testes;

import org.junit.Test;
import org.junit.Assert;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.matematicas.ExpressaoDivisao;
import br.unb.poo.mh.expressoes.matematicas.ExpressaoSubtracao;

public class TesteExpressaoSubtracao {
	
	private ValorInteiro v15 = new ValorInteiro(15);
	private ValorInteiro v2 = new ValorInteiro(2);
	private ValorInteiro v58 = new ValorInteiro(58);
	
	@Test
	public void testeSubSimples(){
		
		ExpressaoSubtracao sub1 = new ExpressaoSubtracao(v15, v2);
		
		Assert.assertEquals(new ValorInteiro(13), sub1.avaliar());
	}
	
	@Test
	public void testeSubComplexa(){
		
		ExpressaoSubtracao sub1 = new ExpressaoSubtracao(v15, v2);
		ExpressaoSubtracao sub2 = new ExpressaoSubtracao(v58, sub1);
		
		Assert.assertEquals(new ValorInteiro(45), sub2.avaliar());
		
		sub1.setExpEsquerda(v58);
		Assert.assertEquals(sub1.getExpEsquerda().avaliar(), v58);
		Assert.assertEquals(new ValorInteiro(2), sub2.avaliar());
		sub1.setExpDireita(v15);
		Assert.assertEquals(sub1.getExpDireita().avaliar(), v15);
		Assert.assertEquals(new ValorInteiro(43), sub1.avaliar());
		
	}
	
	@Test
	public void TesteExpressaoNok(){
		Expressao bool = new ValorBooleano(true);
		Expressao inteiro = new ValorInteiro(1);
		Expressao sub = new ExpressaoSubtracao(bool, inteiro);
		
		Assert.assertEquals(false, sub.checarTipo());
	}
}

package br.unb.poo.mh.testes;


import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.matematicas.ExpressaoDivisao;

public class TesteExpressaoDivisao {
	ValorInteiro v10 = new ValorInteiro(10);
	ValorInteiro v5 = new ValorInteiro(5);
	ValorInteiro v200 = new ValorInteiro(200);
	
	@Test
	public void testeExpressaoSimples() {
		
		Expressao m = new ExpressaoDivisao(v10, v5);
				
		Assert.assertEquals(new ValorInteiro(2), m.avaliar());
	}
	
	@Test
	public void TesteExpressaoComplexa() {
		// (200/5)/10
		Expressao interna = new ExpressaoDivisao(v200, v5);
		Expressao complexo = new ExpressaoDivisao(interna, v10);
		
		Assert.assertEquals(new ValorInteiro(4), complexo.avaliar());
		
	}
	
	@Test
	public void TesteExpressaoNok(){
		Expressao bool = new ValorBooleano(true);
		Expressao inteiro = new ValorInteiro(1);
		Expressao divisao = new ExpressaoDivisao(bool, inteiro);
		
		Assert.assertEquals(false, divisao.checarTipo());
	}
	
	
	
}

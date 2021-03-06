package br.unb.poo.mh.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.matematicas.ExpressaoSoma;
import br.unb.poo.mh.expressoes.matematicas.ExpressaoMultiplicacao;

public class TesteExpressaoMultiplicacao {

	@Test
	public void testeExpressaoOk() {
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro v5 = new ValorInteiro(5);
		Expressao m = new ExpressaoMultiplicacao(v10, new ExpressaoSoma(v10, v5));
		
		Assert.assertEquals(new ValorInteiro(150), m.avaliar());
	}
	
	@Test
	public void testeExpressaoNok() {
		ValorInteiro v10 = new ValorInteiro(10);
		ValorBooleano vtrue = new ValorBooleano(true);
		
		Expressao m = new ExpressaoMultiplicacao(v10, new ExpressaoSoma(v10, vtrue));
		
		Assert.assertEquals(Tipo.Error, m.tipo());
	}
}

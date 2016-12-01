package br.unb.poo.mh.testes;

import org.junit.Test;
import org.junit.Assert;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.IfThenElse;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoIgual;


public class TesteIfThenElse {
	
	@Test
	public void TesteIfSimples(){
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v1 = new ValorInteiro(1);
		
		Expressao expTeste = new IfThenElse(new ExpressaoIgual(v2, v1), new ValorInteiro(3), v1);
		
		Assert.assertEquals(v1, expTeste.avaliar());
		Assert.assertEquals(true, expTeste.checarTipo());
	}
}

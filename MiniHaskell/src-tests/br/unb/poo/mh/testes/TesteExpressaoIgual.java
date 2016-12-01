package br.unb.poo.mh.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoDiferente;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoIgual;

public class TesteExpressaoIgual {
	ValorBooleano v = new ValorBooleano(true);
	ValorBooleano f = new ValorBooleano(false);
	@Test
	public void testeIgualInteiro(){
		
		
		ValorInteiro v5 = new ValorInteiro(5);
		ValorInteiro v10 = new ValorInteiro(10);
		
		Expressao igual1 = new ExpressaoIgual(v5, v10);
		Expressao igual2 = new ExpressaoIgual(v5, v5);
		
		Assert.assertEquals(f, igual1.avaliar());
		Assert.assertEquals(v, igual2.avaliar());
	}
	
	@Test
	public void testeIgualBooleano(){
		
		Expressao igual1 = new ExpressaoIgual(v,f);
		Expressao igual2 = new ExpressaoIgual(f,f);
		
		Assert.assertEquals(f, igual1.avaliar());
		Assert.assertEquals(v, igual2.avaliar());
	}
	
	@Test
	public void testeIgualNok(){
		ValorInteiro v5 = new ValorInteiro(5);
		Expressao igual = new ExpressaoIgual(v, v5);
		
		Assert.assertEquals(false, igual.checarTipo());
	}
}

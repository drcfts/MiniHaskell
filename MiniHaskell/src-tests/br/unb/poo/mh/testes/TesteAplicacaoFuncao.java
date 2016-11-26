package br.unb.poo.mh.testes;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.unb.poo.mh.Ambiente;
import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.Identificador;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.matematicas.ExpressaoSoma;
import br.unb.poo.mh.funcao.AplicacaoFuncao;
import br.unb.poo.mh.funcao.DeclaracaoFuncao;

public class TesteAplicacaoFuncao {

	private DeclaracaoFuncao soma;
	
	@Before
	public void setUp() {
		List<String> args = new ArrayList<>();
		args.add("x");
		args.add("y");
		Expressao corpo = new ExpressaoSoma(new Identificador("x"), 
				new Identificador("y"));
		
		soma = new DeclaracaoFuncao("soma", args, corpo);
		Ambiente.instance().declaraFuncao(soma);
	}
	
	@Test
	public void testeAplicacaoFuncao() {
		List<Expressao> parametros = new ArrayList<>();
		parametros.add(new ValorInteiro(3));
		parametros.add(new ValorInteiro(4));
		
		Expressao aplicaSoma = new AplicacaoFuncao("soma", parametros);
		
		Assert.assertEquals(new ValorInteiro(7), aplicaSoma.avaliar());
	}
}

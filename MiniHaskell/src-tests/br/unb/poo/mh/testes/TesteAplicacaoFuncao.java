package br.unb.poo.mh.testes;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.unb.poo.mh.Ambiente;
import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.Identificador;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.matematicas.*;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoIgual;
import br.unb.poo.mh.funcao.AplicacaoFuncao;
import br.unb.poo.mh.funcao.ArgumentoFormal;
import br.unb.poo.mh.funcao.DeclaracaoFuncao;
import br.unb.poo.mh.IfThenElse;

public class TesteAplicacaoFuncao {

	private DeclaracaoFuncao soma;
	private DeclaracaoFuncao somaErrada;
	
	@Before
	public void setUp() {
		List<ArgumentoFormal> args = new ArrayList<>();
		args.add(new ArgumentoFormal(Tipo.Inteiro, "x"));
		args.add(new ArgumentoFormal(Tipo.Inteiro, "y"));
		Expressao corpo = new ExpressaoSoma(new Identificador("x"), 
				new Identificador("y"));
		
		soma = new DeclaracaoFuncao("soma", args, corpo);
		Ambiente.instance().declaraFuncao(soma);
		
		List<ArgumentoFormal> args2 = new ArrayList<>();
		args2.add(new ArgumentoFormal(Tipo.Booleano, "x"));
		args2.add(new ArgumentoFormal(Tipo.Inteiro, "y"));
		Expressao corpo2 = new ExpressaoSoma(new Identificador("x"), 
				new Identificador("y"));
		somaErrada = new DeclaracaoFuncao("somaErrada", args2, corpo2);
		Ambiente.instance().declaraFuncao(somaErrada);
	}
	

	
	@Test
	public void testeAplicacaoFuncao() {
		List<Expressao> parametros = new ArrayList<>();
		parametros.add(new ValorInteiro(3));
		parametros.add(new ValorInteiro(4));
		
		Expressao aplicaSoma = new AplicacaoFuncao("soma", parametros);
		
		Assert.assertEquals(new ValorInteiro(7), aplicaSoma.avaliar());
		Assert.assertEquals(true, aplicaSoma.checarTipo());
		Assert.assertEquals(Tipo.Funcao, aplicaSoma.tipo());
		
		List<Expressao> parametros2 = new ArrayList<>();
		parametros2.add(new ValorInteiro(3));
		parametros2.add(new ValorInteiro(4));
		
		Expressao aplicaSomaErrada = new AplicacaoFuncao("somaErrada", parametros2);
		Assert.assertEquals(false, aplicaSomaErrada.checarTipo());
		Assert.assertEquals(Tipo.Error, aplicaSomaErrada.tipo());
		
	}
	
	/**
	 * int fat (int x){
	 * 		if (x = 1)
	 * 			return 1;
	 * 		else
	 * 			return x*fat(x-1);
	 * }
	 */
	@Test
	public void testeFuncaoFatorial() {
		//Declaracao da funcao e parametros
		DeclaracaoFuncao fat = new DeclaracaoFuncao();
		fat.setNome("fat");
		fat.setArg(new ArgumentoFormal(Tipo.Inteiro, "x"));
		ValorInteiro v1 = new ValorInteiro(1);
		Ambiente amb = Ambiente.instance();
		
		Expressao corpo = new IfThenElse(new ExpressaoIgual(new Identificador("x"), v1), v1, new ExpressaoMultiplicacao(new Identificador("x"), new ExpressaoSubtracao(new Identificador("x"), v1)) );
		fat.setCorpo(corpo);
		
		//Declara no ambiente de execucao
		amb.declaraFuncao(fat);
		
		//Sera feita uma aplicacao da funcao fat
		//Para testar, sera feito o fatorial de 4
		ValorInteiro v4 = new ValorInteiro(4);
		AplicacaoFuncao af = new AplicacaoFuncao();
		af.setNome("fat");
		af.setParametro(v4);
		
		int respostaAtual = 1;
		int iteracoes = v4.getValor();
		
		while(iteracoes>0){
			ValorInteiro respostaIteracao = (ValorInteiro) af.avaliar();
			respostaAtual *= respostaIteracao.getValor();
			
			//Fat retorna x*(x-1)
			iteracoes -= 2;
			af.resetParametro(new ValorInteiro(iteracoes));
		}
		
		Assert.assertEquals(new ValorInteiro(24).getValor(), new ValorInteiro(respostaAtual).getValor());
	}
}

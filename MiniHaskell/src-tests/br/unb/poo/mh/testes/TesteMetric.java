package br.unb.poo.mh.testes;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Ambiente;
import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ExpressaoLet;
import br.unb.poo.mh.Identificador;
import br.unb.poo.mh.IfThenElse;
import br.unb.poo.mh.ListaVazia;
import br.unb.poo.mh.Metric;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.ValorLista;
import br.unb.poo.mh.expressoes.logicas.ExpressaoAnd;
import br.unb.poo.mh.expressoes.logicas.ExpressaoNot;
import br.unb.poo.mh.expressoes.logicas.ExpressaoOr;
import br.unb.poo.mh.expressoes.matematicas.ExpressaoDivisao;
import br.unb.poo.mh.expressoes.matematicas.ExpressaoMultiplicacao;
import br.unb.poo.mh.expressoes.matematicas.ExpressaoSoma;
import br.unb.poo.mh.expressoes.matematicas.ExpressaoSubtracao;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoDiferente;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoIgual;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoMaior;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoMaiorIgual;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoMenor;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoMenorIgual;
import br.unb.poo.mh.funcao.AplicacaoFuncao;
import br.unb.poo.mh.funcao.ArgumentoFormal;
import br.unb.poo.mh.funcao.DeclaracaoFuncao;

public class TesteMetric {

	@Test
	public void testeMetricMatematicas(){
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		Expressao soma = new ExpressaoSoma(v1,v2);
		Expressao sub = new ExpressaoSubtracao(soma,v1);
		Expressao mult = new ExpressaoMultiplicacao(v2,v1);
		Expressao div = new ExpressaoDivisao(v2,v1);
		
		Metric M = new Metric();
		
		v1.aceitar(M);
		Assert.assertEquals(1, M.getNumArgumentos());
		M.reset();
		
		v2.aceitar(M);
		Assert.assertEquals(1, M.getNumArgumentos());
		M.reset();
		
		soma.aceitar(M);
		Assert.assertEquals(3, M.getNumArgumentos());
		M.reset();
		
		sub.aceitar(M);
		Assert.assertEquals(5, M.getNumArgumentos());
		M.reset();
		
		mult.aceitar(M);
		Assert.assertEquals(3, M.getNumArgumentos());
		M.reset();
		
		div.aceitar(M);
		Assert.assertEquals(3, M.getNumArgumentos());
	}
	
	@Test
	public void testeMetricLogicas(){
		ValorBooleano v = new ValorBooleano(true);
		ValorBooleano f = new ValorBooleano(false);
		Expressao not = new ExpressaoNot(f);
		Expressao and = new ExpressaoAnd(f,v);
		Expressao or = new ExpressaoOr(and,f);
		
		Metric M = new Metric();
		
		v.aceitar(M);
		Assert.assertEquals(1, M.getNumArgumentos());
		M.reset();
		
		f.aceitar(M);
		Assert.assertEquals(1, M.getNumArgumentos());
		M.reset();
		
		not.aceitar(M);
		Assert.assertEquals(2, M.getNumArgumentos());
		M.reset();
		
		and.aceitar(M);
		Assert.assertEquals(3, M.getNumArgumentos());
		M.reset();
		
		or.aceitar(M);
		Assert.assertEquals(5, M.getNumArgumentos());
	}
	
	@Test
	public void testeMetricRelacionais(){
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		Expressao maior = new ExpressaoMaior(v1,v2);
		Expressao maiorigual = new ExpressaoMaiorIgual(v1,v2);
		Expressao menor = new ExpressaoMenor(v1,v2);
		Expressao menorigual = new ExpressaoMenorIgual(v2,v1);
		Expressao igual = new ExpressaoIgual(v1,v2);
		Expressao diferente = new ExpressaoDiferente(v1,v2);
		
		Metric M = new Metric();
		
		maior.aceitar(M);
		Assert.assertEquals(3, M.getNumArgumentos());
		M.reset();
		
		maiorigual.aceitar(M);
		Assert.assertEquals(3, M.getNumArgumentos());
		M.reset();
		
		menor.aceitar(M);
		Assert.assertEquals(3, M.getNumArgumentos());
		M.reset();
		
		menorigual.aceitar(M);
		Assert.assertEquals(3, M.getNumArgumentos());
		M.reset();
		
		igual.aceitar(M);
		Assert.assertEquals(3, M.getNumArgumentos());
		M.reset();
		
		diferente.aceitar(M);
		Assert.assertEquals(3, M.getNumArgumentos());		
	}
	
	@Test
	public void testeMetricIfThenElse(){
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v3 = new ValorInteiro(3);
		ValorInteiro v4 = new ValorInteiro(4);
		ValorInteiro v5 = new ValorInteiro(5);
		ValorInteiro v6 = new ValorInteiro(6);
		Expressao maior = new ExpressaoMaior(v2,v1);
		Expressao soma = new ExpressaoSoma(v4,v3);
		Expressao sub = new ExpressaoSubtracao(v6,v5);
		Expressao ifthenelse = new IfThenElse(maior,sub,soma);
		
		Metric M = new Metric();
		
		ifthenelse.aceitar(M);
		Assert.assertEquals(10, M.getNumArgumentos());
	}
	
	@Test
	public void testeMetricLet(){
		Expressao id = new Identificador("x");
		Expressao v20 = new ValorInteiro(20);
		Expressao v30 = new ValorInteiro(30);
		Expressao soma = new ExpressaoSoma(id,v30);
		Expressao let = new ExpressaoLet("x",v20,soma);
		
		Metric M = new Metric();
		
		id.aceitar(M);
		Assert.assertEquals(1, M.getNumArgumentos());
		M.reset();
		
		let.aceitar(M);
		Assert.assertEquals(5, M.getNumArgumentos());
	}
	
	@Test
	public void testeMetricAplicacaoFuncao(){
		DeclaracaoFuncao soma;
		List<ArgumentoFormal> args = new ArrayList<>();
		args.add(new ArgumentoFormal(Tipo.Inteiro, "x"));
		args.add(new ArgumentoFormal(Tipo.Inteiro, "y"));
		Expressao corpo = new ExpressaoSoma(new Identificador("x"), 
				new Identificador("y"));
		
		soma = new DeclaracaoFuncao("soma", args, corpo);
		Ambiente.instance().declaraFuncao(soma);
		
		List<Expressao> parametros = new ArrayList<>();
		parametros.add(new ValorInteiro(3));
		parametros.add(new ValorInteiro(4));
		
		Expressao aplicaSoma = new AplicacaoFuncao("soma", parametros);
		
		Metric M = new Metric();
		
		aplicaSoma.aceitar(M);
		Assert.assertEquals(3, M.getNumArgumentos());
	}
	
	@Test
	public void testeMetricListas(){
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v3 = new ValorInteiro(3);
		ValorLista<ValorInteiro> listavazia = new ListaVazia<ValorInteiro>();
		ValorLista<ValorInteiro> lista = new ListaVazia<ValorInteiro>();
		lista = lista.inserir(v1);
		lista = lista.inserir(v2);
		lista = lista.inserir(v3);
		
		Metric M = new Metric();
		
		listavazia.aceitar(M);
		Assert.assertEquals(1, M.getNumArgumentos());
		M.reset();
		
		lista.aceitar(M);
		Assert.assertEquals(4, M.getNumArgumentos());
	}
		
}

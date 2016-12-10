package br.unb.poo.mh.testes;

import java.util.ArrayList;
import java.util.List;

import br.unb.poo.mh.Ambiente;
import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.Identificador;
import br.unb.poo.mh.ListaVazia;
import br.unb.poo.mh.PrettyPrinter;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.ValorLista;
import br.unb.poo.mh.expressoes.logicas.ExpressaoAnd;
import br.unb.poo.mh.expressoes.logicas.ExpressaoNot;
import br.unb.poo.mh.expressoes.logicas.ExpressaoOr;
import br.unb.poo.mh.expressoes.matematicas.*;
import br.unb.poo.mh.expressoes.relacionais.*;
import br.unb.poo.mh.funcao.AplicacaoFuncao;
import br.unb.poo.mh.funcao.ArgumentoFormal;
import br.unb.poo.mh.funcao.DeclaracaoFuncao;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.*;

public class TestePrettyPrinter {
	
	@Test
	public void testePrettyPrinterMatematicas(){
		Expressao v10 = new ValorInteiro(10);
		Expressao v5 = new ValorInteiro(5);
		Expressao soma = new ExpressaoSoma(v10,v5);
		Expressao sub = new ExpressaoSubtracao(v10,v5);
		Expressao div = new ExpressaoDivisao(soma,sub);
		Expressao mult = new ExpressaoMultiplicacao(div, v10);
		
		PrettyPrinter PP = new PrettyPrinter();
		
		v10.aceitar(PP);
		Assert.assertEquals("10", PP.getPP());
		PP.reset();
		
		v5.aceitar(PP);
		Assert.assertEquals("5", PP.getPP());
		PP.reset();
		
		soma.aceitar(PP);
		Assert.assertEquals("(10+5)", PP.getPP());
		PP.reset();
		
		sub.aceitar(PP);
		Assert.assertEquals("(10-5)", PP.getPP());
		PP.reset();
		
		div.aceitar(PP);
		Assert.assertEquals("((10+5)/(10-5))", PP.getPP());
		PP.reset();
		
		mult.aceitar(PP);
		Assert.assertEquals("(((10+5)/(10-5))*10)", PP.getPP());
	}
	
	@Test
	public void testePrettyPrinterLogicas(){
		Expressao f = new ValorBooleano(false);
		Expressao v = new ValorBooleano(true);
		Expressao not = new ExpressaoNot(f);
		Expressao and = new ExpressaoAnd(not,v);
		Expressao or = new ExpressaoOr(and,f);
		
		PrettyPrinter PP = new PrettyPrinter();
		
		f.aceitar(PP);
		Assert.assertEquals("false", PP.getPP());
		PP.reset();
		
		v.aceitar(PP);
		Assert.assertEquals("true", PP.getPP());
		PP.reset();
		
		not.aceitar(PP);
		Assert.assertEquals("!(false)", PP.getPP());
		PP.reset();
		
		and.aceitar(PP);
		Assert.assertEquals("(!(false)&&true)", PP.getPP());
		PP.reset();
		
		or.aceitar(PP);
		Assert.assertEquals("((!(false)&&true)||false)", PP.getPP());
	}
	
	@Test
	public void testePrettyPrinterAritmeticas(){
		Expressao v10 = new ValorInteiro(10);
		Expressao v5 = new ValorInteiro(5);
		Expressao v2 = new ValorInteiro(2);
		Expressao maior = new ExpressaoMaior(v10,v5);
		Expressao maiorigual = new ExpressaoMaiorIgual(v5,v5);
		Expressao and1 = new ExpressaoAnd(maior,maiorigual);
		Expressao menor = new ExpressaoMenor(v5,v2);
		Expressao menorigual = new ExpressaoMenorIgual(v2,v5);
		Expressao and2 = new ExpressaoAnd(menor, menorigual);
		Expressao igual = new ExpressaoIgual(v10,v5);
		Expressao diferente = new ExpressaoDiferente(v2,v2);
		Expressao and3 = new ExpressaoAnd(igual,diferente);
		Expressao or1 = new ExpressaoOr(and1,and2);
		Expressao fim = new ExpressaoOr(or1, and3);
		
		PrettyPrinter PP = new PrettyPrinter();
			
		v2.aceitar(PP);
		Assert.assertEquals("2", PP.getPP());
		PP.reset();
		
		maior.aceitar(PP);
		Assert.assertEquals("(10>5)", PP.getPP());
		PP.reset();
		
		maiorigual.aceitar(PP);
		Assert.assertEquals("(5>=5)", PP.getPP());
		PP.reset();
		
		menor.aceitar(PP);
		Assert.assertEquals("(5<2)", PP.getPP());
		PP.reset();
		
		menorigual.aceitar(PP);
		Assert.assertEquals("(2<=5)", PP.getPP());
		PP.reset();
		
		igual.aceitar(PP);
		Assert.assertEquals("(10==5)", PP.getPP());
		PP.reset();
		
		diferente.aceitar(PP);
		Assert.assertEquals("(2/=2)", PP.getPP());
		PP.reset();
		
		fim.aceitar(PP);
		Assert.assertEquals("((((10>5)&&(5>=5))||((5<2)&&(2<=5)))||((10==5)&&(2/=2)))", PP.getPP());
	}
	
	@Test
	public void testeIfThenElse(){
		Expressao v10 = new ValorInteiro(10);
		Expressao v5 = new ValorInteiro(5);
		Expressao maior = new ExpressaoMaior(v10,v5);
		Expressao soma = new ExpressaoSoma(v10,v5);
		Expressao sub = new ExpressaoSubtracao(v10,v5);
		Expressao ifthenelse = new IfThenElse(maior,sub,soma);
		
		PrettyPrinter PP = new PrettyPrinter();
		
		ifthenelse.aceitar(PP);
		Assert.assertEquals("if((10>5)) then (10-5) else (10+5)", PP.getPP());
	}
	
	@Test
	public void testeExpressaoLet(){
		Expressao id = new Identificador("x");
		Expressao v20 = new ValorInteiro(20);
		Expressao v30 = new ValorInteiro(30);
		Expressao soma = new ExpressaoSoma(id,v30);
		Expressao let = new ExpressaoLet("x",v20,soma);
		
		PrettyPrinter PP = new PrettyPrinter();
		
		id.aceitar(PP);
		Assert.assertEquals("x", PP.getPP());
		PP.reset();
		
		let.aceitar(PP);
		Assert.assertEquals("let x = 20 in (x+30)", PP.getPP());	
	}
	
	@Test
	public void testeAplicacaoFuncao(){
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
		
		PrettyPrinter PP = new PrettyPrinter();
		
		aplicaSoma.aceitar(PP);
		Assert.assertEquals("soma(3,4)", PP.getPP());	
	}
	
	@Test
	public void testeListas(){
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v3 = new ValorInteiro(3);
		ValorLista<ValorInteiro> listavazia = new ListaVazia<ValorInteiro>();
		ValorLista<ValorInteiro> lista = new ListaVazia<ValorInteiro>();
		lista = lista.inserir(v1);
		lista = lista.inserir(v2);
		lista = lista.inserir(v3);
		
		PrettyPrinter PP = new PrettyPrinter();
		
		listavazia.aceitar(PP);
		Assert.assertEquals("[]", PP.getPP());
		PP.reset();
		
		lista.aceitar(PP);
		Assert.assertEquals("[3,2,1]", PP.getPP().toString());
	}

	
	
	
	
	
	
	
	
}

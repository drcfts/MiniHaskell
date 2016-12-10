package br.unb.poo.mh.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.IfThenElse;
import br.unb.poo.mh.Refactoring;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.expressoes.logicas.ExpressaoAnd;
import br.unb.poo.mh.expressoes.logicas.ExpressaoNot;
import br.unb.poo.mh.expressoes.logicas.ExpressaoOr;
import br.unb.poo.mh.expressoes.matematicas.ExpressaoDivisao;
import br.unb.poo.mh.expressoes.matematicas.ExpressaoMultiplicacao;
import br.unb.poo.mh.expressoes.matematicas.ExpressaoSoma;
import br.unb.poo.mh.expressoes.matematicas.ExpressaoSubtracao;
import br.unb.poo.mh.expressoes.relacionais.ExpressaoMaior;

public class TesteRefactoring {
	
	@Test
	public void testeRefactoringSoma(){
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v0 = new ValorInteiro(0);
		Expressao soma1 = new ExpressaoSoma(v1,v0);
		Expressao soma2 = new ExpressaoSoma(v0,v1);
		
		Refactoring R1 = new Refactoring();
		Refactoring R2 = new Refactoring();
		
		soma1.aceitar(R1);
		Assert.assertEquals(v1, R1.getExp_Refactoring());
		
		soma2.aceitar(R2);
		Assert.assertEquals(v1, R2.getExp_Refactoring());	
	}
	
	@Test 
	public void testeRefactoringMultiplicacao(){
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v0 = new ValorInteiro(0);
		Expressao mult1 = new ExpressaoMultiplicacao(v2,v0);
		Expressao mult2 = new ExpressaoMultiplicacao(v2,v1);
		Expressao mult3 = new ExpressaoMultiplicacao(v1,v2);
		Expressao mult4 = new ExpressaoMultiplicacao(v0,v2);
		
		Refactoring R1 = new Refactoring();
		Refactoring R2 = new Refactoring();
		Refactoring R3 = new Refactoring();
		Refactoring R4 = new Refactoring();
		
		mult1.aceitar(R1);
		Assert.assertEquals(v0, R1.getExp_Refactoring());
		
		mult2.aceitar(R2);
		Assert.assertEquals(v2, R2.getExp_Refactoring());
		
		mult3.aceitar(R3);
		Assert.assertEquals(v2, R3.getExp_Refactoring());
		
		mult4.aceitar(R4);
		Assert.assertEquals(v0, R4.getExp_Refactoring());
	}
	
	@Test 
	public void testeRefactoringDivisao(){
		
		ValorInteiro v7 = new ValorInteiro(7);		
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v1 = new ValorInteiro(1);
		
		Refactoring R1 = new Refactoring();
		Refactoring R2 = new Refactoring();
		
		
		Expressao div2 = new ExpressaoDivisao(v2,v1);
		
		div2.aceitar(R1);
		Assert.assertEquals(v2,R1.getExp_Refactoring());
		
		Expressao div7 = new ExpressaoDivisao(v7,v1);
		
		div7.aceitar(R2);
		Assert.assertEquals(v7,R2.getExp_Refactoring());
	}
	
	@Test
	public void testeRefactoringSubtracao(){
		ValorInteiro v5 = new ValorInteiro(5);		
		ValorInteiro v3 = new ValorInteiro(3);
		ValorInteiro v0 = new ValorInteiro(0);
		
		Refactoring R1 = new Refactoring();
		Refactoring R2 = new Refactoring();
		
		
		Expressao sub5 = new ExpressaoSubtracao(v5,v0);
		sub5.aceitar(R1);
		Assert.assertEquals(v5,R1.getExp_Refactoring());
		
		Expressao sub3 = new ExpressaoSubtracao(v3,v0);
		
		sub3.aceitar(R2);
		Assert.assertEquals(v3,R2.getExp_Refactoring());
	}
	
	@Test
	public void testeRefactoringAnd(){
		ValorBooleano f = new ValorBooleano(false);
		ValorBooleano v = new ValorBooleano(true);
		Expressao not1 = new ExpressaoNot(f);
		Expressao not2 = new ExpressaoNot(f);
		Expressao not3 = new ExpressaoNot(v);
		Expressao not4 = new ExpressaoNot(v);
		Expressao and1 = new ExpressaoAnd(not1,not2);
		Expressao and2 = new ExpressaoAnd(not3,not4);
		Expressao and3 = new ExpressaoAnd(not1,not3);
		Expressao and4 = new ExpressaoAnd(not3,not1);
		
		Refactoring R1 = new Refactoring();
		Refactoring R2 = new Refactoring();
		Refactoring R3 = new Refactoring();
		Refactoring R4 = new Refactoring();
		
		and1.aceitar(R1);
		Assert.assertEquals(v, R1.getExp_Refactoring().avaliar());
		
		and2.aceitar(R2);
		Assert.assertEquals(f, R2.getExp_Refactoring().avaliar());
		
		and3.aceitar(R3);
		Assert.assertEquals(f, R3.getExp_Refactoring().avaliar());
		
		and4.aceitar(R4);
		Assert.assertEquals(f, R4.getExp_Refactoring().avaliar());
	}
	
	@Test
	public void testeRefactoringOr(){
		ValorBooleano f = new ValorBooleano(false);
		ValorBooleano v = new ValorBooleano(true);
		Expressao not1 = new ExpressaoNot(f);
		Expressao not2 = new ExpressaoNot(f);
		Expressao not3 = new ExpressaoNot(v);
		Expressao not4 = new ExpressaoNot(v);
		Expressao or1 = new ExpressaoOr(not1,not2);
		Expressao or2 = new ExpressaoOr(not1,not3);
		Expressao or3 = new ExpressaoOr(not3,not1);
		Expressao or4 = new ExpressaoOr(not3,not4);
		
		Refactoring R1 = new Refactoring();
		Refactoring R2 = new Refactoring();
		Refactoring R3 = new Refactoring();
		Refactoring R4 = new Refactoring();
		
		or1.aceitar(R1);
		Assert.assertEquals(v, R1.getExp_Refactoring().avaliar());
		
		or2.aceitar(R2);
		Assert.assertEquals(v, R2.getExp_Refactoring().avaliar());
		
		or3.aceitar(R3);
		Assert.assertEquals(v, R1.getExp_Refactoring().avaliar());
		
		or4.aceitar(R4);
		Assert.assertEquals(v, R1.getExp_Refactoring().avaliar());
	}
	
	@Test 
	public void testeRefactoringIfThenElse(){
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		
		ValorInteiro v5 = new ValorInteiro(5);
		ValorInteiro v6 = new ValorInteiro(6);
		
		Expressao maior = new ExpressaoMaior(v2,v1);
		Expressao maior2 = new ExpressaoMaior(v5,v6);
		
		Expressao f = new ValorBooleano(false);
		Expressao v = new ValorBooleano(true);
		
		Refactoring R1 = new Refactoring();
		Refactoring R2 = new Refactoring();
		
		Expressao ifthenelse = new IfThenElse(maior,v,f);
		Expressao ifthenelse2 = new IfThenElse(maior2,v,f);
				
		ifthenelse.aceitar(R1);
		Assert.assertEquals(v, R1.getExp_Refactoring().avaliar());
		
		ifthenelse2.aceitar(R2);
		Assert.assertEquals(f, R2.getExp_Refactoring().avaliar());
		
		
	}
	
}

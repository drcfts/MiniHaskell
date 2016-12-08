package br.unb.poo.mh;

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

public class PrettyPrinter implements Visitor{

	@Override
	public void visitar(ValorInteiro exp) {
		System.out.print(exp.getValor());
	}

	@Override
	public void visitar(ValorBooleano exp) {
		System.out.print(exp.getValor());
	}

	@Override
	public void visitar(ExpressaoSoma exp) {
		System.out.print("(");
		exp.expEsquerda.aceitar(this);
		System.out.print("+");
		exp.expDireita.aceitar(this);
		System.out.print(")");
	}

	@Override
	public void visitar(ExpressaoMultiplicacao exp) {
		System.out.print("(");
		exp.expEsquerda.aceitar(this);
		System.out.print("*");
		exp.expDireita.aceitar(this);
		System.out.print(")");
	}

	@Override
	public void visitar(IfThenElse exp) {
		System.out.print("if( ");
		exp.getCondicao().aceitar(this);
		System.out.println(")");
		
		System.out.print("then ");
		exp.getClausulaThen().aceitar(this);
		
		System.out.println("else " );
		exp.getClausulaElse().aceitar(this);
	}

	@Override
	public void visitar(AplicacaoFuncao exp) {
		System.out.print(exp.getNome());
		System.out.print("(");
		int i = 0;
		while(i < exp.getParametros().size() - 1) {
			exp.getParametros().get(i++).aceitar(this);
			System.out.print(",");
		}
		if(i == exp.getParametros().size() - 1) {
			exp.getParametros().get(i++).aceitar(this);
		}
		System.out.println(")");
	}

	@Override
	public void visitar(Identificador exp) {
		System.out.println(exp.getId());
	}

	@Override
	public void visitar(ExpressaoDivisao exp) {
		// TODO Auto-generated method stub
		System.out.print("(");
		exp.expEsquerda.aceitar(this);
		System.out.print(" / ");
		exp.expDireita.aceitar(this);
		System.out.print(")");
	}

	@Override
	public void visitar(ExpressaoSubtracao exp) {
		// TODO Auto-generated method stub
		System.out.print("(");
		exp.expEsquerda.aceitar(this);
		System.out.print(" - ");
		exp.expDireita.aceitar(this);
		System.out.print(")");
		
	}

	@Override
	public void visitar(ExpressaoDiferente exp) {
		// TODO Auto-generated method stub
		System.out.print("(");
		exp.expEsquerda.aceitar(this);
		System.out.print(" /= ");
		exp.expDireita.aceitar(this);
		System.out.print(")");
	}

	@Override
	public void visitar(ExpressaoIgual exp) {
		// TODO Auto-generated method stub
		System.out.print("(");
		exp.expEsquerda.aceitar(this);
		System.out.print(" == ");
		exp.expDireita.aceitar(this);
		System.out.print(")");
	}

	@Override
	public void visitar(ExpressaoMaior exp) {
		// TODO Auto-generated method stub
		System.out.print("(");
		exp.expEsquerda.aceitar(this);
		System.out.print(" > ");
		exp.expDireita.aceitar(this);
		System.out.print(")");
		
	}

	@Override
	public void visitar(ExpressaoMenor exp) {
		// TODO Auto-generated method stub
		System.out.print("(");
		exp.expEsquerda.aceitar(this);
		System.out.print(" < ");
		exp.expDireita.aceitar(this);
		System.out.print(")");
	}

	@Override
	public void visitar(ExpressaoMenorIgual exp) {
		// TODO Auto-generated method stub
		System.out.print("(");
		exp.expEsquerda.aceitar(this);
		System.out.print(" <= ");
		exp.expDireita.aceitar(this);
		System.out.print(")");
	}

	@Override
	public void visitar(ExpressaoMaiorIgual exp) {
		// TODO Auto-generated method stub
		System.out.print("(");
		exp.expEsquerda.aceitar(this);
		System.out.print(" >= ");
		exp.expDireita.aceitar(this);
		System.out.print(")");
	}

	@Override
	public void visitar(ExpressaoAnd exp) {
		// TODO Auto-generated method stub
		System.out.print("(");
		exp.expEsquerda.aceitar(this);
		System.out.print(" && ");
		exp.expDireita.aceitar(this);
		System.out.print(")");
	}

	@Override
	public void visitar(ExpressaoOr exp) {
		// TODO Auto-generated method stub
		System.out.print("(");
		exp.expEsquerda.aceitar(this);
		System.out.print(" || ");
		exp.expDireita.aceitar(this);
		System.out.print(")");
	}

	@Override
	public void visitar(ExpressaoNot exp) {
		// TODO Auto-generated method stub
		System.out.print("!(");
		exp.uni.aceitar(this);
		System.out.print(")");
	}

	@Override
	public void visitar(ExpressaoLet exp) {
		// let x=20 in x+30
		// TODO Auto-generated method stub
		// parte let x = 20
		System.out.print("let ");
		System.out.print(exp.getId());
		System.out.print(" = ");
		exp.getExpressao().aceitar(this);
		System.out.print(" in ");
		exp.getAtrib().aceitar(this);
		
	}

	@Override
	public void visitar(ListaVazia<?> exp) {
		// TODO Auto-generated method stub
		// lista vazia = []
		System.out.println("[]");
	}

	@Override
	
	public void visitar(ListaNaoVazia<?> exp) {
		// TODO Auto-generated method stub
		// [1,2,3,4,5]
		int i=0;
		int tamanho = ((ValorInteiro)exp.tamanho()).getValor();	
		ValorLista<?> listaPrettyPrinter= exp;	
		System.out.print("[");
		
		while(i<tamanho){
			System.out.print(listaPrettyPrinter.getInicio());	
			listaPrettyPrinter = listaPrettyPrinter.getCauda();
			
			i++;
			if(i!= tamanho){
				System.out.print(",");		
			}
			
		}
		System.out.print("]");
		
		
		
	}

}

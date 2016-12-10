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

	String PP = "";
	
	public String getPP(){
		return PP;
	}
	
	public void reset(){
		PP = "";
	}
	
	@Override
	public void visitar(ValorInteiro exp) {
		PP=PP+exp.getValor();
		System.out.print(PP);
	}

	@Override
	public void visitar(ValorBooleano exp) {
		PP=PP+exp.getValor();
		System.out.print(PP);
	}

	@Override
	public void visitar(ExpressaoSoma exp) {
		PP=PP+"(";
		exp.expEsquerda.aceitar(this);
		PP=PP+"+";
		exp.expDireita.aceitar(this);
		PP=PP+")";
		System.out.print(PP);
	}

	@Override
	public void visitar(ExpressaoMultiplicacao exp) {
		PP=PP+"(";
		exp.expEsquerda.aceitar(this);
		PP=PP+"*";
		exp.expDireita.aceitar(this);
		PP=PP+")";
		System.out.print(PP);
	}

	@Override
	public void visitar(IfThenElse exp) {
		PP=PP+"if(";
		exp.getCondicao().aceitar(this);
		PP=PP+")";
		
		PP=PP+" then ";
		exp.getClausulaThen().aceitar(this);

		PP=PP+" else ";
		exp.getClausulaElse().aceitar(this);
		System.out.print(PP);
	}

	@Override
	public void visitar(AplicacaoFuncao exp) {
		PP=PP+exp.getNome();
		PP=PP +"(";
		int i = 0;
		while(i < exp.getParametros().size() - 1) {
			exp.getParametros().get(i++).aceitar(this);
			PP=PP+",";
		}
		if(i == exp.getParametros().size() - 1) {
			exp.getParametros().get(i++).aceitar(this);
		}
		PP=PP+")";
		System.out.print(PP);
	}

	@Override
	public void visitar(Identificador exp) {
		PP=PP+exp.getId();
		System.out.print(PP);
	}

	@Override
	public void visitar(ExpressaoDivisao exp) {
		// TODO Auto-generated method stub
		PP=PP+"(";
		exp.expEsquerda.aceitar(this);
		PP=PP+"/";
		exp.expDireita.aceitar(this);
		PP=PP+")";
		System.out.print(PP);
	}

	@Override
	public void visitar(ExpressaoSubtracao exp) {
		// TODO Auto-generated method stub
		PP=PP+"(";
		exp.expEsquerda.aceitar(this);
		PP=PP+"-";
		exp.expDireita.aceitar(this);
		PP=PP+")";
		System.out.print(PP);
	}

	@Override
	public void visitar(ExpressaoDiferente exp) {
		// TODO Auto-generated method stub
		PP=PP+"(";
		exp.expEsquerda.aceitar(this);
		PP=PP+"/=";
		exp.expDireita.aceitar(this);
		PP=PP +")";
		System.out.print(PP);
	}

	@Override
	public void visitar(ExpressaoIgual exp) {
		// TODO Auto-generated method stub
		PP=PP+"(";
		exp.expEsquerda.aceitar(this);
		PP=PP+"==";
		exp.expDireita.aceitar(this);
		PP=PP+")";
		System.out.print(PP);
	}

	@Override
	public void visitar(ExpressaoMaior exp) {
		// TODO Auto-generated method stub
		PP=PP+"(";
		exp.expEsquerda.aceitar(this);
		PP=PP+">";
		exp.expDireita.aceitar(this);
		PP=PP+")";
		System.out.print(PP);
	}

	@Override
	public void visitar(ExpressaoMenor exp) {
		// TODO Auto-generated method stub
		PP=PP+"(";
		exp.expEsquerda.aceitar(this);
		PP=PP+"<";
		exp.expDireita.aceitar(this);
		PP=PP+")";
		System.out.print(PP);
	}

	@Override
	public void visitar(ExpressaoMenorIgual exp) {
		// TODO Auto-generated method stub
		PP=PP+"(";
		exp.expEsquerda.aceitar(this);
		PP=PP+"<=";
		exp.expDireita.aceitar(this);
		PP=PP+")";
		System.out.print(PP);
	}

	@Override
	public void visitar(ExpressaoMaiorIgual exp) {
		// TODO Auto-generated method stub
		PP=PP+"(";
		exp.expEsquerda.aceitar(this);
		PP=PP+">=";
		exp.expDireita.aceitar(this);
		PP=PP+")";
		System.out.print(PP);
	}

	@Override
	public void visitar(ExpressaoAnd exp) {
		// TODO Auto-generated method stub
		PP=PP+"(";
		exp.expEsquerda.aceitar(this);
		PP=PP+"&&";
		exp.expDireita.aceitar(this);
		PP=PP+")";
		System.out.print(PP);
	}

	@Override
	public void visitar(ExpressaoOr exp) {
		// TODO Auto-generated method stub
		PP=PP+"(";
		exp.expEsquerda.aceitar(this);
		PP=PP+"||";
		exp.expDireita.aceitar(this);
		PP=PP+")";
		System.out.print(PP);
	}

	@Override
	public void visitar(ExpressaoNot exp) {
		// TODO Auto-generated method stub
		PP=PP+"!(";
		exp.uni.aceitar(this);
		PP=PP+")";
		System.out.print(PP);
	}

	@Override
	public void visitar(ExpressaoLet exp) {
		// let x=20 in x+30
		// TODO Auto-generated method stub
		// parte let x = 20
		PP=PP+"let ";
		PP=PP+exp.getId();
		PP=PP+" = ";
		exp.getAtrib().aceitar(this);
		PP=PP+" in ";
		exp.getExpressao().aceitar(this);
		System.out.print(PP);
	}

	@Override
	public void visitar(ListaVazia<?> exp) {
		// TODO Auto-generated method stub
		// lista vazia = []
		PP=PP+"[]";
		System.out.print(PP);
	}

	@Override
	
	public void visitar(ListaNaoVazia<?> exp) {
		// TODO Auto-generated method stub
		// [1,2,3,4,5]
		int i=0;
		int tamanho = ((ValorInteiro)exp.tamanho()).getValor();	
		ValorLista<?> listaPrettyPrinter= exp;	
		PP=PP+"[";
		
		while(i<tamanho){
			if(listaPrettyPrinter.getInicio().tipo() == Tipo.Inteiro){
				PP=PP+((ValorInteiro)listaPrettyPrinter.getInicio()).getValor();	
			}
			else if(listaPrettyPrinter.getInicio().tipo() == Tipo.Booleano){
				PP=PP+((ValorBooleano)listaPrettyPrinter.getInicio()).getValor();	
			}
			listaPrettyPrinter = listaPrettyPrinter.getCauda();
			
			i++;
			if(i!= tamanho){
				PP=PP+",";		
			}
			
		}
		PP=PP+"]";
		System.out.print(PP);
	}

}

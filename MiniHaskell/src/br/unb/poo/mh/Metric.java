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

public class Metric implements Visitor {

	private int NumArgumentos = 0;
	
	public void reset(){
		NumArgumentos = 0;
	}
	
	@Override
	public void visitar(ValorInteiro exp) {
		// TODO Auto-generated method stub
		NumArgumentos ++;
	}

	@Override
	public void visitar(ValorBooleano exp) {
		// TODO Auto-generated method stub
		NumArgumentos ++;
	}

	@Override
	public void visitar(ExpressaoSoma exp) {
		// TODO Auto-generated method stub
		NumArgumentos ++;
		exp.getExpDireita().aceitar(this);
		exp.getExpEsquerda().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoMultiplicacao exp) {
		// TODO Auto-generated method stub
		NumArgumentos ++;
		exp.getExpDireita().aceitar(this);
		exp.getExpEsquerda().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoDivisao exp) {
		// TODO Auto-generated method stub
		NumArgumentos ++;
		exp.getExpDireita().aceitar(this);
		exp.getExpEsquerda().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoSubtracao exp) {
		// TODO Auto-generated method stub
		NumArgumentos ++;
		exp.getExpDireita().aceitar(this);
		exp.getExpEsquerda().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoDiferente exp) {
		// TODO Auto-generated method stub
		NumArgumentos ++;
		exp.getExpDireita().aceitar(this);
		exp.getExpEsquerda().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoIgual exp) {
		// TODO Auto-generated method stub
		NumArgumentos ++;
		exp.getExpDireita().aceitar(this);
		exp.getExpEsquerda().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoMaior exp) {
		// TODO Auto-generated method stub
		NumArgumentos ++;
		exp.getExpDireita().aceitar(this);
		exp.getExpEsquerda().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoMenor exp) {
		// TODO Auto-generated method stub
		NumArgumentos ++;
		exp.getExpDireita().aceitar(this);
		exp.getExpEsquerda().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoMenorIgual exp) {
		// TODO Auto-generated method stub
		NumArgumentos ++;
		exp.getExpDireita().aceitar(this);
		exp.getExpEsquerda().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoMaiorIgual exp) {
		// TODO Auto-generated method stub
		NumArgumentos ++;
		exp.getExpDireita().aceitar(this);
		exp.getExpEsquerda().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoAnd exp) {
		// TODO Auto-generated method stub
		NumArgumentos ++;
		exp.getExpDireita().aceitar(this);
		exp.getExpEsquerda().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoOr exp) {
		// TODO Auto-generated method stub
		NumArgumentos ++;
		exp.getExpDireita().aceitar(this);
		exp.getExpEsquerda().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoNot exp) {
		// TODO Auto-generated method stub
		NumArgumentos ++;
		exp.getUni().aceitar(this);
		
	}

	@Override
	public void visitar(IfThenElse exp) {
		// TODO Auto-generated method stub
		NumArgumentos ++;
		exp.getClausulaElse().aceitar(this);
		exp.getClausulaThen().aceitar(this);
		exp.getCondicao().aceitar(this);
	}

	@Override
	public void visitar(AplicacaoFuncao exp) {
		// TODO Auto-generated method stub
		NumArgumentos ++;
		for(Expressao TodosParametros :exp.getParametros()){
			TodosParametros.aceitar(this);
		}
	}

	@Override
	public void visitar(Identificador exp) {
		// TODO Auto-generated method stub
		NumArgumentos ++;
	}

	@Override
	public void visitar(ExpressaoLet exp) {
		// TODO Auto-generated method stub
		NumArgumentos ++;
		exp.getAtrib().aceitar(this);
		exp.getExpressao().aceitar(this);
	}

	public int getNumArgumentos() {
		return NumArgumentos;
	}

	public void setNumArgumentos(int numArgumentos) {
		NumArgumentos = numArgumentos;
	}

	@Override
	public void visitar(ListaVazia<?> exp) {
		// TODO Auto-generated method stub
		NumArgumentos++;
	}

	@Override
	public void visitar(ListaNaoVazia<?> exp) {
			// TODO Auto-generated method stub
			NumArgumentos++;
			exp.getInicio().aceitar(this);
		int tamanho = ((ValorInteiro)exp.tamanho()).getValor();	
		ValorLista<?> listaAceitar = exp;	
		int i=0;
	
			while(i<tamanho){
				if(listaAceitar.getCauda().tipo() != Tipo.ListaVazia){
					listaAceitar.getCauda().getInicio().aceitar(this);
				}
				listaAceitar = listaAceitar.getCauda();
				i++;
			}
	
	}

}
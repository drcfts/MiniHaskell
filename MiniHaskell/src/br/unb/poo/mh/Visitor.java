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

/**
 * Interface com a declaracao dos metodos que 
 * "visitam" aplicando alguma operacao sobre 
 * os elementos sintaticos de uma linguagem 
 * de programacao. 
 * @author rbonifacio
 *
 */
public interface Visitor {
	
	public void visitar(ValorInteiro exp);
	public void visitar(ValorBooleano exp);
	public void visitar(ExpressaoSoma exp);
	public void visitar(ExpressaoMultiplicacao exp);
	public void visitar(ExpressaoDivisao exp);
	public void visitar(ExpressaoSubtracao exp);
	public void visitar(ExpressaoDiferente exp);
	public void visitar(ExpressaoIgual exp);
	public void visitar(ExpressaoMaior exp);
	public void visitar(ExpressaoMenor exp);
	public void visitar(ExpressaoMenorIgual exp);
	public void visitar(ExpressaoMaiorIgual exp);
	public void visitar(ExpressaoAnd exp);
	public void visitar(ExpressaoOr exp);
	public void visitar(ExpressaoNot exp);
	public void visitar(IfThenElse exp);
	public void visitar(AplicacaoFuncao exp);
	public void visitar(Identificador exp);
	public void visitar(ExpressaoLet exp);
}

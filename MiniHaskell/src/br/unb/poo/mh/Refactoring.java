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

public class Refactoring implements Visitor{

		private Expressao Exp_Refactoring;
		
	
	@Override
	public void visitar(ValorInteiro exp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ValorBooleano exp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ExpressaoSoma exp) {
		// TODO Auto-generated method stub
		setExp_Refactoring(exp);
		if(exp.getExpDireita() instanceof ValorInteiro && exp.getExpEsquerda() instanceof ValorInteiro)
		{
		int ExpDir = ((ValorInteiro)exp.getExpDireita()).getValor();
		int ExpEsq = ((ValorInteiro)exp.getExpEsquerda()).getValor();
		
			/*
			 *  6 + 0 = 6
			 *  0 + 6 = 6
			 */
			if(ExpDir == 0) {
				setExp_Refactoring(exp.getExpEsquerda());
			}
			if(ExpEsq == 0) {
				setExp_Refactoring(exp.getExpDireita());
			}
			
		}
	}

	@Override
	public void visitar(ExpressaoMultiplicacao exp) {
		// TODO Auto-generated method stub
		setExp_Refactoring(exp);
		if(exp.getExpDireita() instanceof ValorInteiro && exp.getExpEsquerda() instanceof ValorInteiro)
		{
		int ExpDir = ((ValorInteiro)exp.getExpDireita()).getValor();
		int ExpEsq = ((ValorInteiro)exp.getExpEsquerda()).getValor();
		
			/*
			 *  6 * 0 = 0
			 *  6 * 1  = 6
			 *  1 * 6   = 6
			 *  0 * 6 = 0
			 */
			if(ExpDir == 1) {
				setExp_Refactoring(exp.getExpEsquerda());
			}
			if(ExpEsq == 1) {
				setExp_Refactoring(exp.getExpDireita());
			}
			if(ExpDir == 0) {
				setExp_Refactoring(new ValorInteiro(0));
			}
			if(ExpEsq == 0) {
				setExp_Refactoring(new ValorInteiro(0));
			}
						
		}	
		
	}

	@Override
	public void visitar(ExpressaoDivisao exp) {
		// TODO Auto-generated method stub
		setExp_Refactoring(exp);
		if(exp.getExpDireita() instanceof ValorInteiro && exp.getExpEsquerda() instanceof ValorInteiro)
		{
		int ExpDir = ((ValorInteiro)exp.getExpDireita()).getValor();
		
			/*
			 *  6 / 1  = 6
			 *  
			 * 
			 */
			if(ExpDir == 1) {
				setExp_Refactoring(exp.getExpEsquerda());
			}
			
						
		}	
			
		
		
	}

	@Override
	public void visitar(ExpressaoSubtracao exp) {
		// TODO Auto-generated method stub
	
		setExp_Refactoring(exp);
		if(exp.getExpDireita() instanceof ValorInteiro && exp.getExpEsquerda() instanceof ValorInteiro)
		{
		int ExpDir = ((ValorInteiro)exp.getExpDireita()).getValor();
		
			/*
			 *  6 - 0 = 6
			 *  
			 */
			if(ExpDir == 0) {
				setExp_Refactoring(exp.getExpEsquerda());
							}
			
		}
	
		
	}

	@Override
	public void visitar(ExpressaoDiferente exp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ExpressaoIgual exp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ExpressaoMaior exp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ExpressaoMenor exp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ExpressaoMenorIgual exp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ExpressaoMaiorIgual exp) {
		// TODO Auto-generated method stub
		
	}

	
	
	/*
	 * Expressoes boolenas 
	 * usar DeMorgan
	 * NOT ESQ AND NOT DIR = NOT(ESQ OR DIR)
	 * NOT ESQ OR  NOT DIR = NOT (ESQ AND DIR)
	 * (non-Javadoc)
	 * @see br.unb.poo.mh.Visitor#visitar(br.unb.poo.mh.expressoes.logicas.ExpressaoAnd)
	 */
	
	
	@Override
	public void visitar(ExpressaoAnd exp) {
		// TODO Auto-generated method stub
		setExp_Refactoring(exp);
		if(exp.getExpDireita() instanceof ValorBooleano && exp.getExpEsquerda() instanceof ValorBooleano)
		{
		boolean ExpDir = ((ValorBooleano)exp.getExpDireita()).getValor();
		boolean ExpEsq = ((ValorBooleano)exp.getExpEsquerda()).getValor();
		
			/*
			 *  
			 *  !X and !Y  = !(X or Y)
			 *  
			 */
			if(!ExpDir && !ExpEsq) {
			ValorBooleano BoolAux = (ValorBooleano) (new ExpressaoOr(exp.getExpDireita(),exp.getExpDireita())).avaliar();
			setExp_Refactoring(new ExpressaoNot(BoolAux));
			
			}
		
			
		}
	
	}

	@Override
	public void visitar(ExpressaoOr exp) {
		// TODO Auto-generated method stub
		
		setExp_Refactoring(exp);
		if(exp.getExpDireita() instanceof ValorBooleano && exp.getExpEsquerda() instanceof ValorBooleano)
		{
		boolean ExpDir = ((ValorBooleano)exp.getExpDireita()).getValor();
		boolean ExpEsq = ((ValorBooleano)exp.getExpEsquerda()).getValor();
		
			/*
			 *  
			 *  !X or !Y  = !(X and Y)
			 *  
			 */
			if(!ExpDir && !ExpEsq) {
			ValorBooleano BoolAux = (ValorBooleano) (new ExpressaoAnd(exp.getExpDireita(),exp.getExpDireita())).avaliar();
			setExp_Refactoring(new ExpressaoNot(BoolAux));
			
			}
		
			
		}
	
	
	
	
	}

	@Override
	public void visitar(ExpressaoNot exp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(IfThenElse exp) {
		// TODO Auto-generated method stub
		setExp_Refactoring(exp);
	if(exp.getClausulaElse() instanceof ValorBooleano && exp.getClausulaThen() instanceof ValorBooleano)	
	{
		boolean C_then = ((ValorBooleano)exp.getClausulaThen()).getValor();
		boolean C_else = ((ValorBooleano)exp.getClausulaThen()).getValor();
		
		/*
		 * if (condição)	return true;
		 
		 * else				return false;
		 * 
		 * entao se clausula then for verdadeiro e c_else false  podemos simplificar para 
		 * Exp_Refactoring = (condicao).
		 */
		if(C_then && !C_else ){
			setExp_Refactoring(exp.getCondicao());
			
		}
		
		
	}	
		
	}

	@Override
	public void visitar(AplicacaoFuncao exp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Identificador exp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ExpressaoLet exp) {
		// TODO Auto-generated method stub
		
	}

	public Expressao getExp_Refactoring() {
		return Exp_Refactoring;
	}

	public void setExp_Refactoring(Expressao exp_Refactoring) {
		Exp_Refactoring = exp_Refactoring;

	
	}

	@Override
	public void visitar(ListaVazia<?> exp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ListaNaoVazia<?> exp) {
		// TODO Auto-generated method stub
		
	}

}

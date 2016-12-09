package br.unb.poo.mh.parser;

import br.unb.poo.mh.expressoes.matematicas.*;
import br.unb.poo.mh.expressoes.logicas.*;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.Valor;
import br.unb.poo.mh.ValorParametrizado;

import java.util.List;
import java.util.Stack;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.Tipo;


/**
 * Intepreter de operacoes basicas (expressoes matematicas e logicas);
 * Consegue intepretar expressoes aninhadas
 * @author drcfts
 *
 */
public class Intepreter {
	private boolean segundaExpressao = false;
	private Token tokenArmazenado;
	
	//Transforma uma string no token correspondente
	//sera chamado pelo metodo de traducao
	private Token operador(String exp){
		switch(exp){
			case "and": return Token.AND;
			case "not": return Token.NOT;
			case "or": return Token.OR;
			case "+": return Token.SOMA;
			case "-": return Token.SUBTRACAO;
			case "/": return Token.DIVISAO;
			case "*": return Token.MULTIPLICACAO;
			case "let": return Token.LET;
			case "if": return Token.IFTELSE;
			default: 
				//se n for nenhum dos acima, sera testado se
				//eh int ou boolean; caso n seja nenhum dos 2,
				//retorna-se um tipo string
				try{
					Integer.parseInt(exp);
					return Token.NUMERO;
				}
				catch(Exception i){
					try{
						Boolean.parseBoolean(exp);
						return Token.BOOL;
					}
					catch(Exception b){
						return Token.STRING;
					}
				}
		} //end case
	} //end method
	
	//metodo pra chamar expressoes por meio dos tokens;
	//sera chamado pelo metodo de traducao
	private Expressao avalia(Expressao e1, Expressao e2, Token t){
		switch(t){
			case SOMA: return new ExpressaoSoma(e1, e2); 
			case SUBTRACAO: return new ExpressaoSubtracao(e1, e2);
			case MULTIPLICACAO: return new ExpressaoMultiplicacao(e1, e2);
			case DIVISAO: return new ExpressaoDivisao(e1, e2);
			case NOT: return new ExpressaoNot(e1);
			case AND: return new ExpressaoAnd(e1, e2);
			case OR: return new ExpressaoOr(e1, e2);
			//caso nao seja nenhum dos operadores acima,
			//retorna erro
			default: throw new RuntimeException();
		}
	} //end method
	
	private boolean ehLogica(Token t){
		return (t == Token.AND || t == Token.OR || t == Token.NOT);
	}
	
	private boolean ehMatematica(Token t){
		return (t == Token.SOMA || t == Token.MULTIPLICACAO || 
				t == Token.DIVISAO || t == Token.SUBTRACAO);
	}
	
	//retorna, em string, a avaliacao da string passada
	public String traducao(String expressaoString){
		Stack<Expressao> stack = new Stack<Expressao>();
		Parser p = new Parser();
		
		List<String> expressoes = p.parse(expressaoString);
			//permite colocar expressoes aninhadas
			for(String elemento : expressoes){
				Token t = operador(elemento);
				
				//armazena expressao na pilha
				if(t == Token.NUMERO){
					stack.push(new ValorInteiro(Integer.parseInt(elemento)));
					System.out.println(Integer.parseInt(elemento));
				}
				
				if(t == Token.BOOL){
					stack.push(new ValorBooleano(Boolean.parseBoolean(elemento)));
				}
				
				//armazena operador na pilha
				if(!segundaExpressao && (ehMatematica(t) || ehLogica(t))){
					tokenArmazenado = t;
					//possui segunda expressao a ser avaliada
					segundaExpressao = true;
				}
				
				else if(segundaExpressao){
					Expressao e1 = stack.pop();
					Expressao e2;
					Expressao resultado;
						//not n tem segunda expressao pra fazer pop
						if(tokenArmazenado != Token.NOT){
							e2 = stack.pop();
							resultado = avalia(e2, e1, tokenArmazenado);
						} else{
							e2 = null;
							resultado = avalia(e1, e2, tokenArmazenado);
						}
						
						
						stack.push(resultado);
						segundaExpressao = false;
				} //end else
			} //end for
			segundaExpressao = false;
			
			if(stack.peek().tipo() == Tipo.Booleano){
				Boolean bool = ((ValorParametrizado<Boolean>)stack.pop().avaliar()).getValor();
				return bool.toString();
			} 
			else if(stack.peek().tipo() == Tipo.Inteiro){
				Integer inteiro = ((ValorParametrizado<Integer>)stack.pop().avaliar()).getValor();
				return inteiro.toString();
			}
			else{
				return "Erro de tipagem!";
			}
	}
}

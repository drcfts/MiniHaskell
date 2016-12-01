package br.unb.poo.mh.funcao;

import br.unb.poo.mh.Tipo;

/**
  * Para poder fazer a verificação de tipos,
  * os argumentos formais precisam ter, alem do nome,
  * o respectivo tipo.
  * Isso substituira a string na classe 
  * DeclaracaoFuncao
 * @author drcfts
 *
 */
public class ArgumentoFormal {
	private Tipo tipo;
	private String id;
	
	public ArgumentoFormal(Tipo tipo, String id){
		this.tipo = tipo;
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public String getId() {
		return id;
	}

	
}

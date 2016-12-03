package br.unb.poo.mh;

public class IfThenElse implements Expressao {
	private Expressao condicao;
	private Expressao clausulaThen;
	private Expressao clausulaElse;
	
	public IfThenElse(Expressao condicao, Expressao clausulaThen, Expressao clausulaElse) {
		this.setCondicao(condicao);
		this.setClausulaThen(clausulaThen);
		this.setClausulaElse(clausulaElse);
	} 
	
	public Valor avaliar() {
		ValorBooleano valor = (ValorBooleano)getCondicao().avaliar();
		if(valor.getValor()) {
			return getClausulaThen().avaliar();
		}
		return 			getClausulaElse().avaliar();
	}

	/*Se repararmos no avaliar notamos que a condicao deve ser um valor booleano
	 * 
	 * e que as clausulas devem ser do mesmo tipo
	 * se forem -> retorna o proprio tipo 
	 *  caso nao satisfa�a nada
	 *  return error
	 */
	
	
	@Override
	public Tipo tipo() {
		Tipo tipoCondi_If_else = getCondicao().tipo();
			if(tipoCondi_If_else.equals(Tipo.Booleano))
			{
				if(getClausulaThen().tipo().equals(getClausulaElse().tipo()))
				{
					return getClausulaElse().tipo();
				}
			}
		

		return Tipo.Error;
	}

	/*
	 * Se nao for do tipo "Error" entao est� certo
	 * 
	 */
	@Override
	public boolean checarTipo() {
		// TODO Auto-generated method stub
		return (!tipo().equals(Tipo.Error));
	}

	@Override
	public void aceitar(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitar(this);
	}

	public Expressao getCondicao() {
		return condicao;
	}

	public void setCondicao(Expressao condicao) {
		this.condicao = condicao;
	}

	public Expressao getClausulaThen() {
		return clausulaThen;
	}

	public void setClausulaThen(Expressao clausulaThen) {
		this.clausulaThen = clausulaThen;
	}

	public Expressao getClausulaElse() {
		return clausulaElse;
	}

	public void setClausulaElse(Expressao clausulaElse) {
		this.clausulaElse = clausulaElse;
	}
}

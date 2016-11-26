package br.unb.poo.mh;

public class IfThenElse implements Expressao {
	private Expressao condicao;
	private Expressao clausulaThen;
	private Expressao clausulaElse;
	
	public IfThenElse(Expressao condicao, Expressao clausulaThen, Expressao clausulaElse) {
		this.condicao = condicao;
		this.clausulaThen = clausulaThen;
		this.clausulaElse = clausulaElse;
	} 
	
	public Valor avaliar() {
		ValorBooleano valor = (ValorBooleano)condicao.avaliar();
		if(valor.getValor()) {
			return clausulaThen.avaliar();
		}
		return 			clausulaElse.avaliar();
	}

	/*Se repararmos no avaliar notamos que a condicao deve ser um valor booleano
	 * 
	 * e que as clausulas devem ser do mesmo tipo
	 * se forem -> retorna o proprio tipo 
	 *  caso nao satisfaça nada
	 *  return error
	 */
	
	
	@Override
	public Tipo tipo() {
		// TODO Auto-generated method stub
		Tipo tipoCondi_If_else = condicao.tipo();
			if(tipoCondi_If_else.equals(Tipo.Booleano))
			{
				if(clausulaThen.tipo().equals(clausulaElse))
				{
					return clausulaElse.tipo();
				}
			}
		
		
		return Tipo.Error;
	}

	/*
	 * Se nao for do tipo "Error" entao está certo
	 * 
	 */
	@Override
	public boolean checarTipo() {
		// TODO Auto-generated method stub
		return (!tipo().equals(Tipo.Error));
	}
}

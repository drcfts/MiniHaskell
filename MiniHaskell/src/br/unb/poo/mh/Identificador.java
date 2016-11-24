package br.unb.poo.mh;

public class Identificador implements Expressao {
	private String id;

	public Identificador(String id) {
		this.id = id;
	}
	
	public Valor avaliar() {
		Expressao exp = Ambiente.instance().getExpressao(id);
		return exp.avaliar();
	}
}

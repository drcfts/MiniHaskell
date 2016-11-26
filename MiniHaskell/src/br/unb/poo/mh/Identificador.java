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

	@Override
	public Tipo tipo() {
		Expressao exp = Ambiente.instance().getExpressao(id);
		return exp.tipo();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean checarTipo() {
		// TODO Auto-generated method stub
		return true;
	}
}

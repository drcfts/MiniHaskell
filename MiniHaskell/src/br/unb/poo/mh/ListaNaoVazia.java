package br.unb.poo.mh;

public class ListaNaoVazia<T extends Valor> extends ValorLista<T> {

	public ListaNaoVazia(T inicio) {
		super(inicio);
		ListaVazia<T> Resto = new ListaVazia<T>(); 
		Resto.setAnterior(this);
		this.setResto(Resto);
		this.setAnterior(null);
	}
	

	@Override
	public Valor avaliar() {
		ListaNaoVazia<T> vA = this;
		Valor Resultado = vA.avaliar();
		return Resultado;
	}

	@Override
	public Tipo tipo() {
		// TODO Auto-generated method stub
		return Tipo.ListaNaoVazia;
	}

	@Override
	public boolean checarTipo() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void aceitar(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitar(this);
	}

	


}

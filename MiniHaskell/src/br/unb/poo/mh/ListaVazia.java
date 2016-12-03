package br.unb.poo.mh;

public class ListaVazia<T extends Valor> extends ValorLista<T> {

	public ListaVazia() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Valor avaliar() {
	
		return null;
	}

	@Override
	public Tipo tipo() {
		
		// TODO Auto-generated method stub
		return Tipo.ListaVazia;
	}

	@Override
	public boolean checarTipo() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
	
}

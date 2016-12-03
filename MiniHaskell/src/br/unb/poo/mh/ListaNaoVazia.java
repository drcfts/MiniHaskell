package br.unb.poo.mh;

public class ListaNaoVazia<T extends Valor> extends ValorLista<T> {

	

	public ListaNaoVazia(T head) {
		super(head);
		ListaVazia<T> tail = new ListaVazia<T>();
		tail.setAnterior(this);
		this.setTail(tail);
		this.setAnterior(null);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Valor avaliar() {
		// TODO Auto-generated method stub
		return  this;
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

}

package br.unb.poo.mh;

public class ListaVazia<T extends Valor> extends ValorLista<T> {

	public ListaVazia() {
		super(null);
	
	}

	@Override
	public Valor avaliar() {
		// TODO Auto-generated method stub
			ListaVazia<T> vA = this;
			Valor Resultado = vA.getInicio().avaliar();
			return Resultado;
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

	@Override
	public void aceitar(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitar(this);
	}
		
}

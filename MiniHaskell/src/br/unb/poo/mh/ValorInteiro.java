package br.unb.poo.mh;

public class ValorInteiro extends ValorParametrizado<Integer> {

	public ValorInteiro(Integer valor) {
		super(valor);
	}

	@Override
	public Tipo tipo() {
		return Tipo.Inteiro;
	}
}

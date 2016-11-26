package br.unb.poo.mh.expressoes.logicas;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ExpressaoUnaria;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.Valor;
import br.unb.poo.mh.ValorBooleano;

public class ExpressaoNot extends  ExpressaoUnaria {

	public ExpressaoNot(Expressao exp) {
		super(exp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Valor avaliar() {
		ValorBooleano valorExp = (ValorBooleano)uni.avaliar();
		
		// TODO Auto-generated method stub
		return new ValorBooleano(!valorExp.getValor());
	}

	@Override
	public Tipo tipo() {
		
		Tipo tipoExp = uni.tipo();
		if(tipoExp.equals(Tipo.Booleano))
			return Tipo.Booleano;
		
		return Tipo.Error;
		
		// TODO Auto-generated method stub
	
	}

	@Override
	public boolean checarTipo() {
		// TODO Auto-generated method stub
		return tipo().equals(Tipo.Booleano);
	}
	
	
	
}

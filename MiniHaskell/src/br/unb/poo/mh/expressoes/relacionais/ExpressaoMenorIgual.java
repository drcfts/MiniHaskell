package br.unb.poo.mh.expressoes.relacionais;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ExpressaoBinaria;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.Valor;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.Visitor;

public class ExpressaoMenorIgual extends ExpressaoBinaria {

	public ExpressaoMenorIgual(Expressao expEsquerda, Expressao expDireita) {
		super(expEsquerda, expDireita);
		// TODO Auto-generated constructor stub
	}

	@Override

	public Tipo tipo() {
		Tipo tipoExpDir = expDireita.tipo();
		Tipo tipoExpEsq = expEsquerda.tipo();
	
		if(tipoExpDir.equals(Tipo.Inteiro) && tipoExpEsq.equals(Tipo.Inteiro)){
			return Tipo.Booleano;	
	}
		return Tipo.Error;
		
		// TODO Auto-generated method stub
	}
	
	
@Override

	public Valor avaliar(){
		
	 	ValorInteiro expD_int = (ValorInteiro)expDireita.avaliar();
	 	ValorInteiro expE_int = (ValorInteiro)expEsquerda.avaliar();
	 	
	return new ValorBooleano(expE_int.getValor() <= expD_int.getValor());
	
 }

public boolean checarTipo() {
	return tipo().equals(Tipo.Booleano);
}

@Override
public void aceitar(Visitor visitor) {
	// TODO Auto-generated method stub
	visitor.visitar(this);
}		

}

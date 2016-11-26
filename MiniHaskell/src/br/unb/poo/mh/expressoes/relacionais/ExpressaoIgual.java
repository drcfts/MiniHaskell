package br.unb.poo.mh.expressoes.relacionais;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ExpressaoBinaria;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.Valor;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;




public class ExpressaoIgual extends ExpressaoBinaria {

	public ExpressaoIgual(Expressao expDireita, Expressao expEsquerda) {
		super(expDireita, expEsquerda);
		// TODO Auto-generated constructor stub
	}

	@Override

	public Tipo tipo() {
		Tipo tipoExpDir = expDireita.tipo();
		Tipo tipoExpEsq = expEsquerda.tipo();
	
		if(tipoExpDir.equals(Tipo.Booleano) && tipoExpEsq.equals(Tipo.Booleano)){
				return Tipo.Booleano;	
		}
		else if(tipoExpDir.equals(Tipo.Inteiro) && tipoExpEsq.equals(Tipo.Inteiro)){
			return Tipo.Inteiro;	
	}
		return Tipo.Error;
		
		// TODO Auto-generated method stub
	}
	
	
@Override

	public Valor avaliar(){
		
	if(tipo().equals(Tipo.Inteiro)){	
	 	ValorInteiro expD_int = (ValorInteiro)expDireita.avaliar();
	 	ValorInteiro expE_int = (ValorInteiro)expEsquerda.avaliar();
	 	
	return new ValorBooleano(expD_int.getValor() == expE_int.getValor());
	} 
	
	if(tipo().equals(Tipo.Booleano)){	
	 	ValorBooleano expD = (ValorBooleano)expDireita.avaliar();
	 	ValorBooleano expE = (ValorBooleano)expEsquerda.avaliar();
	 	
	return new ValorBooleano(expD.getValor() == expE.getValor());
	}
	/*
	 * Caso que o tipo não é inteiro nem bool ? O que fazer ? NULL? SERÁ?!?!??
	 */
	return null; 
	
 }
@Override
public boolean checarTipo() {
	// TODO Auto-generated method stub
	return (tipo().equals(Tipo.Booleano) || tipo().equals(Tipo.Inteiro));
	
}


}

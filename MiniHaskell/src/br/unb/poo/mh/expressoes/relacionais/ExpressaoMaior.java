package br.unb.poo.mh.expressoes.relacionais;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ExpressaoBinaria;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.Valor;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;




public class ExpressaoMaior extends ExpressaoBinaria {

	public ExpressaoMaior(Expressao expEsquerda, Expressao expDireita) {
		super(expEsquerda, expDireita);
	}

	@Override

	public Tipo tipo() {
		Tipo tipoExpDir = expDireita.tipo();
		Tipo tipoExpEsq = expEsquerda.tipo();
	
		if(tipoExpDir.equals(Tipo.Inteiro) && tipoExpEsq.equals(Tipo.Inteiro)){
			return Tipo.Booleano;	
	}
		return Tipo.Error;
		
	}
	
	
	@Override
	public Valor avaliar(){
		
	 	ValorInteiro expD_int = (ValorInteiro)expDireita.avaliar();
	 	ValorInteiro expE_int = (ValorInteiro)expEsquerda.avaliar();
	 	
	 	return new ValorBooleano(expE_int.getValor() > expD_int.getValor());
	
 }

@Override
public boolean checarTipo() {
	return tipo().equals(Tipo.Booleano);
	
}



}

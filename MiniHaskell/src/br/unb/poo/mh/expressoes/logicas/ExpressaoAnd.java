package br.unb.poo.mh.expressoes.logicas;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ExpressaoBinaria;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.Valor;
import br.unb.poo.mh.ValorBooleano;




public class ExpressaoAnd extends ExpressaoBinaria {

	public ExpressaoAnd(Expressao expDireita, Expressao expEsquerda) {
		super(expDireita, expEsquerda);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Valor avaliar(){
	 	ValorBooleano expD = (ValorBooleano)expDireita.avaliar();
	 	ValorBooleano expE = (ValorBooleano)expEsquerda.avaliar();
	 	
	return new ValorBooleano(expD.getValor() && expE.getValor());
	 
 }
		
	
	
	@Override
	public Tipo tipo() {
		Tipo tipoExpDir = expDireita.tipo();
		Tipo tipoExpEsq = expEsquerda.tipo();
	
		if(tipoExpDir.equals(Tipo.Booleano) && tipoExpEsq.equals(Tipo.Booleano)){
				return Tipo.Booleano;	
		}
		return Tipo.Error;
			
		// TODO Auto-generated method stub
	}

	@Override
	public boolean checarTipo() {
		// TODO Auto-generated method stub
		return tipo().equals(Tipo.Booleano);
	}
	
}

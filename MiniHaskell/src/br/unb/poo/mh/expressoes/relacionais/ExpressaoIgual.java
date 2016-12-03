package br.unb.poo.mh.expressoes.relacionais;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ExpressaoBinaria;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.Valor;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.Visitor;




public class ExpressaoIgual extends ExpressaoBinaria {

	public ExpressaoIgual(Expressao expDireita, Expressao expEsquerda) {
		super(expDireita, expEsquerda);
		// TODO Auto-generated constructor stub
	}

	@Override

	public Tipo tipo() {
		Tipo tipoExpDir = expDireita.tipo();
		Tipo tipoExpEsq = expEsquerda.tipo();
	
		if((tipoExpDir.equals(Tipo.Booleano) && tipoExpEsq.equals(Tipo.Booleano)) || (tipoExpDir.equals(Tipo.Inteiro) && tipoExpEsq.equals(Tipo.Inteiro))){
				return Tipo.Booleano;	
		}
		else{
		return Tipo.Error;
		}
		// TODO Auto-generated method stub
	}
	
	
	@Override
	public Valor avaliar(){
	
	if(tipo().equals(Tipo.Booleano)){	
	 	if(expEsquerda.tipo().equals(Tipo.Inteiro)){
	 		ValorInteiro expD = (ValorInteiro)expDireita.avaliar();
	 		ValorInteiro expE = (ValorInteiro)expEsquerda.avaliar();
	 		return new ValorBooleano(expD.getValor() == expE.getValor());
	 	}
	 	else{
	 		ValorBooleano expD_int = (ValorBooleano)expDireita.avaliar();
	 		ValorBooleano expE_int = (ValorBooleano)expEsquerda.avaliar();
		 	
		return new ValorBooleano(expD_int.getValor() == expE_int.getValor());
	 	}
	}
	
	return new ValorBooleano(false); 
	
 }
	
@Override
public boolean checarTipo() {
	return (tipo().equals(Tipo.Booleano));
	
}
@Override
public void aceitar(Visitor visitor) {
	// TODO Auto-generated method stub
	visitor.visitar(this);
}		

}

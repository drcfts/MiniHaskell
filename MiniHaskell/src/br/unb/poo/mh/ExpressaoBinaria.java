package br.unb.poo.mh;

public abstract class ExpressaoBinaria implements Expressao {
	protected Expressao expDireita;
	protected Expressao expEsquerda; 
	
	public ExpressaoBinaria(Expressao expDireita, Expressao expEsquerda) {
		this.expDireita = expDireita;
		this.expEsquerda = expEsquerda;
	}

	public Expressao getExpDireita() {
		return expDireita;
	}

	public void setExpDireita(Expressao expDireita) {
		this.expDireita = expDireita;
	}

	public Expressao getExpEsquerda() {
		return expEsquerda;
	}

	public void setExpEsquerda(Expressao expEsquerda) {
		this.expEsquerda = expEsquerda;
	}
	
	
}

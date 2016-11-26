package br.unb.poo.mh;

public abstract class ExpressaoUnaria implements Expressao {
	protected Expressao uni;
	public ExpressaoUnaria(Expressao exp){
		this.uni=exp;
			}
	public Expressao getUni() {
		return uni;
	}
	public void setUni(Expressao uni) {
		this.uni = uni;
	}

	
}

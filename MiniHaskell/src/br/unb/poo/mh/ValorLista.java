package br.unb.poo.mh;

public abstract class ValorLista<T extends Expressao> implements Expressao{
		private T inicio ;
		private ValorLista <T>  resto;
		private ValorLista <T>  anterior;
		
		
		
		public ValorLista(T head) {
			// TODO Auto-generated constructor stub
		this.setInicio(head);
		this.setResto(null);
		this.setAnterior(null);
		}
		public int tamanho(){
			int i=0;
			ValorLista<?> aux = this;
			while(!(aux instanceof ListaVazia<?>)){
				i++;
				aux.getResto();
			}
			return i;
						
		}
		
		
		
		public T getInicio() {
			return inicio;
		}
		public void setInicio(T inicio) {
			this.inicio = inicio;
		}
		public ValorLista <T> getResto() {
			return resto;
		}
		public void setResto(ValorLista <T> resto) {
			this.resto = resto;
		}
		public ValorLista <T> getAnterior() {
			return anterior;
		}
		public void setAnterior(ValorLista <T> anterior) {
			this.anterior = anterior;
		}

		public ValorLista<?> inserirInicio(T novoValor){
		ValorLista<T> ListaRetornoAux = new ListaNaoVazia((Valor) novoValor);
		if(this.getAnterior() != null){
			this.getAnterior().setResto(ListaRetornoAux);
			
		}
		ListaRetornoAux.setResto(this);
		ListaRetornoAux.setAnterior(this.getAnterior());
		this.setAnterior(ListaRetornoAux);
		return ListaRetornoAux;
		
		
	}	
		public ValorLista<T> remover(){
			if(this.tipo() == Tipo.ListaNaoVazia){
				if(this.getAnterior()!= null){
					this.getAnterior().setResto(this.getResto());
				}
			this.getResto().setAnterior(this.getAnterior());		
				return this.getResto();	
		}
			
			return this;
		}
		
		
		
}

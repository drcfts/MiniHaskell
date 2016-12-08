package br.unb.poo.mh;

public abstract class ValorLista<T extends Valor> extends Valor{
		private T inicio ;
		private ValorLista <T>  cauda;
		private ValorLista <T>  anterior;
		
		
		
		public ValorLista(T head) {
			// TODO Auto-generated constructor stub
			this.inicio = head;
			this.cauda = null;
			this.anterior = null;
						
		}
		

		public T getInicio() {
			return inicio;
		}


		public void setInicio(T inicio) {
			this.inicio = inicio;
		}


		public ValorLista<T> getCauda() {
			return cauda;
		}


		public void setCauda(ValorLista<T> cauda) {
			this.cauda = cauda;
		}


		public ValorLista<T> getAnterior() {
			return anterior;
		}


		public void setAnterior(ValorLista<T> anterior) {
			this.anterior = anterior;
		}


		public ValorLista<T> inserir(T novoValor){
			ValorLista<T> ListaRetornoAux = new ListaNaoVazia<T>(novoValor);
			
			if(this.getAnterior() != null){
				this.getAnterior().setCauda(ListaRetornoAux);
			}
			
			ListaRetornoAux.setCauda(this);
			ListaRetornoAux.setAnterior(this.getAnterior());
			this.setAnterior(ListaRetornoAux);
			
			return ListaRetornoAux;
		
		
	}	
		public ValorLista<T> remover(){
			if(this.tipo() == Tipo.ListaNaoVazia){
				if(this.getAnterior()!= null){
					this.getAnterior().setCauda(this.getCauda());
				}
			this.getCauda().setAnterior(this.getAnterior());		
				return this.getCauda();	
		}
			
			return this;
		}
		
		public ValorInteiro tamanho(){
			int tamanho = 0;
			ValorLista<?> auxiliar = this;
			
			if(!(auxiliar instanceof ListaNaoVazia<?>)){
				tamanho++;
				auxiliar = auxiliar.getCauda();
			}
			
			return new ValorInteiro(tamanho);
		}
		
		
		
}

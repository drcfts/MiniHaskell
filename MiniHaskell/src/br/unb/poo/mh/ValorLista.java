package br.unb.poo.mh;

public abstract class ValorLista<T extends Valor> implements Expressao{
		private Valor head;
		private ValorLista <T>  tail;
		private ValorLista <T>  anterior;
		
		public ValorLista(T head){
			this.head = (Valor) head;
			this.tail = null;
			this.setAnterior(null);
			
		}
		
		
		
		
		public ValorLista <T> getTail() {
			return tail;
		}
		public void setTail(ValorLista <T> tail) {
			this.tail = tail;
		}
		public Valor getHead() {
			return head;
		}
		public void setHead(Valor head) {
			this.head = head;
		}
	

		public ValorLista <T> getAnterior() {
			return anterior;
		}




		public void setAnterior(ValorLista <T> anterior) {
			this.anterior = anterior;
		}

		public ValorLista<T> InserirLista(T valor){
				ValorLista<T> novaLista = new ListaNaoVazia<T>(valor);
			
					if(this.getAnterior()!=null){
						this.getAnterior().setTail(novaLista);
					}
					//-- a cauda da nova lista será a antiga lista
					novaLista.setTail(this);
					
					novaLista.setAnterior(this.getAnterior());
					//-- a anterior vai ser lista usado pra facilitar a manipulação
					this.setAnterior(novaLista);
					
					return novaLista;
					
			
		}

		public ValorInteiro tamanho (){
			int i=0;
			ValorLista<?> Listaaux = this;
				while(!(Listaaux instanceof ListaVazia<?>)){
					i++;
					Listaaux = ((ListaNaoVazia<?>)Listaaux).getTail();
				}
			
			return new ValorInteiro(i);
			
			
		}





}

package br.unb.poo.mh;

import java.util.ArrayList;
import java.util.List;



/**
 * @author drcfts
 *
 *	Implementacao da expressao Let ... in para utilizacao em MiniHaskell
 */
public class ExpressaoLet implements Expressao{
		
		private String id;
		private Expressao atrib;
		private Expressao expressao;
		
		public ExpressaoLet(String id, Expressao atrib, Expressao expressao){
			
			this.id = id;
			this.atrib = atrib;
			this.expressao = expressao;
			
		}
		
		@Override
		public Valor avaliar() {
			Ambiente.instance().associaExpressao(id, atrib);
			
			return expressao.avaliar();
		}
		
		@Override
		public Tipo tipo() {
			return expressao.tipo();
		}

		public String getId() {
			return id;
		}

		public Expressao getAtrib() {
			return atrib;
		}

		public Expressao getExpressao() {
			return expressao;
		}

		/*
		 * Se nao for do tipo "Error" entao está certo
		 * 
		 */
		@Override
		public boolean checarTipo() {
			// TODO Auto-generated method stub
			return (!tipo().equals(Tipo.Error));
		}		
}

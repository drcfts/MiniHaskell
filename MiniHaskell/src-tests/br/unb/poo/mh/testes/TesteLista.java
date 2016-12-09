package br.unb.poo.mh.testes;
import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.ListaVazia;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.Valor;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import br.unb.poo.mh.ValorLista;
import br.unb.poo.mh.ValorParametrizado;



public class TesteLista {
	private ValorInteiro Int_1;
	private ValorInteiro Int_2;
	private ValorInteiro Int_3;
	private ValorBooleano bool_true;
	private ValorBooleano bool_false;
	private ValorInteiro Indice_1;
	private ValorInteiro Indice_0;

	
	
	// testando a lista em si
	@Test
	public void testeListaInteira(){
		ValorLista<ValorInteiro> listaTestadaInteiro = new ListaVazia<ValorInteiro>();
		ValorLista<ValorBooleano> listaTestadaBool = new ListaVazia<ValorBooleano>();
		
		// testando lista Vazia
			Assert.assertNull(listaTestadaInteiro.getAnterior());
			Assert.assertNull(listaTestadaInteiro.getCauda());
			Assert.assertNull(listaTestadaInteiro.getInicio());
			 Assert.assertEquals(new Integer(0), listaTestadaBool.tamanho().getValor());
				
	   Int_1 = new ValorInteiro(2);
	   Int_2 = new ValorInteiro(9);
	   Int_3 = new ValorInteiro(7);
	   Indice_0 = new ValorInteiro(0);
	   Indice_1 = new ValorInteiro(1);
	   
	 bool_true = new ValorBooleano(true);
	 bool_false = new ValorBooleano(false);
	/////////////////////////// Primeira Inserção 
	/*
	 * Inteiros
	 * Lista com apenas um elemento
	 * inicio - terá o valor 
	 * o resto será null
	 * neste caso testar inserir tbm
	 */
	listaTestadaInteiro = listaTestadaInteiro.inserir(Int_1);
	 Assert.assertEquals(new Integer(2), listaTestadaInteiro.getInicio().getValor());
	 Assert.assertNull(listaTestadaInteiro.getCauda().getInicio());
	 Assert.assertEquals(new Integer(1), listaTestadaInteiro.tamanho().getValor());
	 /*
		 * Bool
		 * Lista com apenas um elemento
		 * inicio - terá o valor 
		 * o resto será null
		 * neste caso testar inserir tbm
		 */
		
	 
	 listaTestadaBool = listaTestadaBool.inserir(bool_true);
	 Assert.assertEquals(true, listaTestadaBool.getInicio().getValor());
	 Assert.assertNull(listaTestadaBool.getCauda().getInicio());
	 Assert.assertEquals(new Integer(1), listaTestadaBool.tamanho().getValor());
	////////////////////////////////////////////// Segunda Inserção
	 /*
		 * Inteiros
		 * Lista com apenas um elemento
		 * inicio - terá o valor 
		 * cauda -> terá o valor anterior
		 * o resto será null
		 */
		listaTestadaInteiro = listaTestadaInteiro.inserir(Int_2);
		 Assert.assertEquals(new Integer(9), listaTestadaInteiro.getInicio().getValor());
		 Assert.assertEquals(new Integer(2), listaTestadaInteiro.getCauda().getInicio().getValor());
		 Assert.assertNull(listaTestadaInteiro.getCauda().getCauda().getInicio());
		 Assert.assertEquals(new Integer(2), listaTestadaInteiro.tamanho().getValor());
		 /*
			 * Bool
			 * Lista com apenas um elemento
			 * inicio - terá o valor 
			 *  cauda -> terá o valor anterior
			 * o resto será null
			 * neste caso testar inserir tbm
			 */
			
		 
		 listaTestadaBool = listaTestadaBool.inserir(bool_false);
		 Assert.assertEquals(false, listaTestadaBool.getInicio().getValor());
		 Assert.assertEquals(true, listaTestadaBool.getCauda().getInicio().getValor());	 
		 Assert.assertNull(listaTestadaBool.getCauda().getCauda().getInicio());
		 Assert.assertEquals(new Integer(2), listaTestadaBool.tamanho().getValor());
		
		 // tamanho já foi testado , inserir tb
	 
	/*
	 * testando busca por posição 
	 * 
	 */
		 Assert.assertEquals(new Integer(2),listaTestadaInteiro.buscaPosicao(Indice_0).getInicio().avaliar());
		 Assert.assertEquals(new Integer(9),listaTestadaInteiro.buscaPosicao(Indice_1).getInicio().avaliar());
		 Assert.assertEquals(null,listaTestadaInteiro.buscaPosicao(Int_1));
		 
		 
		 Assert.assertEquals(false,listaTestadaBool.buscaPosicao(Indice_0).getInicio().avaliar());
		 Assert.assertEquals(true,listaTestadaBool.buscaPosicao(Indice_1).getInicio().avaliar());
		 Assert.assertEquals(null,listaTestadaBool.buscaPosicao(Int_1));
		 
		 
		 
		 /*
		  * Testando agora remover ...........
		  * lista inteira 
		  */
	 
	 listaTestadaInteiro.getCauda().remover();
	 Assert.assertEquals(new Integer(9), listaTestadaInteiro.getInicio().getValor());
	 Assert.assertNull(listaTestadaInteiro.getCauda().getInicio());
	 Assert.assertEquals(new Integer(1), listaTestadaInteiro.tamanho().getValor());

	 /*
	  * Testando agora remover ...........
	  * lista booleano 
	  */
	 listaTestadaBool.getCauda().remover();
	 Assert.assertEquals(true, listaTestadaBool.getInicio().getValor());
	 Assert.assertNull(listaTestadaBool.getCauda().getInicio());
	 Assert.assertEquals(new Integer(1), listaTestadaBool.tamanho().getValor());
	 

		 
	 
	}
	
	
	}
	
	
	


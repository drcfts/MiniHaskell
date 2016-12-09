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
	private ValorInteiro v2;
	private ValorInteiro v9;
	private ValorInteiro v7;
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
			Assert.assertNull(listaTestadaInteiro.getAnterior().getInicio().getValor());
			Assert.assertNull(listaTestadaInteiro.getCauda().getInicio().getValor());
			Assert.assertNull(listaTestadaInteiro.getInicio().getValor());
			Assert.assertNull(listaTestadaInteiro.buscaPosicao(Indice_0));
			Assert.assertNull(listaTestadaInteiro.buscaPosicao(Indice_1));	
			Assert.assertNull(listaTestadaInteiro.remover());
			Assert.assertNull(listaTestadaInteiro.getCauda().remover());			
			Assert.assertEquals(new ValorInteiro(0).getValor(), listaTestadaBool.tamanho().getValor());
				
			 
	   v2 = new ValorInteiro(2);
	   v9 = new ValorInteiro(9);
	   v7 = new ValorInteiro(7);
	   Indice_0 = new ValorInteiro(0);
	   Indice_1 = new ValorInteiro(1);
	   
	 bool_true = new ValorBooleano(true);
	 bool_false = new ValorBooleano(false);
	/////////////////////////// Primeira Inser��o 
	/*
	 * Inteiros
	 * Lista com apenas um elemento
	 * inicio - ter� o valor 
	 * o resto ser� null
	 * neste caso testar inserir tbm
	 */
	 Assert.assertEquals(new Integer(0), listaTestadaInteiro.tamanho().getValor());
	listaTestadaInteiro = listaTestadaInteiro.inserir(v2);
	 Assert.assertEquals(new Integer(2), listaTestadaInteiro.getInicio().getValor());
	 Assert.assertNull(listaTestadaInteiro.getCauda().getInicio());
	 Assert.assertEquals(new Integer(1), listaTestadaInteiro.tamanho().getValor());
	 /*
		 * Bool
		 * Lista com apenas um elemento
		 * inicio - ter� o valor 
		 * o resto ser� null
		 * neste caso testar inserir tbm
		 */
		
	 
	 listaTestadaBool = listaTestadaBool.inserir(bool_true);
	 Assert.assertEquals(true, listaTestadaBool.getInicio().getValor());
	 Assert.assertNull(listaTestadaBool.getCauda().getInicio());
	 Assert.assertEquals(new Integer(1), listaTestadaBool.tamanho().getValor());
	////////////////////////////////////////////// Segunda Inser��o
	 /*
		 * Inteiros
		 * Lista com apenas um elemento
		 * inicio - ter� o valor 
		 * cauda -> ter� o valor anterior
		 * o resto ser� null
		 */
	 	Assert.assertEquals(new Integer(1), listaTestadaInteiro.tamanho().getValor());
		listaTestadaInteiro = listaTestadaInteiro.inserir(v7);
		 Assert.assertEquals(new Integer(7), listaTestadaInteiro.getInicio().getValor());
		 Assert.assertEquals(new Integer(2), listaTestadaInteiro.getCauda().getInicio().getValor());
		 Assert.assertNull(listaTestadaInteiro.getCauda().getCauda().getInicio());
		 Assert.assertEquals(new Integer(2), listaTestadaInteiro.tamanho().getValor());
		 
		 listaTestadaInteiro = listaTestadaInteiro.inserir(v9);
		 Assert.assertEquals(v2.getValor(), ((ValorInteiro)listaTestadaInteiro.buscaPosicao(new ValorInteiro(2)).getInicio()).getValor());
		 Assert.assertEquals(new Integer(3), listaTestadaInteiro.tamanho().getValor());
		 /*
			 * Bool
			 * Lista com apenas um elemento
			 * inicio - ter� o valor 
			 *  cauda -> ter� o valor anterior
			 * o resto ser� null
			 * neste caso testar inserir tbm
			 */
			
		 
		 listaTestadaBool = listaTestadaBool.inserir(bool_false);
		 Assert.assertEquals(false, listaTestadaBool.getInicio().getValor());
		 Assert.assertEquals(true, listaTestadaBool.getCauda().getInicio().getValor());	 
		 Assert.assertNull(listaTestadaBool.getCauda().getCauda().getInicio());
		 Assert.assertEquals(new Integer(2), listaTestadaBool.tamanho().getValor());
		
		 // tamanho j� foi testado , inserir tb
	 
	/*
	 * testando busca por posi��o 
	 * 
	 */
		 Assert.assertEquals(new Integer(9),((ValorInteiro)listaTestadaInteiro.buscaPosicao(Indice_0).getInicio()).getValor());
		 Assert.assertEquals(new Integer(7),((ValorInteiro)listaTestadaInteiro.buscaPosicao(Indice_1).getInicio()).getValor());
		 Assert.assertEquals(null,listaTestadaInteiro.buscaPosicao(new ValorInteiro(3)).getInicio());
		 
		 
		 Assert.assertEquals(false,((ValorBooleano)listaTestadaBool.buscaPosicao(Indice_0).getInicio()).getValor());
		 Assert.assertEquals(true,((ValorBooleano)listaTestadaBool.buscaPosicao(Indice_1).getInicio()).getValor());
		 Assert.assertEquals(null,listaTestadaBool.buscaPosicao(v2).getInicio());
		 
		 
		 
		 /*
		  * Testando agora remover ...........
		  * lista inteira 
		  */
	 
	 listaTestadaInteiro.buscaPosicao(v2).remover();
	 Assert.assertEquals(new Integer(7), listaTestadaInteiro.getCauda().getInicio().getValor());
	 listaTestadaInteiro.buscaPosicao(Indice_1).remover();
	 Assert.assertNull(listaTestadaInteiro.getCauda().getInicio());
	 Assert.assertEquals(new Integer(1), listaTestadaInteiro.tamanho().getValor());

	 /*
	  * Testando agora remover ...........
	  * lista booleano 
	  */
	 listaTestadaBool.getCauda().remover();
	 Assert.assertEquals(false, listaTestadaBool.getInicio().getValor());
	 Assert.assertNull(listaTestadaBool.getCauda().getInicio());
	 Assert.assertEquals(new Integer(1), listaTestadaBool.tamanho().getValor());
	 

		 
	 
	}
	
	
	}
	
	
	


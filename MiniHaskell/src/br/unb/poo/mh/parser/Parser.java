package br.unb.poo.mh.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



/**
 * Classe que pega uma string e divide em partes 
 * tendo o espaco como delimitador, por meio da
 * StringTokenizer.
 * @author drcfts
 *
 */
public class Parser {
	
	public List<String> parse(String s){
		List<String> separados = new ArrayList<String>();
		
		//Delimita espaco como o delimitador para dividir
		//a string em partes
		StringTokenizer st = new StringTokenizer(s, " ");
		
		while(st.hasMoreTokens()){
			separados.add(st.nextToken());
		}
		
		return separados;
	}
}

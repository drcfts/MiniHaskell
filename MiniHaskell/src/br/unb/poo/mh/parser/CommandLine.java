package br.unb.poo.mh.parser;

import java.util.Scanner;

public class CommandLine {
	
	public static void main(String args[]){
		String input = "";
		Intepreter interpretador = new Intepreter();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bem-vindo a Interpreter de MiniHaskell!");
		System.out.println("Operacoes suportadas: Expressoes matematicas e logicas(simples e compostas)");
		
		
		System.out.print("> ");
		input = scanner.nextLine();
		
		while(!input.equals("exit") && !input.equals("Exit")){
			try{
				try{
					String resultado;
					resultado = interpretador.traducao(input);
					System.out.println("RESULTADO = " + resultado);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			catch(RuntimeException re){
				RuntimeException erro = new RuntimeException("Erro de Sintaxe");
				System.out.println(erro.getMessage());
			}
			System.out.print("> ");
			input = scanner.nextLine();
		} //end while
		
		scanner.close();
	}
}

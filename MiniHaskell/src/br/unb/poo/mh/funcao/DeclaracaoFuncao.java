package br.unb.poo.mh.funcao;

import java.util.ArrayList;
import java.util.List;

import br.unb.poo.mh.Expressao;

public class DeclaracaoFuncao {

	private String nome;
	/*
	 * Na presenca de tipos, os argumentos formais 
	 * devem ser "anotados" com os respectivos tipos. 
	 * A verificacao de tipos da aplicacao de funcoes 
	 * deve checar se os argumentos atuais (que sao expressoes) 
	 * sao bem tipados em relacao aos argumentos formais. 
	 */
	private List<ArgumentoFormal> args;
	private Expressao corpo;
	
	public DeclaracaoFuncao(){
		args = new ArrayList<ArgumentoFormal>();
	}
	
	public DeclaracaoFuncao(String nome, List<ArgumentoFormal> args, Expressao corpo) {
		this.nome = nome;
		this.args = args;
		this.corpo = corpo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ArgumentoFormal> getArgs() {
		return args;
	}
	
	public void setArg(ArgumentoFormal arg){
		this.args.add(arg);
	}
	public void setArgs(List<ArgumentoFormal> args) {
		this.args = args;
	}

	public Expressao getCorpo() {
		return corpo;
	}

	public void setCorpo(Expressao corpo) {
		this.corpo = corpo;
	}
}

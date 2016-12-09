package br.unb.poo.mh.testes;

import org.junit.Test;
import org.junit.Assert;

import br.unb.poo.mh.parser.CommandLine;
import br.unb.poo.mh.parser.Intepreter;

public class TesteInterpreter {
	
	@Test
	public void testeSimples(){
		Intepreter interpreter = new Intepreter();
		
		Assert.assertEquals("2", interpreter.traducao("1 + 1"));
		Assert.assertEquals("2", interpreter.traducao("1 * 2"));
		Assert.assertEquals("2", interpreter.traducao("2 / 1"));
		Assert.assertEquals("2", interpreter.traducao("3 - 1"));
		Assert.assertEquals("true", interpreter.traducao("true and true"));
		Assert.assertEquals("true", interpreter.traducao("true or false"));
		Assert.assertEquals("true", interpreter.traducao("not false"));
		Assert.assertEquals("false", interpreter.traducao("true && false"));
		Assert.assertEquals("false", interpreter.traducao("false || false"));
		Assert.assertEquals("false", interpreter.traducao("not true"));

	}
	
	@Test
	public void testeLinhaComando(){
		String[] args = new String[1];
		CommandLine.main(args);
	}
}

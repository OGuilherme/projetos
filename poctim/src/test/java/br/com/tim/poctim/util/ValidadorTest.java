package br.com.tim.poctim.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidadorTest {

	private Validador validador = new Validador();

	@Test
	public void testaComparacaoDeStrings() {
		assertTrue(validador.comparaString("GUILHERME OLIVEIRA", "GUILHERME DE OLIVEIRA"));
	}
}

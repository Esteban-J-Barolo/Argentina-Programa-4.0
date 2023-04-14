package Clase6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OperadorTest {
	@Test
	void testMultiplicar() {
		double resultado = Operador.multiplicar(80,3);
		assertEquals(resultado, 240);
	}
	@Test
	void testSumarDividir() {
		double resultado = Operador.sumar(150,180);
		resultado = Operador.dividir(resultado, 3);
		assertEquals(resultado, 110);
	}
	@Test
	void testRestaMultiplicar() {
		double resultado = Operador.restar(90,50);
		resultado = Operador.multiplicar(resultado, 15);
		assertEquals(resultado, 605);
	}
	@Test
	void testSumarMultiplicar() {
		double resultado = Operador.sumar(70,40);
		resultado = Operador.multiplicar(resultado, 25);
		assertEquals(resultado, 2700);
	}

}

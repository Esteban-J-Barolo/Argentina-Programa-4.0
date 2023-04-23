package Clase8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Clase6.Operador;

class DescuentoTest {

	@Test
	void testDescuentoNegativo(){
		Descuento descuento = new DescuentoFijo();
		try {
			descuento.aplicarDescuento(-15);
			assertFalse(false);
		} catch (DescuentoException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testDescuentoCero(){
		Descuento descuento = new DescuentoFijo();
		try {
			descuento.aplicarDescuento(0);
			assertFalse(false);
		} catch (DescuentoException e) {
			assertTrue(true);
		}
	}

}

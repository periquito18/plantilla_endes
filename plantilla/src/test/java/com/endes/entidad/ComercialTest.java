package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComercialTest {

	private Comercial comercial;
	
	@BeforeEach
	void setUp() throws Exception {
		comercial = new Comercial("11111111H", "Juan", "Garcia", 1000.00, 10.00);
	}

	@Test
	@DisplayName("Probamos el método getVentas")
	void testGetVentas() {
		double cantidadEsperada = 10.00;
		double cantidadResultante = comercial.getVentas();
		assertEquals(cantidadEsperada, cantidadResultante);
	}
	
	@Test
	@DisplayName("Probamos el método setVentas")
	void testSetVentas() {
		double cantidadEsperada = 50.00;
		comercial.setVentas(cantidadEsperada);
		double cantidadResultante = comercial.getVentas();
		assertEquals(cantidadEsperada, cantidadResultante);
	}
	
	@Test
	@DisplayName("Probamos el método setVentas y lanzamos una excepción si el valor es negativo")
	void testSetVentasNegativas() {
		double cantidadEsperada = -10.00;
		Exception exception = assertThrows(IllegalArgumentException.class, ()-> comercial.setVentas(cantidadEsperada));
		String mensajeEsperado = "Las ventas no pueden ser negativas";
		assertEquals(mensajeEsperado, exception.getMessage());
	}
	
	@Test
	@DisplayName("Probamos el método calcularExtra")
	void testCalcularExtra() {
		double cantidadEsperada = 1.00;
		double cantidadResultante = comercial.calcularExtra();
		assertEquals(cantidadEsperada, cantidadResultante);
	}
	
	@Test
	@DisplayName("Probamos el método getSueldo")
	void testGetSueldo() {
		double cantidadEsperada = 1001.00;
		double cantidadResultante = comercial.getSueldo();
		assertEquals(cantidadEsperada, cantidadResultante);
	}
	
	@Test
	@DisplayName("Probamos el construtor y lanzamos una excepción si las ventas son negativas")
	void testConstructorException() {
		Exception exception = assertThrows(IllegalArgumentException.class, ()-> new Comercial("11111111H", "Juan", "Garcia", 1000.00, -10.00));
		String mensajeEsperado = "Las ventas no pueden ser negativas";
		assertEquals(mensajeEsperado, exception.getMessage());
	}

}

package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import code.Persona;

class PersonaTest {

	Persona jose = new Persona("Jose", 20, 'H', 60.00, 162);
	Persona carlos = new Persona("Carlos", 18 ,'T', 100.00, 190);
	Persona elias = new Persona();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Persona jose = new Persona("Jose", 20, 'H', 60.00, 162);
		Persona carlos = new Persona("Carlos", 18 ,'T', 100.00, 190);
		Persona elias = new Persona();
	
	}

	@Test
	void testPersona() {
		//Verifica que el objeto que se crea es de tipo persona 
		Persona julio = new Persona();
		assert(julio instanceof Persona);
		
	}

	@Test
	void testPersonaStringIntChar() {
		fail("Not yet implemented");
	}

	@Test
	void testPersonaStringIntCharDoubleDouble() {
		fail("Not yet implemented");
	}

	@Test
	void testSetNombre() {
		fail("Not yet implemented");
	}

	@Test
	void testSetEdad() {
		carlos.setEdad(12);
		assertTrue(carlos.getEdad() == 12);
	}

	@Test
	void testSetSexo() {
		jose.setSexo('M');
		assertEquals(jose.getSexo(), 'M');
		
		//Se supone que a un sexo inválido se le asigna M
		jose.setSexo('T');
		assertEquals(jose.getSexo(), 'H');
	}

	@Test
	void testSetPeso() {
		fail("Not yet implemented");
	}

	@Test
	void testSetAltura() {
		fail("Not yet implemented");
	}

	@Test
	void testCalcularIMC() {
		fail("Not yet implemented");
	}

	@Test
	void testEsMayorDeEdad() {
		assertTrue(carlos.esMayorDeEdad());
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}

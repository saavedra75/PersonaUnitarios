package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import code.Persona;

class PersonaTest {

	Persona jose = new Persona("Jose", 20, 'H', 60.00, 160);
	Persona carlos = new Persona("Carlos", 15 ,'T', 100.00, 190);
	Persona elias = new Persona();
	 /**
     * El peso de la persona esta por debajo del peso ideal
     */
    public static final int INFRAPESO = -1;
 
    /**
     * El peso de la persona esta en su peso ideal
     */
    public static final int PESO_IDEAL = 0;
 
    /**
     * El peso de la persona esta por encima del peso ideal
     */
    public static final int SOBREPESO = 1;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Persona jose = new Persona("Jose", 20, 'H', 68.0, 1.75);
		Persona carlos = new Persona("Carlos", 18 ,'T', 100.00, 7);
		Persona elias = new Persona();
		elias.setPeso(120);
		jose.setPeso(60);
		jose.setAltura(1.60);
		
	
	}

	@Test
	void testPersona() {
		//Verifica que el objeto que se crea es de tipo persona 
		Persona julio = new Persona();
		assert(julio instanceof Persona);
		
	}

	@Test
	void testSetNombre() {
		Persona julio = new Persona();
		julio.setNombre("Julio");
		assertEquals(julio.getNombre(), "Julio");
	}

	@Test
	void testSetEdad() {
		carlos.setEdad(12);
		assertTrue(carlos.getEdad() == 12);
	}
	

	@Test
    public void testGenerarDni() {
        Persona persona = new Persona();
        String dniRegex = "\\d{8}[A-Z]";

        assertTrue(persona.getDNI().matches(dniRegex));
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
		jose.setPeso(88.9);
		assertTrue(jose.getPeso()==88.9);
	}
	
	@Test
	void testMayorEdad() {
		carlos.setEdad(1);
		assertTrue(jose.esMayorDeEdad());
		assertTrue(carlos.esMayorDeEdad() == false);

	}
	
	
	@Test
	void testSetAltura() {
		jose.setAltura(162.2);
		assertTrue(jose.getAltura()==162.2);	
	}
	
    @Test
    public void testCalcularIMC_Infrapeso() {
        assertEquals(Persona.INFRAPESO, carlos.calcularIMC());
    }
    
    @Test
    public void testCalcularIMC_Sobrepeso() {
        assertEquals(Persona.SOBREPESO, elias.calcularIMC());
    }


	//	Persona jose = new Persona("Jose", 20, 'H', 60.00, 162);

	@Test
	void testToString() {
		String resultadoEsperado = "Informacion de la persona:\n"
                + "Nombre: " + "Jose" + "\n"
                + "Sexo: " + "hombre" + "\n"
                + "Edad: " + 20 + " años\n";

		assertTrue(jose.toString().contains(resultadoEsperado));
		
	}


}

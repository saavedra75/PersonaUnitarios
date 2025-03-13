package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import code.Persona;

class PersonaTest {

	public static Persona jose = new Persona("Jose", 20, 'H', 60.00, 160);
	public static Persona carlos = new Persona("Carlos", 15 ,'T', 100.00, 1.90);
	public static Persona elias = new Persona();


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
        assertTrue(carlos.getDNI().matches(dniRegex));
        assertTrue(jose.getDNI().matches(dniRegex));
    }
	
	//No es posible comprobar los casos en los que el dni realmente no sea válido puesto que los dni se 
	//generan automáticamente al crear una persona. El método que genera los DNI ya está testado. Parece no haber margen de error.
	@Test
	public void testEsValidoDNI() {
		assertTrue(jose.esValidoDNI());
		assertTrue(carlos.esValidoDNI());
		assertTrue(elias.esValidoDNI());
	}
	
	@Test
	void testSetSexo() {
		jose.setSexo('M');
		assertEquals(jose.getSexo(), 'M');
		
		//Se supone que a un sexo inválido se le asigna M
		jose.setSexo('T');
		assertEquals(jose.getSexo(), 'H');
	}

    //Aquí tuve que crear un método público para acceder a generaLetraDNI() porque este es inaccesible 
    //debido a su visibilidad privada.
    @Test
    public void testGeneraLetraDNI() {
    	assertEquals(jose.visualizarGeneraLetraDNI(11), 'B');
    	assertEquals(jose.visualizarGeneraLetraDNI(22), 'E');
    	assertEquals(jose.visualizarGeneraLetraDNI(1), 'R');
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
		assertFalse(carlos.esMayorDeEdad());

	}
	
	
	@Test
	void testSetAltura() {
		jose.setAltura(162.2);
		assertTrue(jose.getAltura()==162.2);	
	}
	
	//Con este test he averiguado que el campo altura debe estar en metros, no en centímetros.
    @Test
    public void testCalcularIMCPesoIdeal() {
    	jose.setAltura(1.60);
        assertEquals(Persona.PESO_IDEAL, jose.calcularIMC());
    }
    
    
    @Test
    public void testCalcularIMC_Infrapeso() {
        assertTrue(elias.calcularIMC() == Persona.INFRAPESO);

    }
    
    @Test
    public void testCalcularIMC_Sobrepeso() {
    	carlos.setPeso(600);
        assertEquals(Persona.SOBREPESO, carlos.calcularIMC());
    }

	@Test
	void testToString() {
		String resultadoEsperado = "Informacion de la persona:\n"
                + "Nombre: " + "Jose" + "\n"
                + "Sexo: " + "hombre" + "\n"
                + "Edad: " + 20 + " años\n"
                + "DNI: " + jose.getDNI() + "\n"
                + "Peso: " + 60.00 + " kg\n"
                + "Altura: " + 160.0 + " metros\n";

		assertTrue(jose.toString().contains(resultadoEsperado));
		
	}


}

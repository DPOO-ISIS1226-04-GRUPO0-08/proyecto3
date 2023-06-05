/**
 * 
 * En este test se prueba el:
 * 
 *  1. funcionamiento de carga de datos 
 *  2. funcion complementaria
 *  
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Controller.Inventario;

class TestInventaro {
	
	private String habitacion ;
	private String platos ;
	private int idreserva;
	private String nombre;
	private Inventario inventario;
	
	@BeforeEach
	private void setUp() throws Exception {
		habitacion = "//datos//habitaciones.csv";
		platos = "//datos//platos.csv";
		inventario = new Inventario() ;
		nombre = "prueba1";
		idreserva = -1;	
	}
	


	//@Test
	public void testCargarHabitaciones()throws Exception {
		setUp();
		try {
			inventario.cargarHabitaciones(habitacion);
		}catch(Exception e){
			e.printStackTrace();
		}

		
	}
	//@Test
	public void testCargarPlatos()throws Exception {
		setUp();
		setUp();
		try {
			inventario.cargarHabitaciones(platos);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//@Test
	public void testCalcularTotal() throws Exception {
		setUp();
		assertEquals(0.0, inventario.calcularTotal(nombre));
	}
	
	

}

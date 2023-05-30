package Model;

import java.util.List;

public class Huesped {

	private String nombre;
	private String documento;
	private int edad;
	private List<Servicio> servicioExtra;
	
	
	
	public Huesped(String nombre, String documento, int edad) {
		
		this.nombre = nombre;
		this.documento = documento;
		this.edad = edad;
		
	}
	

	public double gastosHuesped() {
		
		double total = 0;
		for(Servicio ser : servicioExtra) {
			total += ser.getCosto();
		} 
		return total;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void agregarServicio(Servicio servicio) {
		servicioExtra.add(servicio);
	}
}

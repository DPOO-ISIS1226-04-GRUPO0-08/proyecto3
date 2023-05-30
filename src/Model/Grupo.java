/**
 * 
 */
package Model;

import java.util.Date;

import java.util.ArrayList;

/**
 * @author Lenovo
 *
 */
public class Grupo {

	
	
	private double tarifaTotal;
	private Date fechai;
	private int ndias ;
	private Huesped huespedPrincipal;
	private ArrayList<Huesped> huespedes;
	private ArrayList<Habitacion> habitaciones;
	private ArrayList<Servicio> servicios;
	
	
	
	public Grupo(Huesped principal,ArrayList<Huesped> huespedes,ArrayList<Habitacion> habitaciones,Date fechai,int ndias) {
		this.huespedPrincipal = principal;
		this.huespedes = huespedes;
		this.habitaciones = habitaciones;
		this.tarifaTotal = 0;
		this.ndias = ndias;
		this.fechai = fechai;
		this.servicios = new ArrayList<Servicio>();
		
	}
	
	
	
	public double calcularTarifa() {
		
		double total = 0;
		for(Servicio hab : habitaciones) {
			total += hab.getCosto();
		} 
		return total;
	}
	
	public void agregarServicio(Servicio servicio) {
		

		this.servicios.add(servicio);
		
	}
	public Huesped getHuespedPrincipal() {
		return this.huespedPrincipal;
	}
	
	public ArrayList<Huesped> getHuespedes(){
		return this.huespedes;
	}
	
	public void gastosGrupo() {
		
		double total = 0;
		for(Servicio ser : servicios) {
			total += ser.getCosto();
		} 
		tarifaTotal = total;
	}
	
	
	public double gastoTotal(){
		gastosGrupo();
		double total = tarifaTotal;
		for(Huesped huesped: huespedes) {
			total += huesped.gastosHuesped();
		}
		double valor = 0.0;
		for(Habitacion hab: habitaciones) {
			valor += hab.getCostos().get(fechai);
		}
		
		return total + valor*ndias;
	}
}

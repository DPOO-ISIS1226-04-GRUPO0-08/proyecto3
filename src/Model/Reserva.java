
package Model;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class Reserva {

	private int id;
	private Date fechaInicio;
	private Date fechaFinal;
	private String nombreRep;
	private ArrayList<Huesped> huespedes;
	private int nninios;
	private int npersonas;
	private ArrayList<Habitacion> habitaciones;
	
	public Reserva(int id,Date fechai, Date fechaf, String nombre, ArrayList<Huesped> huespedes) {
		// TODO Auto-generated constructor stub
		this.fechaInicio = fechai;
		this.fechaFinal = fechaf;
		this.nombreRep = nombre;
		this.huespedes = huespedes;
		this.nninios = 0;
		this.npersonas = 0;
		this.habitaciones = new ArrayList<Habitacion>();
		
	}
	public 	Date getFechaInicio() {
		return this.fechaInicio;
	}
	public Date getFechaFinal() {
		return this.fechaFinal;
	}
	public void setFechaInicio(Date inicio) {
		this.fechaInicio = inicio;
	}
	public void setFechaFinal(Date finall) {
		this.fechaFinal = finall;
	}
	public void setNninios(int n) {
		this.nninios = n;
	}
    public void setNpersonas(int n) {
    	this.npersonas = n;
    }
    public int getId() {
    	return this.id;
    }
    public void anadirHabitacion(Habitacion hab) {
    	this.habitaciones.add(hab);
    }
    public String getNombre() {
    	return this.nombreRep;
    }
    public ArrayList<Huesped> getHuespedes(){
    	return this.huespedes;
    }
    public ArrayList<Habitacion> getHabitaciones(){
    	return this.habitaciones;
    }
}

/**
 * 
 */
package Model;


import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Lenovo
 *
 */
public class Habitacion extends Servicio {


	private String identificador;
	private String tipo;
	private String ubicacion; // #piso
	//private List<Huesped> huespedes;
	private List<Cama> camas;
	private boolean cocina;
	private boolean balcon;
	private int capacidadNinios = 0;
	private int capacidadAdultos = 0;
	private int capacidad = 0;
	private ArrayList<Reserva> reservas;
	private HashMap<Date,Double> costos;
	private LocalDate fechaHoy = LocalDate.now();
	
	
	
	public Habitacion(String nombre, String identificador, String tipo, double costo, List<Cama> camas, String ubicacion, boolean balcon, boolean cocina) throws ParseException {
		
		super(nombre,costo);
		
		this.identificador = identificador;
		this.tipo = tipo;
		this.ubicacion = ubicacion;
		this.camas = camas;
		this.balcon = balcon;
		this.cocina = cocina;
		this.reservas = new ArrayList<>();
		this.costos = new HashMap<>();
		
		cargarCapacidades(camas);
		this.capacidad = capacidadNinios + capacidadAdultos;
		
		cargarCostosFechas();
	}
	
	
	public String getTipo() {
		return this.tipo;
	}
	
	
	public String getId() {
		return this.identificador;
	}
	
	
	public void setTipo(String tipos) {
		this.tipo = tipos;
	}
	
	
	public void agregarReserva(Reserva reserva) {
		
		this.reservas.add( reserva);
	}
	
	
		
	
	public boolean getBalcon() {
		return this.balcon;
	}
	public boolean getCocina() {
		return this.cocina;
	}
	
	public int getNpersonas() {
		return this.capacidad;
	}
	public int getNninios() {
		return this.capacidadNinios;
	}
	
	public ArrayList<Reserva> getReservas(){
		return this.reservas;
	}
	
	public HashMap<Date,Double> getCostos(){
		return this.costos;
	}

	public void editarPrecio(String fecha, Double costo) throws ParseException {
		DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		Date date= formateador.parse(fecha);
		this.costos.put(date,costo);		
	}

		
	private void cargarCapacidades(List<Cama> camas) {
		for (Cama camita : camas) {
			if (camita.getNinio()) {
				capacidadNinios += camita.getCantidad();	
			} else {
				capacidad += camita.getCantidad();
			}
		}
	}
	
	
	private void cargarCostosFechas() throws ParseException {
		int i = 0;
		DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");

		LocalDate diaActual = fechaHoy;
		while (i < 365) {
			
			String fechaCambiante = "" + diaActual.getDayOfMonth() + "/" + diaActual.getMonthValue() + "/" + diaActual.getYear();

			diaActual = diaActual.plusDays(1);
			
			Date date= formateador.parse(fechaCambiante);
			
			costos.put(date, super.costo);
			
			i += 1;
		}
		
	}
	
	
	public int cambiarCosto(double nuevoCosto, String fechaInicio, String fechaFinal) throws ParseException {
		
		DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		Date dateInicio = formateador.parse(fechaInicio);
		Date dateFin = formateador.parse(fechaFinal);
		
		String[] partesInicio = fechaInicio.split("/");
		
		LocalDate fechaIni = LocalDate.of(Integer.parseInt(partesInicio[2]), Integer.parseInt(partesInicio[1]), Integer.parseInt(partesInicio[0]));
		
		String fechaCambiante = "" + fechaIni.getDayOfMonth() + "/" + fechaIni.getMonthValue() + "/" + fechaIni.getYear();
		Date dateCambiante = formateador.parse(fechaCambiante);
		
		if (dateInicio.before(dateFin)) {
			
			while (!(dateCambiante.after(dateFin))) {
				
				costos.put(dateCambiante, nuevoCosto);
				fechaIni = fechaIni.plusDays(1);

				fechaCambiante = "" + fechaIni.getDayOfMonth() + "/" + fechaIni.getMonthValue() + "/" + fechaIni.getYear();
				dateCambiante = formateador.parse(fechaCambiante);
			
				}	
			return 1;
			
		} else {
			return 0;
		}
		
	}
	
	
}

package Controller;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import Model.Cama;
import Model.Habitacion;
import Model.Huesped;
import Model.Plato;
import Model.Reserva;
import Model.Servicio;
import Model.Grupo;


public class Inventario {

	
	private List<Habitacion> habitaciones = new ArrayList<Habitacion>();
	private List<Habitacion> estandar = new ArrayList<Habitacion>();
	private List<Habitacion> suite = new ArrayList<Habitacion>();
	private List<Habitacion> suite_doble = new ArrayList<Habitacion>();
	
 	private List<Plato> restaurante = new ArrayList<Plato>();
	private List<Servicio> otrosServicios = new ArrayList<Servicio>();
	private List<Reserva> reservas = new ArrayList< Reserva>();
	private List<Grupo> grupos = new ArrayList<Grupo>();
	
	
	
	
	
	
	
	
	@SuppressWarnings("resource")
	public void cargarHabitaciones(String nombreArchivoHabitaciones) throws IOException, NumberFormatException, ParseException {
		
		BufferedReader reader = null;
		
			
			reader = new BufferedReader(new FileReader(nombreArchivoHabitaciones));
			String linea = reader.readLine();
			
			linea = reader.readLine();
			while (linea != null) {

				String [] fields = linea.split(",");
				
				List<Cama> listaCamas = new LinkedList<Cama>();
				
				String [] infoCamas = fields[3].split("-");
				for (String cama : infoCamas) {
					listaCamas.add(new Cama(cama));
				}
				
				Habitacion habitancion = new Habitacion("habitacion", fields[0], fields[1], Double.parseDouble(fields[2]), listaCamas, fields[4] , toBoolean(fields[5]), toBoolean(fields[6]));
				
				habitaciones.add(habitancion);
				if(habitancion.getTipo().equals("estandar")) {
					estandar.add(habitancion);
				}
				else if(habitancion.getTipo().equals("suite")) {
					suite.add(habitancion);
				}
				else {
					suite_doble.add(habitancion);
				}
				
				linea = reader.readLine();
			}
	}
	
	public int cargarReserva(Date fechai, Date fechaf, String nombre, ArrayList<Huesped> huespedes) {
		int n = reservas.size();
		Reserva reserva = new Reserva(n,fechai,fechaf,nombre,huespedes);
		reservas.add(reserva);
		return n;
	}
	
	public String buscarHabitaciones(int id, String tipo, int npersonas,int nninios,boolean balcon, boolean cocina, Date fechai,Date fechaf){
		
		
		if(tipo.equals("estandar")) {
			for(Habitacion k : estandar) {
				if (k.getCocina() == cocina && k.getBalcon() == balcon && k.getNpersonas() <= npersonas && k.getNninios()<=nninios) {
					int cont = 0;
					for(Reserva res : k.getReservas()) {
						Date a = res.getFechaInicio();
						Date b = res.getFechaFinal();
						if (((fechai.compareTo(a) < 0 && fechaf.compareTo(b) < 0 ) || (fechai.compareTo(a) > 0 && fechaf.compareTo(b) > 0) ) == false) {
							break;
						}else {
							cont+=1;
						}
					}
					if( cont == k.getReservas().size()) {
						for (Reserva r: reservas) {
							if(r.getId() == id) {
								r.anadirHabitacion(k);
								k.agregarReserva(r);
							}
						}
						
						return "La habitación se ha guardado exitosamente";
					}
				}
			}
	    }
		else if(tipo.equals("suite")) {
			for(Habitacion k: suite) {
				if (k.getCocina() == cocina && k.getBalcon() == balcon && k.getNpersonas() <= npersonas && k.getNninios()<=nninios) {
					int cont = 0;
					for(Reserva res : k.getReservas()) {
						Date a = res.getFechaInicio();
						Date b = res.getFechaFinal();
						if (((fechai.compareTo(a) < 0 && fechaf.compareTo(b) < 0 ) || (fechai.compareTo(a) > 0 && fechaf.compareTo(b) > 0) ) == false) {
							break;
						}else {
							cont+=1;
						}
					}
					if( cont == k.getReservas().size()) {
						for (Reserva r: reservas) {
							if(r.getId() == id) {
								r.anadirHabitacion(k);
								k.agregarReserva(r);
							}
						}
						return "La habitación se ha guardado exitosamente";
					}
				}
				
				
			}
		}
		else {
			for(Habitacion k: suite_doble) {
				if (k.getCocina() == cocina && k.getBalcon() == balcon && k.getNpersonas() <= npersonas && k.getNninios()<=nninios) {
					int cont = 0;
					for(Reserva res : k.getReservas()) {
						Date a = res.getFechaInicio();
						Date b = res.getFechaFinal();
						if (((fechai.compareTo(a) < 0 && fechaf.compareTo(b) < 0 ) || (fechai.compareTo(a) > 0 && fechaf.compareTo(b) > 0) ) == false) {
							break;
						}else {
							cont+=1;
						}
					}
					if( cont == k.getReservas().size()) {
						for (Reserva r: reservas) {
							if(r.getId() == id) {
								r.anadirHabitacion(k);
								k.agregarReserva(r);
							}
						}
						return "La habitación se ha guardado exitosamente";
					}
				}
				
				
			}
		}
		return "no se ha encontrado habitación";
	}
	
	public String crearGrupoAbeliano(String nombre, int ndias, Date fechai){
		for(Reserva r: reservas) {
			if(nombre.equals(r.getNombre())) {
				Grupo grupo = new Grupo(r.getHuespedes().get(0),r.getHuespedes(),r.getHabitaciones(),fechai,ndias);
				grupos.add(grupo);
				return"El grupo se ha creado con exito";
			}
			
			}
		return "La reserva no existe";
		}
	
	
	
	public void cargarUnaHabitacion(String tipo, double costoHabitacion, String strCamas, String ubicacion,	boolean balconBool, boolean cocinaBool) throws ParseException {
		
		List<Cama> listaCamas = new LinkedList<Cama>();
		String [] infoCamas = strCamas.split("-");
		for (String cama : infoCamas) {
			listaCamas.add(new Cama(cama));
		}
		String id = habitaciones.size() + "";
		Habitacion habitancion = new Habitacion("habitacion", id, tipo, costoHabitacion, listaCamas, ubicacion , balconBool, cocinaBool);
		
		habitaciones.add(habitancion);
		if(habitancion.getTipo().equals("estandar")) {
			estandar.add(habitancion);
		}
		else if(habitancion.getTipo().equals("suite")) {
			suite.add(habitancion);
		}
		else {
			suite_doble.add(habitancion);
		}
	}
	
	
	
	public void cargarOtrosServicios(String nombreArchivoServicios) throws IOException {
		
		BufferedReader reader = null;
		
		reader = new BufferedReader(new FileReader(nombreArchivoServicios));
		
		String linea = reader.readLine();
		
		linea = reader.readLine();
		while (linea != null) {
			String [] fields = linea.split(",");
			Servicio servicio = new Servicio(fields[0],Double.parseDouble(fields[1]));
			otrosServicios.add(servicio);
		}
		
		
		
	}
	
	public String cobrarServiciosGrupo(String nombre, String servicio) {
		for(Grupo grupo: grupos) {
			if(grupo.getHuespedPrincipal().getNombre().equals(nombre)){
				for(Servicio servi: otrosServicios) {
					if(servi.getNombre().equals(servicio)) {
						grupo.getHuespedPrincipal().agregarServicio(servi);
						return "Se ha cobrado con exito";
					}
				}
			}
		}
		return "Ha ocurrido un problema";
		
	}
	
	public String cobrarPorHuesped(String nombre, String servicio, String nom) {
		for(Grupo grupo: grupos) {
			if(grupo.getHuespedPrincipal().getNombre().equals(nombre)){
				for(Huesped huesped: grupo.getHuespedes()) {
					if(huesped.getNombre().equals(nom)) {
						for(Servicio servi: otrosServicios) {
							if(servi.getNombre().equals(servicio)) {
								grupo.getHuespedPrincipal().agregarServicio(servi);
								return "Se ha cobrado con exito";
					}
				 }
			   }
		    }
		  }
		}
		return "Ha ocurrido un problema";
		
	
	}
	
	public Reserva consultarReserva(int id) {
		
			for(Reserva reserva: reservas) {
				if(reserva.getId() == id) {
					return reserva;
				}
			}
		return null;
		
		
	  }
	
	
	public void cargarPlatos(String nombreArchivoPlatos) {
		
		String line = "";
		String splitComa = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivoPlatos))) {
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] datos = line.split(splitComa);
				Plato comida = new Plato(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2]), Boolean.parseBoolean(datos[3]));
				restaurante.add(comida);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Imprimir las comidas cargadas
		for (Plato comida : restaurante) {
			System.out.println(comida);
		}
	}
	public void subirunPLato(String nombrePlato, int precioPlato, boolean disponibilidad) {

        int idPlato = restaurante.size() + 1;

        Plato nuevoPlato = new Plato(idPlato, nombrePlato, precioPlato, disponibilidad);
        restaurante.add(nuevoPlato);

        System.out.println("Plato agregado exitosamente: " + nuevoPlato);

    }
	
	public double calcularTotal(String nombre) {
		for(Grupo grupi: grupos) {
			if(grupi.getHuespedPrincipal().equals(nombre)) {
				
				return grupi.gastoTotal();
			}
		}
		return 0.0;
	}
	

	
	
	public static Boolean toBoolean(String string) {
		return Boolean.valueOf(string);
	}

	
	
	
	
	
	public String cambiarCostosPorTipo(int tipoHabitacion, double nuevoCosto, String fechaInicio, String fechaFin) throws ParseException {
		
		List<Habitacion> listaHabitaciones;
		
		if(tipoHabitacion == 1) {
			listaHabitaciones = this.estandar;
		} else if(tipoHabitacion == 2) {
			listaHabitaciones = this.suite;
		} else if(tipoHabitacion == 3) {
			listaHabitaciones = this.suite_doble;
		} else {
			return "No se encontro eligio una opcion valida";
		}
		
		for (Habitacion habi : listaHabitaciones) {
			habi.cambiarCosto(nuevoCosto,  fechaInicio, fechaFin);
			}
		
		return "";
		}



}

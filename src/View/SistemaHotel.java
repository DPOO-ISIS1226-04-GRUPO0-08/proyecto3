package View;

import java.util.ArrayList;
import java.util.Date;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;




import Controller.Inventario;
import Model.Huesped;


public class SistemaHotel {

	
	/**
	 * @param args
	 */
	private Inventario inventario = new Inventario();
	
	private BufferedReader reader = null;
	
	
	
	
	private void iniciarPrograma() throws IOException, ParseException {

		boolean openHotel = true;
		
		while(openHotel) {
			
			//try { 
				mostrarMenu();
				int respuesta = Integer.parseInt(input("Por favor seleccione una opción para que el programa funcione: "));
				
				switch(respuesta){
					case 1:
						boolean openHotel2 = true;
			
						while(openHotel2) {

							
							try { 
								mostrarMenu2();
								int respuesta2 = Integer.parseInt(input("Por favor seleccione una opción para que el programa funcione: "));
								
								switch(respuesta2){
									case 1:
										opcion1Carga();
										break;
										
									case 2:
										opcion2Carga();
										break;
										
									case 3:
										opcion3Carga();
										break;
									case 0:
										openHotel2 = false;
										System.out.println("\tSaliendo del programa\n");
										break;
										
									default:
										openHotel2 = false;
										System.out.println("\tSaliendo del programa\n");
										break;
								}			
								
							} catch (NumberFormatException e) {
								System.err.println("Debe seleccionar uno de los números de las opciones.");
							}
							
						}
						break;
						
					case 2:
						opcion2();
						break;
						
					case 3:
						opcion3();
						break;
						
					case 4:
						opcion4();
						break;
						
					case 5:
						opcion5();
						break;	
					
					case 6:
						opcion6();
						break;	
					case 7:
						opcion7();
						break;
					case 8:
						opcion8();
						break;
					case 9:
						opcion9();
						break;
					case 10:
						opcion10();
						break;
					case 11:
						opcion11();
						break;
						
					case 0:
						openHotel = false;
						System.out.println("\tSaliendo del programa\n");
						break;
						
					default:
						openHotel = false;
						System.out.println("\tSaliendo del programa\n");
						break;
				}			
			/**	
			} catch (NumberFormatException e) {
				System.err.println("Debe seleccionar uno de los números de las opciones.");
			}
			*/
		}


	}
	
	
	private void mostrarMenu(){
		
		System.out.println("Bienvenido a su PMS");
		System.out.println("1- Cargar archivos CSV");
		System.out.println("2- Cargar una habitacion ");
		System.out.println("3- Crear una reserva ");
		System.out.println("4- Crear un grupo ");
		System.out.println("5- Cambiar el costo de un tipo de habitacion por fecha");
		System.out.println("6- Cargar un archivo de otros servicios ");
		System.out.println("7- Cobrar servicio a un grupo");
		System.out.println("8- Cobrar servicio a un huesped");
		System.out.println("9- Consultar reserva");
		System.out.println("10- Agregar plato por separado");
		System.out.println("11- Calcular cuenta final de un grupo");
		System.out.println("0- Salir de la aplicacion");
	}
	
	
	
	private void mostrarMenu2(){
		System.out.println("Bienvenido a las cargas de datos");
		System.out.println("1- Cargar archivos con la info de las habitaciones");
		System.out.println("2- Cargar información de los platos");
		System.out.println("3- Cargar información de las reservas");
		System.out.println("0- Volver al anterior menu");

	}
	

	
	
	private void opcion1Carga() throws IOException, NumberFormatException, ParseException {
		
		// datos\habitaciones.csv
		
		String nombreArchivo = input("Ingrese el nombre del archivo de habitaciones a subir: ");

		inventario.cargarHabitaciones(nombreArchivo);
		
		System.out.println("\nHabitaciones cargadas por archivo de manera exitosa\n");
	}
	
	
	private void opcion2() throws IOException, ParseException {
		
		//try {
			
			System.out.println("Seleccione el tipo de habitacion\n 1- estandar \n 2- suite \n 3- suite doble");
			int tipoHabitacion = Integer.parseInt(input("Su opcion de tipo: "));
			String tipo;
			if(tipoHabitacion == 1) {
				tipo = "estandar";
			} else if(tipoHabitacion == 2) {
				tipo = "suite";
			} else if(tipoHabitacion == 3) {
				tipo = "suite doble";
			} else {
				tipo = "estandar";
			}
			
			double costoHabitacion = Double.parseDouble(input("Ingrese el costo de la habitacion: "));
			
			int cantCamas = Integer.parseInt(input("Ingrese la cantidad de camas en total: "));
			int cantidad;
			int i = 1;
			int niniosCheck = 0;
			String strCamas = "";
			
			while (i <= cantCamas) {
				System.out.println("Cama # " + i);
				System.out.println("La cama es de ninio? \n 1- Si \n 0- No");
				niniosCheck = Integer.parseInt(input("Su opcion: "));
				cantidad = Integer.parseInt(input("Ingrese la cantidad de personas que caben en esta cama: "));		
				strCamas += cantidad;
				
				if (niniosCheck == 1) 
					strCamas += "n";
				strCamas += "-";
				
				i += 1;
			}
			strCamas = strCamas.substring(0, strCamas.length()-1);
			
			System.out.println(strCamas);
			
			String ubicacion = input("Escriba la ubicacion (Ej: piso 1) ");
			
			boolean balconBool;
			System.out.println("¿La habitacion cuenta con balcon?\n 1- verdadero \n 0- falso");
			int balcon = Integer.parseInt(input("Su opcion de balcon: "));
			if(balcon == 1) {
				balconBool = true;
			} else {
				balconBool = false;
			} 
			
			boolean cocinaBool;
			System.out.println("¿La habitacion cuenta con cocina?\n 1- verdadero \n 0- falso");
			int cocina = Integer.parseInt(input("Su opcion de cocina: "));
			if(cocina == 1) {
				cocinaBool = true;
			} else {
				cocinaBool = false;
			} 

			inventario.cargarUnaHabitacion(tipo, costoHabitacion, strCamas, ubicacion, balconBool, cocinaBool);
		
	}

	
	
	private void opcion3() throws IOException, ParseException {
		//SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		String nombreRep = input("Ingrese el nombre del representante de su reserva: ");
		String fechai = input("Ingrese la fecha del inicio de su estadia, en el formato  (dd/mm/yyyy): ");
		String fechaf = input("Ingrese la fecha del final de su estadia en el mismo formato: ");
		Integer n = Integer.parseInt(input("Ingrese el numero de habitantes"));
		int i = 0;
		ArrayList huespedes = new ArrayList<>();
		while(i < n) {
			String huesped = input("Ingrese el nombre del huesped empezando por el representante): ");
			int edad = Integer.parseInt("Ingrese la edad del huesped");
			String documento=  input("Ingrese el documento del huesped");
			Huesped huespe =new Huesped(huesped,documento,edad);
			huespedes.add(huespe);
		}
		
		DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		Date dateInicio = formateador.parse(fechai);
		Date dateFinal = formateador.parse(fechaf);
		
		int p = inventario.cargarReserva(dateInicio, dateFinal, nombreRep, huespedes);
		
		Integer k = Integer.parseInt(input("Ingrese la cantidad de habitaciones que le gustaría: "));
		int j = 0;
		
		while(j < k) {
			String tipo = input("Ingrese el tipo de la habitación, las opciones son estandar, suite y suite_doble: ");
			Integer h = Integer.parseInt(input("Ingrese el número de personas que se quedarán en esta habitación: "));
			Integer g = Integer.parseInt(input("Ingrese el número de niños que se quedarán en esta habitación: "));
			Integer cocina = Integer.parseInt(input("Ingrese 1 si quiere que su habitación tenga cocina: "));
			boolean cocinna = false;
			if(cocina.equals(1)) {
				cocinna = true;
			}
			Integer balcon = Integer.parseInt(input("Ingrese 1 si quiere que su habitación tenga balcón: "));
			boolean balconn = false;
			if(balcon.equals(1)) {
				balconn = true;
			}
			System.out.println(inventario.buscarHabitaciones(p, tipo, h, g, balconn, cocinna, dateInicio, dateFinal));
		}
		
		
	}
	
	
	
	
	
	private void opcion4()throws IOException, ParseException {
		
		System.out.println("Para crear un grupo es necesario tener una reserva previa \n");
		String nombre = input("Ingrese el nombre del huesped principal de la reserva: ");
		int g = Integer.parseInt(input("Ingrese el número de dias que se quedarán"));
		DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		
		String fechai = input("Ingrese la fecha en formato dd/MM/yyyy");
		Date dateInicio = formateador.parse(fechai);
		
		System.out.println(inventario.crearGrupoAbeliano(nombre,g,dateInicio));
		
		
	}
	

	private void opcion5() throws ParseException {
		
		System.out.println("Seleccione el tipo de habitacion a cambiarle el precio\n 1- estandar \n 2- suite \n 3- suite doble");
		int tipoHabitacion = Integer.parseInt(input("Su opcion de tipo: "));
		
		double nuevoCosto = Double.parseDouble(input("Escriba el nuevo costo pra las habitaciones: "));
		String fechaInicio = input("Escriba la fecha de inicio del cambio de costo (dd/mm/yyyy): ");
		String fechaFin = input("Escriba la fecha de fin del cambio de costo (dd/mm/yyyy): ");
		
		String vuelta = inventario.cambiarCostosPorTipo(tipoHabitacion, nuevoCosto, fechaInicio, fechaFin);
		
		if (vuelta.compareTo("") != 0)
			System.out.println(vuelta);
		else
			System.out.println("Costos cargados correctamente en (" + fechaInicio + ") - (" + fechaFin + ")");
		
			
	}
	
	private void opcion7() {
		String nombre = input("Ingrese el nombre del representante del grupo");
		String servicio = input("Ingrese el nombre del servicio que quiere pagar");
		System.out.println(inventario.cobrarServiciosGrupo(nombre, servicio));
	}
	
	private void opcion8() {
		String nombre = input("Ingrese el nombre del representante del grupo");
		String servicio = input("Ingrese el nombre del servicio que quiere pagar"); 
		String nom = input("Ingrese el nombre del huesped");
		System.out.println(inventario.cobrarPorHuesped(nombre, servicio, nom));
	}
	
	private void opcion9() {
		int id = Integer.parseInt(input("Ingrese el id de la reserva que va a consultar: "));
		System.out.println( inventario.consultarReserva(id));
	}
	

	//private void opcion1Caga() throws IOException{

	//}


	//private void opcion2Carga() throws IOException{
		
	//}


	//private void opcion3Carga() throws IOException{
		
	//}
	private void opcion10() throws IOException{
        String plato = input("Por favor ingrese el nombre del plato que desea agregar: ");
        int precio = Integer.parseInt("Por favor ingresè el precio del plato: ");
        int llevar_cuarto = Integer.parseInt("El plato se puede llevar al cuarto? 1- Si 2- No");
        boolean disponibilidad = true;
        if (llevar_cuarto == 1) {
            disponibilidad = true;
        } else {
            disponibilidad = false;
        }
        inventario.subirunPLato(plato, precio, disponibilidad);
    }
	

	private void opcion11() {
		String nombre = input("Ingrese el nombre del huesped principal del grupo del que quiere pagar");
		System.out.println(inventario.calcularTotal(nombre));
	}
	
	
	
	
	private void opcion2Carga() throws IOException {
		
		// datos\platos.csv
		String nombreArchivoPlatos = input("Ingrese el nombre del archivo de platos a subir: ");
		
		inventario.cargarPlatos(nombreArchivoPlatos);

	}
	
	
	private void opcion3Carga() throws IOException{
		
	}
	
	private void opcion6() throws IOException{
		String nombreArchivoServicios = input("Ingrese el nombre del archivo de platos a subir: ");
		
		inventario.cargarOtrosServicios(nombreArchivoServicios);
	}
	
	
	
	
	
	public void editarHabitaciones(File file) {	
	}
	
	
	public void editarServicios(File file) {
	}
	
	
	public static Boolean toBoolean(String string) {
		return Boolean.valueOf(string);
	}
	
	
	
	/**
	 * Este método sirve para imprimir un mensaje en la consola pidiéndole
	 * información al usuario y luego leer lo que escriba el usuario.
	 * 
	 * @param mensaje El mensaje que se le mostrará al usuario
	 * @return La cadena de caracteres que el usuario escriba como respuesta.
	 */

	private String input(String mensaje) {
		try	{
			if (reader == null) {
				//System.out.println("Primer input");
				reader =  new BufferedReader(new InputStreamReader(System.in));	
			}
			
			System.out.print(mensaje);
			return reader.readLine();
			
		} catch (IOException e)	{
			System.err.println("Error leyendo de la consola");
			e.printStackTrace();
			return "";
		}
	}

	
	
	
	public static void main(String[] args) throws IOException, ParseException {
		
		SistemaHotel hotel = new SistemaHotel();
		hotel.iniciarPrograma(); 
    
		// TODO Auto-generated method stub
	}

	
}

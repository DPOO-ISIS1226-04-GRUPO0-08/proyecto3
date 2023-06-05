package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class UsuarioSesion {

	String usuario;
	String contrasenia;
	String documento;
	HashMap<Integer, Reserva> reservas;
	int UltimoId;
	
	public UsuarioSesion(String usuariop, String contraseniap, String documentop) {
		
		this.usuario = usuariop;
		this.contrasenia = contraseniap;	
		this.documento = documentop;
		UltimoId = 0;
	}
	
	
	@SuppressWarnings("removal")
	public void crearReserva(int id,Date fechai, Date fechaf, String nombre, ArrayList<Huesped> huespedes) {
		
		Reserva nuevaReserva = new Reserva(id, fechai, fechaf, nombre, huespedes);
		UltimoId = UltimoId+1;
		reservas.put((new Integer(UltimoId)),nuevaReserva);
	}
	
	
	public Reserva buscarReserva (int idBuscar) {
			
			@SuppressWarnings("removal")
			Reserva reservaBuscar = reservas.get((new Integer(idBuscar)));
			return reservaBuscar;
	}

	
	public String getUsuario() {
		return this.usuario;
	}
	
	public String getContrasenia() {
		return this.contrasenia;
	}
	
	public String getEdad() {
		return this.documento;
	}
}

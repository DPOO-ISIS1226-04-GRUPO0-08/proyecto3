package Model;

public class UsuarioSesion {

	String usuario;
	String contrasenia;
	String documento;
	
	public UsuarioSesion(String usuariop, String contraseniap, String documentop) {
		
		this.usuario = usuariop;
		this.contrasenia = contraseniap;	
		this.documento = documentop;
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

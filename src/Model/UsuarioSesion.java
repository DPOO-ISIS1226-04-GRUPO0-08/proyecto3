package Model;

public class UsuarioSesion {

	String usuario;
	String contrasenia;
	int edad;
	
	public UsuarioSesion(String usuariop, String contraseniap, String edads) {
		
		this.usuario = usuariop;
		this.contrasenia = contraseniap;	
		
		int edadint = Integer.parseInt(edads);
		this.edad = edadint;
	}

}

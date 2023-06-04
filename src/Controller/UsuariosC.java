package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import Model.UsuarioSesion;

public class UsuariosC {
	
	String nombreArchivoUsuarios = "datos\\usuarios.csv"; //C:\\Users\\Lenovo\\Desktop\\GitHub\\proyecto3\\datos\\usuarios.csv;
	HashMap<String,UsuarioSesion> mapaUsuarios;
	
	
	public UsuariosC() {
		cargarUsuarios();
	}
	
	
	public boolean confirmarUsuario(String nombreUsuario, String contrasenia) {
		
		return false;
	}
	
	
	
	private void cargarUsuarios() {
		String line = "";
		String splitComa = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivoUsuarios))) {
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] datos = line.split(splitComa);
				UsuarioSesion user = new UsuarioSesion(datos[0], datos[1], datos[2]);
				mapaUsuarios.put(datos[0], user);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

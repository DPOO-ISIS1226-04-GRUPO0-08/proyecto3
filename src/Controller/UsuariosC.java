package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import Model.UsuarioSesion;

public class UsuariosC {
	
	String nombreArchivoUsuarios = "datos\\usuarios.csv"; //C:\\Users\\Lenovo\\Desktop\\GitHub\\proyecto3\\datos\\usuarios.csv;
	HashMap<String,UsuarioSesion> mapaUsuarios;
	
	
	public UsuariosC() {
		
		mapaUsuarios = new HashMap<String,UsuarioSesion>(); 
		cargarUsuarios();	
		
	}
	
	
	
	public String confirmarUsuario(String nombreUsuario, String contrasenia) {
		
		UsuarioSesion usuarioBuscado = mapaUsuarios.get(nombreUsuario);
		String respuesta;
		
		if (usuarioBuscado != null) {
			
			if (contrasenia.equals(usuarioBuscado.getContrasenia())) {
				respuesta = "correcto";
				
			} else {
				respuesta = "contraseniaIncorrecta";
			}
			
		} else {
			respuesta =  "noUsuario";
		}
		
		return respuesta;
	}
	
	
	public void crearCuenta(String nombreUsuario, String contrasenia, int edad) throws IOException {
		String linea = nombreUsuario +","+ contrasenia +","+ edad;
		System.out.println("Sobreescribiendooo");
		BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivoUsuarios));
		writer.write(linea);
		
		/**
		PrintWriter printWriter = new PrintWriter(writer);
		
		printWriter.println(linea);
		printWriter.flush();
		printWriter.close();
		*/
	}

	
	private void cargarUsuarios() {
		
		String splitComa = ",";
		String line = "";
			try {
				BufferedReader br = new BufferedReader(new FileReader(nombreArchivoUsuarios));
				br.readLine();
				while ((line = br.readLine()) != null) {
					String[] datos = line.split(splitComa);
					UsuarioSesion user = new UsuarioSesion(datos[0], datos[1], datos[2]);
					mapaUsuarios.put(datos[0], user);
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
}

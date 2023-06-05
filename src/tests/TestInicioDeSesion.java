/**
 * En este test se prueba el inicio de sesion para las 
 * diferentes combinaciones de:
 * 
 * 1. usuario y contrasenia validos.
 * 2. usuario invalidos/sin cuenta.
 * 3. contrasenia incorrecta.
 */
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Controller.UsuariosC;


class TestInicioDeSesion {
	

    /**
     * Nombre, contrasenia y documento del usuario de prueba
     */
	private UsuariosC usuarios1;
    private String usuarioPrueba1;
    private String contraseniaPrueba1;
    private String documentoPrueba1;

    
    /**
     * Nombre, contrasenia y documento del usuario de prueba de contrasenia incorrecta
     */
    private UsuariosC usuarios2;
    private String usuarioPrueba2;
    private String contraseniaPrueba2;
    private String documentoPrueba2;
    private String contraseniaIncorrecta2;
    
    
    
    /**
     * Nombre, contrasenia y documento del usuario de prueba de usuario invalido
     */
    private UsuariosC usuarios3;
    private String usuarioPrueba3;
    private String contraseniaPrueba3;
    private String documentoPrueba3;
    private String usuarioInvalido3;
    
    
    
    /**
     * Ruta del documento de datos
     */
    private String rutaDocumento;
    
    
    
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
       
    /**
     * Escenario de una prueba de un inicio de sesion valido (1)
     */
    private void setupEscenario1( ) {
    	usuarioPrueba1 = "usuarioPrueba1";
    	contraseniaPrueba1 = "contraseniaPrueba1";
    	documentoPrueba1 = "1234567890";
        rutaDocumento = "datos\\usuarios.csv";
        
        try {
        	usuarios1 = new UsuariosC();
        	usuarios1.crearCuenta(usuarioPrueba1, contraseniaPrueba1, documentoPrueba1);
        	
		} catch (IOException e) {
			e.printStackTrace();
		}      
    }
	
	 /**
     * Prueba de un inicio de sesion valido (1)
     */
    @Test
    public void testInicioValido( )
    {
        // Configura el escenario de prueba 1
        setupEscenario1( );

        // Valida que el linea sea la adecuada
        assertEquals( "correcto", usuarios1.confirmarUsuario(usuarioPrueba1,contraseniaPrueba1) );
    }
    
    
    
    
    /**
     * Escenario de una prueba de un inicio de contrasenia incorrecta (2)
     */
    private void setupEscenario2( ) {
    	
    	usuarioPrueba2 = "usuarioPrueba2";
    	contraseniaPrueba2 = "contraseniaPrueba2";
    	documentoPrueba2 = "2345678901";
        rutaDocumento = "datos\\usuarios.csv";
        contraseniaIncorrecta2 = "contraseniaIncorrecta";
        
        try {
        	usuarios2 = new UsuariosC();
        	usuarios2.crearCuenta(usuarioPrueba2, contraseniaPrueba2, documentoPrueba2);
        	
		} catch (IOException e) {
			e.printStackTrace();
		}    
    }
	
	 /**
     * Prueba de un inicio de contrasenia incorrecta (1)
     */
    @Test
    public void testInicioContraseniaIncorrecta( )   {
    	
        // Configura el escenario de prueba 2
    	setupEscenario2( );
    	
        // Valida que el linea sea la adecuada
        assertEquals( "contraseniaIncorrecta", usuarios2.confirmarUsuario(usuarioPrueba2,contraseniaIncorrecta2) );
    }
    
    
    

    /**
     * Escenario de una prueba de un inicio de contrasenia incorrecta (2)
     */
    private void setupEscenario3( ) {
    	
    	usuarioPrueba3 = "usuarioPrueba3";
    	contraseniaPrueba3 = "contraseniaPrueba3";
    	documentoPrueba3 = "3456789012";
        rutaDocumento = "datos\\usuarios.csv";
        usuarioInvalido3 = "usuarioInvalido";
        
        try {
        	usuarios3 = new UsuariosC();
        	usuarios3.crearCuenta(usuarioPrueba3, contraseniaPrueba3, documentoPrueba3);
        	
		} catch (IOException e) {
			e.printStackTrace();
		}    
    }
	
	 /**
     * Prueba de un inicio de contrasenia incorrecta (1)
     */
    @Test
    public void testInicioUsuarioInvelido( )   {
    	
        // Configura el escenario de prueba 2
    	setupEscenario3( );
    	
        // Valida que el linea sea la adecuada
        assertEquals( "noUsuario", usuarios3.confirmarUsuario(usuarioInvalido3,contraseniaPrueba3) );
    }
    
}

package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import interfaz.interfazUsuario.*;

public class InterfazHotel extends JFrame {
	
	

	/**
	 * Nombre archivos:
	 * 
	 * platos:  datos\platos.csv 
	 * 
	 * habitaciones:  datos\habitaciones.csv
	 * 
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	 
	private PanelEleccionDePerfil panelEleccionPerfil;
	private PanelSuperior panelSuperior;
	
	private InterfazAdministrador interfazAdmin;
    private interfazEmpleado interfaz_Empleado;
    private interfazRecepcionista interfaz_Recepcionista;
    private InterfazUsuario interfazUsuario;
    
    private JScrollPane scroll;
    
    
	public InterfazHotel() throws IOException {
		
		setTitle( "Interfaz Hotel" );
        setSize( 700, 600 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLayout(new BorderLayout());
        
        
        panelSuperior = new PanelSuperior(this);
        this.add(panelSuperior, BorderLayout.NORTH);
        
        
		PanelEleccionDePerfil panelEleccionDePerfil = new PanelEleccionDePerfil(this);
		this.panelEleccionPerfil = panelEleccionDePerfil;
		this.add(panelEleccionPerfil, BorderLayout.CENTER);
		
		
		this.interfazAdmin = new InterfazAdministrador();
		this.interfaz_Empleado = new interfazEmpleado();
		this.interfaz_Recepcionista = new interfazRecepcionista();
		this.interfazUsuario = new InterfazUsuario();
		
		/**
		scroll = new JScrollPane(panelEleccionPerfil,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		System.out.println(getWidth());
		System.out.println(getHeight());
		scroll.setBounds(0, 0, getWidth(), getHeight());
		add(scroll);
		*/
	}
	
	



	
	
	public void abrirInterfazEmpleado() {
		this.panelEleccionPerfil.setVisible(false);
		this.interfaz_Empleado.setVisible(false);
		this.interfaz_Recepcionista.setVisible(false);
		this.interfazAdmin.setVisible(false);
		this.interfazUsuario.setVisible(false);
		
		this.add(interfaz_Empleado, BorderLayout.CENTER);
		this.interfaz_Empleado.setVisible(true);
	}
	
	
	public void abrirInterfazRecepcionista() {	
		this.panelEleccionPerfil.setVisible(false);
		this.interfaz_Empleado.setVisible(false);
		this.interfaz_Recepcionista.setVisible(false);
		this.interfazAdmin.setVisible(false);
		this.interfazUsuario.setVisible(false);
		
		this.add(interfaz_Recepcionista, BorderLayout.CENTER);
		this.interfaz_Recepcionista.setVisible(true);	
	}

	
	public void abrirInterfazAdministrador() {	
		this.panelEleccionPerfil.setVisible(false);
		this.interfaz_Empleado.setVisible(false);
		this.interfaz_Recepcionista.setVisible(false);
		this.interfazAdmin.setVisible(false);
		this.interfazUsuario.setVisible(false);
		
		this.add(interfazAdmin, BorderLayout.CENTER);
		this.interfazAdmin.setVisible(true);		
	}	
	
	
	public void abrirInterfazUsuario() {	
		this.panelEleccionPerfil.setVisible(false);
		this.interfaz_Empleado.setVisible(false);
		this.interfaz_Recepcionista.setVisible(false);
		this.interfazAdmin.setVisible(false);
		this.interfazUsuario.setVisible(false);
		
		this.add(interfazUsuario, BorderLayout.CENTER);
		this.interfazUsuario.setVisible(true);		
	}
	
		
	
	
	
	public static void main(String[] args) throws IOException { //throws IOException, ParseException {
		
		InterfazHotel interfaz = new InterfazHotel();
		interfaz.setVisible( true ); 
		
	}
	

}

package interfaz;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JDialog;
import javax.swing.JList;

import java.io.File;
import Controller.Inventario;
import Model.Huesped;

import javax.swing.*;

public class interfazRecepcionista extends JPanel {
	
	private PanelCrearReserva crearReserva;
	private PanelBuscarReservas buscarReserva;

	public interfazRecepcionista()
	{	
		/**
		setTitle("Recepcionista");
		setSize( 600, 700 );
		setLocationRelativeTo( null );
		setResizable( false );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		*/
		setLayout(new BorderLayout());
		
		crearReserva = new PanelCrearReserva();
		add(crearReserva , BorderLayout.CENTER);
		
		buscarReserva = new PanelBuscarReservas();
		add(buscarReserva, BorderLayout.SOUTH);
	}
}

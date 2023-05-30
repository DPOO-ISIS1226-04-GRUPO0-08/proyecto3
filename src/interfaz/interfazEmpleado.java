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

public class interfazEmpleado extends JPanel{
	
	private PanelCobroServicios reProductos;
	
	public interfazEmpleado() {
		/**
		setTitle("Empleado");
		setSize(600,700);
		setLocationRelativeTo( null );
		setResizable( false );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setLayout(new BorderLayout());
		*/
		
		reProductos = new PanelCobroServicios();
		add(reProductos);
	}
}

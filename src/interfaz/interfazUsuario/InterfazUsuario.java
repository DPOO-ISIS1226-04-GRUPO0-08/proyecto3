package interfaz.interfazUsuario;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JPanel;

import interfaz.PanelCrearReserva;

public class InterfazUsuario extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private PanelCrearReserva crearReserva;

	public InterfazUsuario() {


		setLayout(new BorderLayout());
		
		this.add(Box.createVerticalStrut(25), BorderLayout.NORTH);
		this.add(Box.createVerticalStrut(40), BorderLayout.SOUTH);
		this.add(Box.createHorizontalStrut(50), BorderLayout.EAST);
		this.add(Box.createHorizontalStrut(50), BorderLayout.WEST);
		
		crearReserva = new PanelCrearReserva();
		add(crearReserva , BorderLayout.CENTER);
	}

}

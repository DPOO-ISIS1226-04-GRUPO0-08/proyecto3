package interfaz.interfazUsuario;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaz.InterfazHotel;
import interfaz.PanelCrearReserva;

public class InterfazUsuario extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private InterfazHotel interfaz;
	
	
	private InicioUsuario panelInicioUsuario;
	

	public InterfazUsuario(InterfazHotel interfazp) {
		
		this.interfaz = interfazp;
		
		setLayout(new BorderLayout());
		
		panelInicioUsuario = new InicioUsuario(this);
		//this.panelInicioUsuario.setVisible(false);
		//this.add(new JLabel("- Holaa - "), BorderLayout.NORTH);
		this.add(panelInicioUsuario, BorderLayout.CENTER);
		//this.panelInicioUsuario.setVisible(true);
		
	}

	
	void iniciarSesion(String nombreUsuario, String contrasenia) {

	}
	
	
	public InterfazHotel getInterfazPrincipal() {
		return interfaz;
	}
	
	
}

package interfaz.interfazUsuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaz.InterfazHotel;
import interfaz.PanelBuscarReservas;
import interfaz.PanelCrearReserva;

public class InterfazUsuario extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private InterfazHotel interfaz;
	
	
	private InicioUsuario panelInicioUsuario;
	private JPanel panelcentral;
	private PanelCrearReserva panelCrearReservas;
	private PanelBuscarReservas buscarReservas;
	

	public InterfazUsuario(InterfazHotel interfazp) {
		
		this.interfaz = interfazp;
		
		setLayout(new BorderLayout());
		panelInicioUsuario = new InicioUsuario(this);
		this.add(panelInicioUsuario, BorderLayout.CENTER);
	}

	
	
	void iniciarSesion(String nombreUsuario, String contrasenia) {
		
		panelInicioUsuario.setVisible(false);
		
		this.setLayout(new BorderLayout());
		
		JPanel panelUsuarionLabel = new JPanel();
		panelUsuarionLabel.setLayout(new GridLayout(3,1));
		//panelUsuarionLabel.setBackground(new Color(126,152,151));
		JLabel lUsuario = new JLabel("Usuario:"); 
		lUsuario.setHorizontalAlignment(JLabel.CENTER);
		panelUsuarionLabel.add(Box.createVerticalStrut((int) (interfaz.getHeight()*0.01)));
		panelUsuarionLabel.add(lUsuario);
		panelUsuarionLabel.add(Box.createVerticalStrut((int) (interfaz.getHeight()*0.01)));
		
		this.add(panelUsuarionLabel, BorderLayout.NORTH);
		this.add(Box.createVerticalStrut((int) (interfaz.getHeight()*0.1)), BorderLayout.SOUTH);
		this.add(Box.createHorizontalStrut((int) (interfaz.getWidth()*0.1)), BorderLayout.EAST);
		this.add(Box.createHorizontalStrut((int) (interfaz.getWidth()*0.1)), BorderLayout.WEST);
		
		panelcentral = new JPanel();
		panelcentral.setLayout(new GridLayout(1,2,20,20));
		
		panelCrearReservas = new PanelCrearReserva();
		panelcentral.add(panelCrearReservas);
		
		buscarReservas = new PanelBuscarReservas();
		panelcentral.add(buscarReservas);
		
		this.add(panelcentral, BorderLayout.CENTER);
	}
	
	
	
	public InterfazHotel getInterfazPrincipal() {
		return interfaz;
	}
	
	
}

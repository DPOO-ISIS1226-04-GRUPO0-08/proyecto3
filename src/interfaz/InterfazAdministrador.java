package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class InterfazAdministrador extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private InterfazHotel principal;
	private JScrollPane scroll;
	private PanelCrearReserva creReservas;
	private PanelBuscarReservas busReservas;
	private PanelCobroServicios coServicios;
	private PanelAgregarPlato agPlato;
	
	public InterfazAdministrador() {
		
		TitledBorder border = new TitledBorder( "Interfaz Admin" );
        border.setTitleColor( Color.BLUE );
        setBorder( border );
		
		this.setLayout(new GridLayout(2,2,30,30));
		
		//this.add(new JLabel("Interfaz Admin"));
		
		this.setPreferredSize(new Dimension(700,1000));
		
		creReservas = new PanelCrearReserva();
		add(creReservas);
		
		busReservas = new PanelBuscarReservas();
		add(busReservas);
		
		coServicios = new PanelCobroServicios();
		add(coServicios);
		
		agPlato = new PanelAgregarPlato();
		add(agPlato);
	}

}

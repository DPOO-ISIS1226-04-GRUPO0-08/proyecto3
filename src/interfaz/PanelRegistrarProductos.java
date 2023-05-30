package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelRegistrarProductos extends JPanel implements ActionListener{
	
	
	private InterfazAdministrador principal;
	private JLabel servicio;
	private JComboBox combo;
	private JLabel id;
	private JTextField texto;
	private String[] tam = {"Spa","Tour","Restaurante"};
	
	
	
	
	public PanelRegistrarProductos(InterfazAdministrador principal) {

		this.principal = principal;
		
		setLayout( new GridLayout(3,2) );
		
		TitledBorder border = new TitledBorder( "Buscar reserva" );
		border.setTitleColor( Color.BLUE );
		setBorder( border );
		servicio = new JLabel("Servicio");
		add(servicio);
		combo = new JComboBox<String>(tam);
		add(combo);
		id = new JLabel("Id");
		add(id);
		texto = new JTextField();
		add(texto);
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

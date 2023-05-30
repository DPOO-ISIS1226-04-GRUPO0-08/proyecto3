package interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import Controller.Inventario;
import Model.Huesped;

@SuppressWarnings("serial")
public class PanelBuscarReservas extends JPanel implements ActionListener  {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	
	private interfazRecepcionista principal;
	private JLabel id;
	private JTextField idd;
	private JButton buscar;
	private Inventario inventario;
	
	
	public PanelBuscarReservas() {

		
		
		setLayout( new GridLayout(4,1,3,30) );

		TitledBorder border = new TitledBorder( "Buscar reserva" );
        border.setTitleColor( Color.BLUE );
        setBorder( border );
        id = new JLabel("ID");
        add(id);
        idd = new JTextField();
        add(idd);
        buscar = new JButton("Buscar");
        buscar.addActionListener(this);
        add(buscar);
        
        
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == buscar) {
			System.out.println("Buscando Reservas");
			JOptionPane.showMessageDialog(this, "Reserva encontrada");
			
			inventario.consultarReserva(Integer.parseInt(idd.getText()));

		
		}
	}

}

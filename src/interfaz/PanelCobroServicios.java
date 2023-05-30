package interfaz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.GridLayout;

import javax.swing.border.TitledBorder;

public class PanelCobroServicios extends JPanel implements ActionListener{
	
	private interfazEmpleado principal;
	private JLabel servicio;
	private JTextField servicioo;
	private JLabel nombreAdmin;
	private JTextField amin;
	private JLabel huesped;
	private JTextField nhuesped;
	
	private JButton pagar;
	

	public PanelCobroServicios()  {
		// TODO Auto-generated constructor stub
		
		setLayout( new GridLayout(4,2) );
		
		TitledBorder border = new TitledBorder( "Cobrar Servicio" );
		border.setTitleColor( Color.BLUE );
		setBorder( border );
		
		nombreAdmin = new JLabel("Principal");
		add(nombreAdmin);
		
		amin = new JTextField();
		add(amin);
		
		servicio = new JLabel("Servicio");
		add(servicio);
		
		servicioo = new JTextField();
		add(servicioo);
		
		huesped = new JLabel("Huesped(opcional)");
		add(huesped);
		nhuesped = new JTextField();
		add(nhuesped);
		
		pagar = new JButton("pagar");
		pagar.addActionListener(this);
		add(pagar);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == pagar) {
			System.out.println("Servicio pagado");
			
			JOptionPane.showMessageDialog(this, "Servicio cobrado");
		}
	}

}

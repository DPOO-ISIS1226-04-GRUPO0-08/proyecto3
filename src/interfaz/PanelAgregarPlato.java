package interfaz;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelAgregarPlato extends JPanel implements ActionListener {

	private JLabel nombre;
	private JLabel precio;
	private JLabel cuarto;
	private JTextField nomm;
	private JTextField pre;
	private JRadioButton si;
	private JRadioButton no;
	
	private JButton agregar;

	public PanelAgregarPlato() {
		// TODO Auto-generated constructor stub
		TitledBorder border = new TitledBorder( "Agregar plato" );
        border.setTitleColor( Color.BLUE );
        setBorder( border );
        
		setLayout( new GridLayout(4,3,5,5) );
		nombre = new JLabel("Nombre");
		add(nombre);
		nomm = new JTextField();
		add(nomm);
		add(new JLabel(" "));
		precio = new JLabel("Precio");
		add(precio);
		pre = new JTextField();
		add(pre);
		add(new JLabel(" "));
		
		cuarto = new JLabel("Llevar a cuarto");
		add(cuarto);
		si = new JRadioButton("si");
		add(si);
		no = new JRadioButton("no");
		add(no);
		
		agregar = new JButton("Agregar");
		add(agregar);
		agregar.addActionListener(this);
		
	}
	

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == agregar) {
			
			System.out.println("Agregando plato");
			
			JOptionPane.showMessageDialog(this, "Plato agregado" );
			
		
		}
	}

}

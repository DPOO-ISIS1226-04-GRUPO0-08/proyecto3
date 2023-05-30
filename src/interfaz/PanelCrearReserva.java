package interfaz;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.io.File;
import Controller.Inventario;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;

import Model.Huesped;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelCrearReserva extends JPanel implements ActionListener{
	
	private interfazRecepcionista principal;
	private Inventario inventario;
	private JLabel nombre;
	private JLabel llegada;
	private JLabel salida;
	private JLabel numeroIndividuos;
	private JTextField nnombre;
	private JTextField lllegada;
	private JTextField ssalida;
	private JTextField ni;
	private JButton crear;

	public PanelCrearReserva()  {
		// TODO Auto-generated constructor stub
		
		TitledBorder border = new TitledBorder( "Crear Reserva" );
        border.setTitleColor( Color.BLUE );
        setBorder( border );
        
		this.principal = principal;
		setLayout(new GridLayout(5,2));
		this.nombre = new JLabel("Nombre");
		this.llegada = new JLabel("Llegada");
		this.salida = new JLabel("Salida");
		this.numeroIndividuos = new JLabel("# invitados");
		this.nnombre = new JTextField();
		this.lllegada = new JTextField();
		this.ssalida = new JTextField();
		this.ni = new JTextField();
		add(nombre);
		add(nnombre);
		add(llegada);
		add(lllegada);
		add(salida);
		add(ssalida);
		add(numeroIndividuos);
		add(ni);
		this.crear = new JButton("Crear");
		
		add(crear);
		crear.addActionListener(this);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
		
		if(e.getSource() == crear) {
			
			System.out.println("Recerva creada");
			
			JOptionPane.showMessageDialog(this, "Tu id es: " + "01" + "\nReserva cargada");
			
			int n = inventario.cargarReserva(fechas(lllegada.getText()), fechas(ssalida.getText()), nnombre.getText(), new ArrayList<Huesped>());
			
			JOptionPane.showMessageDialog(this, "Tu id es: " + n + "\nReserva cargada");
			
		}
		}catch(Exception i) {
			
		}
		
	}
	
	
	public Date fechas(String fecha) throws ParseException{
		

			DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			Date date = formateador.parse(fecha);
			return date;
		
	}
	
	
	

}

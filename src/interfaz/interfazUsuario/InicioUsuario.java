package interfaz.interfazUsuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaz.InterfazHotel;

public class InicioUsuario extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private InterfazHotel interfaz;
	private JButton btnIngresar;
	private JButton btnCrearCuenta;
	private JLabel lLogin;
	private JLabel lUsuario;
	private JLabel lContrasenia;
	
	public InicioUsuario(InterfazHotel interfazp) {
		
		this.interfaz = interfazp;
		
		this.setLayout(new BorderLayout());
		this.add(Box.createVerticalStrut((int) (interfaz.getHeight()*0.1)), BorderLayout.NORTH);
		this.add(Box.createVerticalStrut((int) (interfaz.getHeight()*0.1)), BorderLayout.SOUTH);
		this.add(Box.createHorizontalStrut((int) (interfaz.getWidth()*0.1)), BorderLayout.EAST);
		this.add(Box.createHorizontalStrut((int) (interfaz.getWidth()*0.1)), BorderLayout.WEST);
		
		this.setBackground(Color.LIGHT_GRAY);
		
		
		
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new BorderLayout());
		panelCentral.setBackground(new Color(0, 139, 139));
		//this.setBounds(100, 100, 200, 300);

		lLogin = new JLabel("- LOGIN - ");
		lLogin.setHorizontalAlignment(JLabel.CENTER);
		panelCentral.add(lLogin, BorderLayout.NORTH);
		
		
		JPanel panelFunciones = new JPanel();
		panelFunciones.setLayout(new GridLayout(5,1,40,20));
		
		JPanel panelFunciones = new JPanel();
		
		
		this.add(panelCentral,BorderLayout.CENTER);
		
		/**
		//panelBotones.add(Box.createHorizontalStrut(25));
		btnEmpleado = new JButton("Empleado");
		btnEmpleado.setBounds(0,0,100,200);
		panelBotones.add(btnEmpleado);
		btnEmpleado.addActionListener(this);
		
		btnRecepcionista = new JButton("Recepcionista");
		btnRecepcionista.setBounds(0,0,100,100);
		panelBotones.add(btnRecepcionista);
		btnRecepcionista.addActionListener(this);
		
		btnAdministrados = new JButton("Administrador");
		btnAdministrados.setBounds(0,0,100,100);
		panelBotones.add(btnAdministrados);
		btnAdministrados.addActionListener(this);
		
		btnUsuario = new JButton("Usuario");
		btnUsuario.setBounds(0,0,100,100);
		panelBotones.add(btnUsuario);
		btnUsuario.addActionListener(this);
		//panelBotones.add(Box.createHorizontalStrut(25));
		
		this.add(panelBotones, BorderLayout.CENTER);
		 */
		
		this.validate();
		
	}

}

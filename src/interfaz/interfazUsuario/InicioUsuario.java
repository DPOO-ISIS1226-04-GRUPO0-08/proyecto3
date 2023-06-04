package interfaz.interfazUsuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Controller.UsuariosC;
import Model.Huesped;
import interfaz.InterfazHotel;

public class InicioUsuario extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private InterfazUsuario interfazUsuario;
	private JButton btnIngresar;
	private JButton btnCrearCuenta;
	private JLabel lLogin;
	private JLabel lUsuario;
	private JLabel lContrasenia;
	private JTextField tUsuario;
	private JTextField tContrasenia;
	
	private UsuariosC usuarios;
	
	public InicioUsuario(InterfazUsuario interfazp) {
		
		this.interfazUsuario = interfazUsuariop;
		
		this.setLayout(new BorderLayout());
		this.add(Box.createVerticalStrut((int) (interfazUsuario.getHeight()*0.1)), BorderLayout.NORTH);
		this.add(Box.createVerticalStrut((int) (interfazUsuario.getHeight()*0.1)), BorderLayout.SOUTH);
		this.add(Box.createHorizontalStrut((int) (interfazUsuario.getWidth()*0.1)), BorderLayout.EAST);
		this.add(Box.createHorizontalStrut((int) (interfazUsuario.getWidth()*0.1)), BorderLayout.WEST);
		
		this.setBackground(new Color(213,213,230));
		//this.setBackground(Color.LIGHT_GRAY);
		
		
		
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new BorderLayout());
		panelCentral.setBackground(new Color(126,152,151));

		
		panelCentral.add(Box.createVerticalStrut((int) (interfazUsuario.getHeight()*0.05)), BorderLayout.NORTH);
		panelCentral.add(Box.createVerticalStrut((int) (interfazUsuario.getHeight()*0.05)), BorderLayout.SOUTH);
		panelCentral.add(Box.createHorizontalStrut((int) (interfazUsuario.getWidth()*0.05)), BorderLayout.EAST);
		panelCentral.add(Box.createHorizontalStrut((int) (interfazUsuario.getWidth()*0.05)), BorderLayout.WEST);
		
		JPanel panelFunciones = new JPanel();
		panelFunciones.setLayout(new GridLayout(5,1,20,20));
		panelFunciones.setBackground(new Color(126,152,151));
		
		lLogin = new JLabel("- LOGIN - ");
		lLogin.setHorizontalAlignment(JLabel.CENTER);
		panelFunciones.add(lLogin);
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(new GridLayout(1,2));
		panelUsuario.setBackground(new Color(126,152,151));
		lUsuario = new JLabel("Usuario:");
		lUsuario.setHorizontalAlignment(JLabel.CENTER);
		panelUsuario.add(lUsuario);
		tUsuario = new JTextField();
		panelUsuario.add(tUsuario);
		panelFunciones.add(panelUsuario);
		
		JPanel panelContrasenia = new JPanel();
		panelContrasenia.setLayout(new GridLayout(1,2));
		panelContrasenia.setBackground(new Color(126,152,151));
		lContrasenia = new JLabel("Contraseña:");
		lContrasenia.setHorizontalAlignment(JLabel.CENTER);
		panelContrasenia.add(lContrasenia);
		tContrasenia = new JTextField();
		panelContrasenia.add(tContrasenia);
		panelFunciones.add(panelContrasenia);
		
		btnIngresar = new JButton("Iniciar sesion");
		btnIngresar.addActionListener(this);
		panelFunciones.add(btnIngresar);
		
		btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.addActionListener(this);
		panelFunciones.add(btnCrearCuenta);
		
		
		panelCentral.add(panelFunciones, BorderLayout.CENTER);
		
		this.add(panelCentral,BorderLayout.CENTER);
		

		this.validate();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnIngresar) {
			
			usuarios.confirmarUsuario(tUsuario.getText(),tContrasenia.getText());
			System.out.println("Iniciando sesion");
			interfazUsuario.iniciarSesion(tUsuario.getText(),tContrasenia.getText());
			
			JOptionPane.showMessageDialog(this, "Tu id es: " + "01" + "\nReserva cargada");
			
			int n = inventario.cargarReserva(fechas(lllegada.getText()), fechas(ssalida.getText()), nnombre.getText(), new ArrayList<Huesped>());
			
			JOptionPane.showMessageDialog(this, "Tu id es: " + n + "\nReserva cargada");
			
		} else if(e.getSource() == btnCrearCuenta) {
			
		} 
		
	}

}

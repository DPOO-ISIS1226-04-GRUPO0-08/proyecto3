package interfaz.interfazUsuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
	private JLabel lCrearCuenta;
	private JTextField tUsuario;
	private JTextField tContrasenia;
	
	private UsuariosC usuarios;
	
	JPanel panelCentral;
	JPanel panelFunciones;
	
	JPanel panerCrearReserva;
	JPanel panelFuncionescrear;
	private JTextField tUsuarioCrear;
	private JTextField tContraseniaCrear;
	private JTextField tEdadCrear;
	private JButton btnCrearCuenta2;

	
	public InicioUsuario(InterfazUsuario interfazUsuariop) {
		
		usuarios = new UsuariosC();	

		this.interfazUsuario = interfazUsuariop;
		
		crearPanelCrearReservas(); 
		
		this.setLayout(new BorderLayout());
		this.add(Box.createVerticalStrut((int) (interfazUsuario.getInterfazPrincipal().getHeight()*0.1)), BorderLayout.NORTH);
		this.add(Box.createVerticalStrut((int) (interfazUsuario.getInterfazPrincipal().getHeight()*0.1)), BorderLayout.SOUTH);
		this.add(Box.createHorizontalStrut((int) (interfazUsuario.getInterfazPrincipal().getWidth()*0.1)), BorderLayout.EAST);
		this.add(Box.createHorizontalStrut((int) (interfazUsuario.getInterfazPrincipal().getWidth()*0.1)), BorderLayout.WEST);
		
		this.setBackground(new Color(213,213,230));

		
		panelCentral = new JPanel();
		panelCentral.setLayout(new BorderLayout());
		panelCentral.setBackground(new Color(126,152,151));

		panelCentral.add(Box.createVerticalStrut((int) (interfazUsuario.getInterfazPrincipal().getHeight()*0.05)), BorderLayout.NORTH);
		panelCentral.add(Box.createVerticalStrut((int) (interfazUsuario.getInterfazPrincipal().getHeight()*0.05)), BorderLayout.SOUTH);
		panelCentral.add(Box.createHorizontalStrut((int) (interfazUsuario.getInterfazPrincipal().getWidth()*0.05)), BorderLayout.EAST);
		panelCentral.add(Box.createHorizontalStrut((int) (interfazUsuario.getInterfazPrincipal().getWidth()*0.05)), BorderLayout.WEST);

		panelFunciones = new JPanel();
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

	
	private void crearPanelCrearReservas(){
		panerCrearReserva = new JPanel();
		
		panerCrearReserva = new JPanel();
		panerCrearReserva.setLayout(new BorderLayout());
		panerCrearReserva.setBackground(new Color(126,152,151));

		panerCrearReserva.add(Box.createVerticalStrut((int) (interfazUsuario.getInterfazPrincipal().getHeight()*0.05)), BorderLayout.NORTH);
		panerCrearReserva.add(Box.createVerticalStrut((int) (interfazUsuario.getInterfazPrincipal().getHeight()*0.05)), BorderLayout.SOUTH);
		panerCrearReserva.add(Box.createHorizontalStrut((int) (interfazUsuario.getInterfazPrincipal().getWidth()*0.05)), BorderLayout.EAST);
		panerCrearReserva.add(Box.createHorizontalStrut((int) (interfazUsuario.getInterfazPrincipal().getWidth()*0.05)), BorderLayout.WEST);

		panelFuncionescrear = new JPanel();
		panelFuncionescrear.setLayout(new GridLayout(5,1,20,20));
		panelFuncionescrear.setBackground(new Color(126,152,151));
		
		lCrearCuenta = new JLabel("- Crear Cuenta - ");
		lCrearCuenta.setHorizontalAlignment(JLabel.CENTER);
		panelFuncionescrear.add(lCrearCuenta);
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(new GridLayout(1,2));
		panelUsuario.setBackground(new Color(126,152,151));
		JLabel lUsuarioCrear = new JLabel("Escriba su usuario:");
		lUsuarioCrear.setHorizontalAlignment(JLabel.CENTER);
		panelUsuario.add(lUsuarioCrear);
		tUsuarioCrear = new JTextField();
		panelUsuario.add(tUsuarioCrear);
		panelFuncionescrear.add(panelUsuario);
		
		JPanel panelContrasenia = new JPanel();
		panelContrasenia.setLayout(new GridLayout(1,2));
		panelContrasenia.setBackground(new Color(126,152,151));
		JLabel lContraseniaCrear = new JLabel("Escriba la contrasenia:");
		lContraseniaCrear.setHorizontalAlignment(JLabel.CENTER);
		panelContrasenia.add(lContraseniaCrear);
		tContraseniaCrear = new JTextField();
		panelContrasenia.add(tContraseniaCrear);
		panelFuncionescrear.add(panelContrasenia);
		 
		JPanel panelEdadCrear = new JPanel();
		panelEdadCrear.setLayout(new GridLayout(1,2));
		panelEdadCrear.setBackground(new Color(126,152,151));
		JLabel lEdadCrear = new JLabel("Escriba su edad:");
		lEdadCrear.setHorizontalAlignment(JLabel.CENTER);
		panelEdadCrear.add(lEdadCrear);
		tEdadCrear = new JTextField();
		panelEdadCrear.add(tEdadCrear);
		panelFuncionescrear.add(panelEdadCrear);		
		
		btnCrearCuenta2 = new JButton("Crear cuenta");
		btnCrearCuenta2.addActionListener(this);
		panelFuncionescrear.add(btnCrearCuenta2);
		
		panerCrearReserva.add(panelFuncionescrear, BorderLayout.CENTER);
		this.add(panerCrearReserva, BorderLayout.CENTER);
		panerCrearReserva.setVisible(false);
	}
	
	
	
	private void crearCuenta() {
		panelCentral.setVisible(false);
		this.add(panerCrearReserva, BorderLayout.CENTER);
		panerCrearReserva.setVisible(true);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnIngresar) {
			
			String respuesta = usuarios.confirmarUsuario(tUsuario.getText(),tContrasenia.getText());
			
			if (respuesta.equals("correcto")) {
				System.out.println("Iniciando sesion");
				interfazUsuario.iniciarSesion(tUsuario.getText(),tContrasenia.getText());
				
			} else if  (respuesta.equals("contraseniaIncorrecta")) {
				System.out.println("contrasenia Incorrecta");
				JOptionPane.showMessageDialog(this, "Contrasenia Incorrecta");

			
			} else if  (respuesta.equals("noUsuario")) {
				System.out.println("no Usuario");
				JOptionPane.showMessageDialog(this, "Usuario no encontrado");
			}
			

		} else if(e.getSource() == btnCrearCuenta) {
			System.out.println("Crear cuenta");
			crearCuenta();

		} else if(e.getSource() == btnCrearCuenta2) {
			try {
				panerCrearReserva.setVisible(false);
				this.add(panerCrearReserva, BorderLayout.CENTER);
				panelCentral.setVisible(true);
				
				int edad = Integer.parseInt(tEdadCrear.getText());
				usuarios.crearCuenta(tUsuarioCrear.getText(),tContraseniaCrear.getText(),edad);
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		} 
	}

}

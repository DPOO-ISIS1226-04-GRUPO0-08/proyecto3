package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelEleccionDePerfil extends JPanel implements ActionListener{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private InterfazHotel interfaz;
	private JButton btnEmpleado;
	private JButton btnRecepcionista;
	private JButton btnAdministrados;
	private JButton btnUsuario;
	private JLabel titulo;
	
	
	
	public PanelEleccionDePerfil(InterfazHotel interfazp) {
		this.interfaz = interfazp;
		
		this.setLayout(new BorderLayout());
		this.add(Box.createVerticalStrut((int) (interfaz.getHeight()*0.1)), BorderLayout.NORTH);
		this.add(Box.createVerticalStrut((int) (interfaz.getHeight()*0.1)), BorderLayout.SOUTH);
		this.add(Box.createHorizontalStrut((int) (interfaz.getWidth()*0.1)), BorderLayout.EAST);
		this.add(Box.createHorizontalStrut((int) (interfaz.getWidth()*0.1)), BorderLayout.WEST);;
		
		this.setBackground(new Color(213,213,230));
		//this.setBackground(Color.LIGHT_GRAY);
		
		
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(5,1,40,20));
		panelBotones.setOpaque(false);
		//this.setBounds(100, 100, 200, 300);
		
		titulo = new JLabel("- Selecciones el perfil al que quiere ingresar - ");
		panelBotones.add(titulo);
		
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

		this.validate();

	}



	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnEmpleado) {
			System.out.println("Abriendo perfil de Empleado");
			interfaz.abrirInterfazEmpleado();
				
		} else if (e.getSource() == btnRecepcionista) {
			System.out.println("Abriendo perfil de recepcionista");
			interfaz.abrirInterfazRecepcionista();
		
		} else if (e.getSource() == btnAdministrados) {
			System.out.println("Abriendo perfil de Administrador");
			interfaz.abrirInterfazAdministrador();
		
		} else if (e.getSource() == btnUsuario) {
			System.out.println("Abriendo perfil de Administrador");
			interfaz.abrirInterfazUsuario();
		}
		
	}

	
}

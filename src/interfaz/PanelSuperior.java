package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSuperior extends JPanel implements ActionListener{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private InterfazHotel principal;
	private PanelCabecera panelImagen;
	private String[] listaPerfilesTxt = {"Empleado", "Recepcionista", "Administrador", "Usuario"};
	private JComboBox listaPerfiles;
	
	
	@SuppressWarnings("unchecked")
	public PanelSuperior(InterfazHotel principal) throws IOException {
		
		this.principal = principal;  
		
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(62, 33, 79));
        
        JPanel panelIn1 = new JPanel();
        panelIn1.setLayout(new BorderLayout());
        panelIn1.setOpaque( false );
        panelIn1.add(Box.createVerticalStrut(15), BorderLayout.NORTH);
        panelIn1.add(Box.createVerticalStrut(40), BorderLayout.SOUTH);
        panelIn1.add(Box.createHorizontalStrut(25), BorderLayout.EAST);
		
        JPanel panelIn2 = new JPanel();
        panelIn2.setLayout(new GridLayout(2,1,5,5));
        panelIn2.setOpaque( false );
        
        JLabel seleccion1 = new JLabel("Cambie el usuario");
        seleccion1.setForeground(Color.WHITE);
        panelIn2.add(seleccion1);
        
        listaPerfiles = new JComboBox<String>(listaPerfilesTxt);
        listaPerfiles.addActionListener(this);
        
        panelIn2.add(listaPerfiles);
        
        panelIn1.add(panelIn2, BorderLayout.CENTER);
        
        panelImagen = new PanelCabecera(this);
        this.add(panelImagen, BorderLayout.CENTER);
        this.add(panelIn1, BorderLayout.EAST);


	}

 
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cargo = null;
		
		if (e.getSource() == listaPerfiles) {
			cargo = listaPerfiles.getSelectedItem().toString();
			System.out.println("Pantalla se cambiara a -> "+ cargo);
			

			if (cargo.equals("Empleado")) {
				System.out.println("Abriendo perfil de Empleado");
				principal.abrirInterfazEmpleado();
				
			} else if (cargo.equals("Recepcionista")) {
				System.out.println("Abriendo perfil de recepcionista");
				principal.abrirInterfazRecepcionista();
			
			} else if (cargo.equals("Administrador")){
				System.out.println("Abriendo perfil de Administrador");
				principal.abrirInterfazAdministrador();
			
			} else if (cargo.equals("Usuario")){
				System.out.println("Abriendo perfil de Usuario");
				principal.abrirInterfazUsuario();
			}
			
		} 
		
		
	}

}

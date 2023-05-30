package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelCabecera extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PanelSuperior superior;
	
	public final static String RUTA_IMAGEN_CABEZERA = "./datos/logoCabecera.jpg";
    private BufferedImage imagenCabezera;
   
    
    
    
    public PanelCabecera(PanelSuperior superior) throws IOException {
    	
    	this.superior = superior;  
    	
    	imagenCabezera = ImageIO.read(new File(RUTA_IMAGEN_CABEZERA));
    	
    	setPreferredSize( new Dimension( imagenCabezera.getWidth( ), imagenCabezera.getHeight( )/2));
    	setOpaque( false );
        
		repaint();
    }

    



	public void paint( Graphics g )
    {
    	Graphics2D g2d = (Graphics2D) g;
    	g2d.drawImage( imagenCabezera, 0, 0, getWidth(), getHeight(), null, this );
    }
		


		
}

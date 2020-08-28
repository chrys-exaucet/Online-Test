package views.gui.teachers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelImageTeacher extends JPanel
{
	 private BufferedImage image ;
	    
	    public PanelImageTeacher (){
	        try{
	        image = ImageIO.read( PanelImageTeacher.class.getResource("/Blank.jpg") );
	        
	        
	    }
	   catch ( IOException e ){

	    e.printStackTrace();
	    }
	    }
	    protected void paintComponent( Graphics g ){

	        super.paintComponent(g);

	        g.drawImage( image, 0, 0, getWidth(), getHeight(), null );
	    }
}
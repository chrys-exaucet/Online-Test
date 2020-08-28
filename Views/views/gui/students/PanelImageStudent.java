package views.gui.students;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelImageStudent extends JPanel
{
	 private BufferedImage image ;
	    
	    public PanelImageStudent (){
	        try{
	        image = ImageIO.read( PanelImageStudent.class.getResource("/StudentQuest.jpg") );
	        
	        
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

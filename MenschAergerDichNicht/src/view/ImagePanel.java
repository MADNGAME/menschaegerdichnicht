package view;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controller.Controller;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel{
	
	
	private BufferedImage image;
	
	public ImagePanel(Controller c) {
		try {
			image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("SpielBrett.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}	

/** Header comment needed! */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GameState 
{
	// Fields
	
	private Path path;
	private BufferedImage background;
	
	private double squareAngle;
	
	/* Contracts needed! */
	
	// Constructor
	
	public GameState ()
	{
		System.out.println("GameState constructor");
		
		// Build our path
		
		path = new Path();
		
		// Load the background jpg
		
		try
		{
			ClassLoader loader = this.getClass().getClassLoader();
			InputStream is = loader.getResourceAsStream("resources/path_2.jpg");
			background = javax.imageio.ImageIO.read(is);
		}
		catch (IOException e)
		{
			System.out.println("Unable to load background.");
		}
	}

	// Function to return a path object
	
	public Path getPath ()
	{
		return path;
	}
	
	// Function to draw everything
	
	public void drawAll(Graphics g)
	{
		// Draw the background
		
		g.drawImage(background, 0, 0, null);
		
		// Draw the path
		
		// Draw the ball		
	}	
}

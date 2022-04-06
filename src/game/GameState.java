/** Header comment needed! */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class GameState 
{
	// Fields
	
	private Path path;
	private BufferedImage background;
	private double percentTraveled;
	
	private double squareAngle;
	
	/* Contracts needed! */
	
	// Constructor
	
	public GameState () 
	{
		System.out.println("GameState constructor");
		
		//Create scanner to read path file. 


		try {
			Scanner fileReader = new Scanner(new File("src/resources/path.txt"));

			// Build our path
		
			path = new Path(fileReader);

		} catch (Exception e) {

			System.out.println("The path file reader is messed up. Please fix the problem.");

		}
		
		
		// Load the background jpg
		
		try
		{
			ClassLoader loader = this.getClass().getClassLoader();
			InputStream is = loader.getResourceAsStream("resources/mapOne.jpg");
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
		
		path.drawPath(g);

		// Draw the ball
		
		path.locatePosition(percentTraveled);
	}	

	public void updateAll()
	{
		percentTraveled += .01;
	}
}

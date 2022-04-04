/** Header comment needed! */
package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.Graphics;
import java.awt.Color;

public class Path 
{
	/* Contracts needed */
	
	// Fields to store the path and its length

	private static int[] xArray;

	private static int[] yArray;
	
	// Constructor - loads the path from the file


	/** This constructor does the following:  
     *     - It reads a number of coordinates, n, from the scanner. 
     *     - It creates new array(s) (or an ArrayList) to hold the path coordinates,
     *          and stores it in the field in 'this' object.
     *     - It loops n times, each time scanning a coordinate x,y pair, creating an
     *         object to represent the coordinate (if needed), and stores the coordinate
     *         in the array(s) or ArrayList.
     * 
     * @param s  a Scanner set up by the caller to provide a list of coordinates
     */
	public Path(Scanner fileReader) {	

		
		
			

			// Store those points in to the fields
				// Read the first line of the array file to find out how many spaces you need in the array

				int arrayLength = fileReader.nextInt();

				// Fill the array

				this.xArray = new int[arrayLength]; 
				this.yArray = new int[arrayLength]; 

				System.out.println("The empty x coordinate array looks like this:      " + Arrays.toString(xArray));				// TESTING LINE - prints out the x array for debugging
				System.out.println("The empty y coordinate array looks like this:      " + Arrays.toString(yArray));				// TESTING LINE - prints out the y array for debugging

				for (int index = 0; index < arrayLength; index++) {

					xArray[index] = fileReader.nextInt();
					yArray[index] = fileReader.nextInt();
					
				}

				System.out.println("The filled x coordinate array looks like this:      " + Arrays.toString(xArray));				// TESTING LINE - prints out the x array for debugging
				System.out.println("The filled y coordinate array looks like this:      " + Arrays.toString(yArray));				// TESTING LINE - prints out the y array for debugging

		
	}
	
	// Draw path - takes a Graphics object parameter and draws the path

	/**
      * Draws the current path to the screen (to wherever the graphics object points)
      * using a highly-visible color.
      * 
      * @param g   a graphics object
      */  

	  public static void drawPath(Graphics turtleArtist) {

		for (int index = 0; index < xArray.length - 1; index++) {

			turtleArtist.setColor(Color.RED);
			turtleArtist.drawLine(xArray[index], yArray[index], xArray[index + 1], yArray[index + 1]);

		}

	  }

	// Locate - takes a percentage p and returns a Point (x,y) of where percentage p is on the path

	/** 
	 * Given a percentage between 0% and 100%, this method calculates
	 * the location along the path that is exactly this percentage
	 * along the path. The location is returned in a Point object
	 * (integer x and y), and the location is a screen coordinate.
	 * 
	 * If the percentage is less than 0%, the starting position is
	 * returned. If the percentage is greater than 100%, the final
	 * position is returned.
	 * 
	 * If students don't want to use Point objects, they may 
	 * write or use another object to represent coordinates. 
	 *
	 * Caution: Students should never directly return a Point object
	 * from a path list. It could be changed by the outside caller.
	 * Instead, always create and return a new point objects as
	 * the result from this method.
	 * 
	 * @param percentTraveled a distance along the path
	 * @return the screen coordinate of this position along the path
	 */
	public Point locatePosition (double percentTraveled) {


		
	}
	
}

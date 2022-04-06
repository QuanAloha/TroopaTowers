/** Header comment needed! */
package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

public class Path 
{
	/* Contracts needed */
	
	// Fields to store the path and its length

	private int[] xArray;

	private int[] yArray;

	private double totalPathLength;

	private double[] segmentLengths;
	
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

			System.out.println("Loading new path into path object.......");
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

				// Find the total length of the path
				try {
					// Get 2 different points

					// Use different scanners to keep track of the right points. 
					Scanner xPointReader = new Scanner(new File("src/resources/path.txt"));
					Scanner yPointReader = new Scanner(new File("src/resources/path.txt"));
					Scanner xTwoPointReader = new Scanner(new File("src/resources/path.txt"));
					Scanner yTwoPointReader = new Scanner(new File("src/resources/path.txt"));
					// Set the scanners to the right spots in the txt file. 
					xPointReader.nextInt();
		
					yPointReader.nextInt();
					yPointReader.nextInt();
		
					xTwoPointReader.nextInt();
					xTwoPointReader.nextInt();
					xTwoPointReader.nextInt();
		
					yTwoPointReader.nextInt();
					yTwoPointReader.nextInt();
					yTwoPointReader.nextInt();
					yTwoPointReader.nextInt();
				// Calculate the difference between them using the pythagoran theorem. sqrt(deltay^2+deltax^2)
					double totalLength = 0.0;
					int segmentsCalculated = 0;

					// While your at it, fill in your segment length array. 
					Scanner numberOfSegmentsScanner = new Scanner( new File("src/resources/path.txt"));
					segmentLengths = new double[numberOfSegmentsScanner.nextInt() - 1];
		
					while (yTwoPointReader.hasNext())  {
		
						int yOne = yPointReader.nextInt();
								   if (yPointReader.hasNext()) yPointReader.nextInt();
						int yTwo = yTwoPointReader.nextInt();
								   if (yTwoPointReader.hasNext()) yTwoPointReader.nextInt();
						int xOne = xPointReader.nextInt();
								   if (xPointReader.hasNext()) xPointReader.nextInt();
						int xTwo = xTwoPointReader.nextInt();
								   if (xTwoPointReader.hasNext()) xTwoPointReader.nextInt();
		
						double lengthToAdd = Math.sqrt(  ( (yTwo - yOne) * (yTwo - yOne) )
													  +  ( (xTwo - xOne) * (xTwo - xOne) ) );

						segmentLengths[segmentsCalculated] = lengthToAdd;
		
						// Add the segments together to compute the total path length
						totalLength += lengthToAdd;
						segmentsCalculated ++;
		
						System.out.println("Points used for calculation:     " + yOne + "     " + yTwo + "     " + xOne + "     " + xTwo +  
											"     Segment Length:   " + lengthToAdd + "     Segments Calculated: " + segmentsCalculated);      // TESTING LINE - prints out the segment calculations
					}
					
					System.out.println("The total calculated length is:     " + totalLength);           // TESTING LINE - Prints out total path length
					System.out.println("The lengths of each segment are stored in the following array:   " + Arrays.toString(segmentLengths));

					this.totalPathLength = totalLength;
						
				} catch (IOException e) {
		
						System.out.println("There was a problem reading the points to calculate total path length.");
		
				}
	}
	
	// Draw path - takes a Graphics object parameter and draws the path

	/**
      * Draws the current path to the screen (to wherever the graphics object points)
      * using a highly-visible color.
      * 
      * @param g   a graphics object
      */  

	  public void drawPath(Graphics turtleArtist) {

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
	 * @param percentTraveled a distance along the path (a number between 0 and 100)
	 * @return the screen coordinate of this position along the path
	 */
	public Point locatePosition (double totalPercentTraveled) {
		
		// Determine how long the totalPercentTraveled is in relation to the path. 

		double totalLengthTraveled = (totalPathLength * (totalPercentTraveled/100));

		// Figure which segment that length falls under. 
			// Keep adding segment lengths together until the sum of the lengths is greater than the length traveled.
			int segmentCounter = 0;
			double segmentLengthAdder = 0.0;

			while (segmentLengthAdder < totalLengthTraveled) {
				segmentLengthAdder += segmentLengths[segmentCounter];
				segmentCounter++;
			}

			// Then subtract the length traveled from the sum of traveled segments to find how much is left in the segment, and how much has beenn traveled in the segment.
			double leftInSegment = segmentLengthAdder - totalLengthTraveled;
			double completedLengthOfSegment = segmentLengths[segmentCounter - 1];

		// Figure the percentage traveled along that length

		double percentageIntoSegment = completedLengthOfSegment/segmentLengths[segmentCounter - 1];

		// Calculate the point at that specific percentage. 

					// Xresult = (1 - 0.4) Xstart + (0.4) Xend  and   <----- Notes from professor
					double xPoint = (percentageIntoSegment * xArray[segmentCounter - 1]) + (leftInSegment * xArray[segmentCounter]);

					// Yresult = (1 - 0.4) Ystart + (0.4) Yend    <----- Notes from Professor
					double yPoint = (percentageIntoSegment * yArray[segmentCounter - 1]) + (leftInSegment * yArray[segmentCounter]);

		// Construct the Point
			Point solutionPoint = new Point(xPoint, yPoint);

		//Return the Point
		return solutionPoint;
	}
	
}

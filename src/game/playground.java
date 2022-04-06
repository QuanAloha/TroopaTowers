package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class playground {
    public static void main(String[] args) throws FileNotFoundException {
        
            // Get 2 different points
                // Use 2 different scanners to keep track of the right points. 
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
    
                    // Add the segments together to compute the total path length
                    totalLength += lengthToAdd;
                    segmentsCalculated ++;

                    System.out.println("Points used for calculation:     " + yOne + "     " + yTwo + "     " + xOne + "     " + xTwo +  
                                        "     Segment Length:   " + lengthToAdd + "     Segments Calculated: " + segmentsCalculated);      // TESTING LINE - prints out the segment calculations
                }
                
                System.out.println("The total calculated length is:     " + totalLength);           // TESTING LINE - Prints out total path length
            
            
    }
}


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * File: CD.java
 * 
 * Programmer: Daniel A. Alvarez
 */

/**
 * Reads the CD-data.txt file, creates a CD object and adds it to the ArrayList
 */
public class CDListTest 
{
    public static void main(String[] args) throws IOException
    {
        // Create a Scanner object for the file CD-date.txt
        Scanner infile = new Scanner(new File("CD-data.txt"));
        
        // Create a CDList object
        CDList list = new CDList();
        
        // Read CD-data.txt, add the data to a CD object, and add the object to the list
        while (infile.hasNext())
        {
            String line = infile.nextLine();   // stores the next line of data
            
            // Create a Scanner object for each line
            Scanner scanLine = new Scanner (line);
            
            double principal = scanLine.nextDouble();   // stores the principal amount from the data file
            int maturity = scanLine.nextInt();          // stores the maturity of the CD from the data file
            double interest = scanLine.nextDouble();    // stores the interest rate from the data file
            String compMode = scanLine.next();          // stores the compound mode from the data file
            
            // Create a CD object using the data scanned
            CD current = new CD (principal, interest, maturity, compMode);
            
            // Add the CD object to the list
            list.addCD(current);
        }
        
        // Print the table with all the information from each deposit
        list.printReport();
    }
    
}

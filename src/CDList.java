
import java.util.ArrayList;

/*
 * File: CD.java
 * 
 * Programmer: Daniel A. Alvarez
 */

/**
 * Creates an ArrayList of CD objects and prints the list.
 */
public class CDList 
{
   // instance var
   private ArrayList <CD> CDList;  // an ArrayList object
   
   /**
    * Initialize the instance variable and construct an ArrayList object
    */
   public CDList() 
   {
       this.CDList = new ArrayList <CD>();
   }
   
   /**
    * Add an object to the ArrayList
    * 
    * @param current - the object that is being added to the ArrayList
    */
   public void addCD(CD current)
   {
       CDList.add(current);
   }
   
   /**
    * Prints 10 tables that show the formatted data, accumulated value, 
    * interest rate earned for the year, and total interest rate earned for each CD in the ArrayList
    */
   public void printReport()
   {
       // Creates 10 tables, one for each year
       for (int y = 1; y < 11; y++)
       {
           // Print the heading of each table
           System.out.println("Year " + (y) + ":");
          
           System.out.printf("%9s%16s%11s%19s%24s%17s%20s%n","Principal","Interest Rate", "Maturity", "Compounding Mode",
                   "Interest for the Year", "Total Interest", "Accumulated Value") ;
           
           System.out.printf("%9s%16s%11s%19s%24s%17s%20s%n","=========","=============", "========", "================",
                   "=====================", "==============", "=================") ;
           
           // Iterate the list and print the values for each CD
           for (int i = 0; i < CDList.size(); i++)
           {
               CD current = CDList.get(i);   // Get the CD object in CDList with index i
               
               // Print the data for the given CD only if the current year is not past the maturity
               if (current.getMaturity() >= y) 
               {
                  // The total interest earned of a certain CD
                  double totalInterest = current.accumValue(y) - current.getPrincipal();
                  // The interest earned the current year
                  double yearInterest = 0;
                  
                  if(y == 1)
                  {
                    // The first year, total interest equals interest of the year
                    yearInterest = totalInterest;
                  }
                  else
                  {
                    // From the second year on, the interest of the year is the current
                    // accumulated value, times the accumulated value of the past year.
                    yearInterest = current.accumValue(y) - current.accumValue(y-1);
                  }
                  
                  // Print the data for each CD in one formatted row of the table
                  System.out.printf("$%8.2f %10.2f%% %10d %18s %15s %7.2f %9s %8.2f %10s %8.2f %n",current.getPrincipal(),
                           current.getInterest(), current.getMaturity(), current.getCompMode(), "$",
                           yearInterest, "$", totalInterest, "$", current.accumValue(y + 1));
               }
           }
           // Space between each table
           System.out.println("");
       }
   }
}

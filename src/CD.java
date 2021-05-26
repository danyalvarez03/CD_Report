/*
 * File: CD.java
 * 
 * Programmer: Daniel A. Alvarez
 */

/**
 * Creates a CD object, stores its characteristics, and calculates the accumulated value.
 */
public class CD 
{
    //instance var's
    private double principal;  // principal deposit
    private double interest;   // interest rate
    private int maturity;      // maturity of the deposit
    private String compMode;   // compounding mode of the deposit
    
    /**
    * Constructs a CD object
    *
    * @param principal - the principal deposit
    * @param interest - the interest rate of the deposit
    * @param maturity - the maturity of the deposit
    * @param compMode - the compound mode of the deposit
    */
    public CD (double principal, double interest, int maturity, String compMode)
    {
        // initialize instance var's
        this.compMode = compMode;
        this.interest = interest;
        this.maturity = maturity;
        this.principal = principal;
    }
    
    /**
     * Obtain the principal amount of the deposit
     * 
     * @return principal amount of the deposit
     */
    public double getPrincipal ()
    {
        return principal;
    }
    
    /**
     * Obtain the interest rate of the deposit
     * 
     * @return the interest rate of the deposit
     */
    public double getInterest ()
    {
        return interest;
    }
    
    /**
     * Obtain the maturity of the deposit
     * 
     * @return the maturity of the deposit
     */
    public int getMaturity ()
    {
        return maturity;
    }
    
    /**
     * Obtain the compounding mode of the deposit
     * 
     * @return the compounding mode of the deposit
     */
    public String getCompMode ()
    {
        return compMode;
    }
    
    /**
     * Calculate the accumulated value of the deposit after a certain time
     * 
     * @param yearsElapsed - years after the deposit
     * @return - the accumulated value of the deposit after the amount of years elapsed.
     */
    public double accumValue(int yearsElapsed)            
    {
        double formulaPart2 = 1;   // initialize the var that will store the value of (1 + r/n)^nt
        int timePerYear = 0;       // initialize the var that will store how frequently the interest is calculated in a year.
        
        if (compMode.equalsIgnoreCase("daily"))
        {
            timePerYear = 365;    // For a daily compounded deposit, the interest is calculated 365 times a year
        }
        else if(compMode.equalsIgnoreCase("quarterly"))
        {
            timePerYear = 4;      // For a quarterly compounded deposit, the interest is calculated 4 times a year
        }
        else if(compMode.equalsIgnoreCase("monthly"))
        {
            timePerYear = 12;     // For a monthly compounded deposit, the interest is calculated 12 times a year
        }
        
        // a loop to calculate the power in (1 + r/n)^nt
        for (int i = 0; i < timePerYear * yearsElapsed; i++)
        {
           // formulaPart2 gets the value of itelf multiplied nt times
           formulaPart2 = formulaPart2 * (1 + interest/ 100 / timePerYear);
        }
        
        return principal * formulaPart2; // return p(1 + r/n)^nt
    }
}

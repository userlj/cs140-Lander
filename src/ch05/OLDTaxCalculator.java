package ch05;
import java.util.Scanner;

/**
   This program calculates a simple tax return.
*/
public class OLDTaxCalculator
{  
   public static void main(String[] args)
   {  
      Scanner in = new Scanner(System.in);

      System.out.print("Please enter your income: ");
      double income = in.nextDouble();

      System.out.print("Are you married? (Y/N) ");
      String input = in.next();
      int status;
      if (input.equalsIgnoreCase("Y")) 
         status = OLDTaxReturn.MARRIED;
      else  
         status = OLDTaxReturn.SINGLE;

      OLDTaxReturn aTaxReturn = new OLDTaxReturn(income, status);

      System.out.println("Tax: "
            + aTaxReturn.getTax());
   }
}

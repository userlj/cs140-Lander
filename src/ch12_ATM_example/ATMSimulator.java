package ch12_ATM_example;
import java.io.IOException;
import java.util.Scanner;

/**
   A text-based simulation of an automatic teller machine.
*/
public class ATMSimulator {  
   public static void main(String[] args) {  
      ATM theATM;
      try {  
         Bank theBank = new Bank();
         theBank.readCustomers("customers.txt");
         theATM = new ATM(theBank);
      } catch(IOException e) {  
         System.out.println("Error opening accounts file.");
         return;
      }

      Scanner in = new Scanner(System.in);

      while (true) {
         State state = theATM.getState();
         state.processInput(theATM, in);
      }
   }
}


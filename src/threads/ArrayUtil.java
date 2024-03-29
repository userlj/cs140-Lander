package threads;
import java.util.Random;

/**
   This class contains utility methods for array 
   manipulation.
*/
   
public class ArrayUtil
{  
   /**
      Creates an array filled with random values.
      @param length the length of the array
      @param n the number of possible random values
      @return an array filled with length numbers between
      0 and n-1
   */
   public static int[] randomIntArray(int length, int n)
   {  
      int[] a = new int[length];
      Random generator = new Random();
      
      for (int i = 0; i < a.length; i++)
         a[i] = generator.nextInt(n);
    	  //a[i] = a.length-i;
      
      return a;
   }
}
      

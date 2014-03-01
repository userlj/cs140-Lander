package big.java.chap9;
public class VehicleDemo
{
   public static void process(VehicleVer2 v, String plateNumber)
   {
      // This example shows the syntax of instanceof and casting
      if (v instanceof CarVer2) 
      {
         CarVer2 c = (CarVer2) v; // Vehicle has no setLicensePlateNumber method--must cast
         c.setLicensePlateNumber(plateNumber);
      }

      System.out.println(v); // calls v.toString()
   }

   public static void main(String[] args)
   {
      VehicleVer2 aCar = new CarVer2(); 
      process(aCar, "XYX123"); 

      VehicleVer2 aLimo = new CarVer2(); 
      aLimo.setNumberOfTires(8);
      process(aLimo, "W00H00");

      process(new MotorcycleVer2(), "MT1729");
   }
}

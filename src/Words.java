import java.util.Arrays;


public class Words {
	public static String[] words(String str) {
		return str.replaceAll("\\W", " ").trim().split("\\s+");
	}
	
	public static void main(String[] args) {
		System.out.print("Input: ");
		System.out.println("one. two? three.");
		System.out.print("Output: ");
		System.out.println(Arrays.toString(words("one. two? three.")));
		System.out.print("Input: ");
		System.out.println(" ,, one;two? three");
		System.out.print("Output: ");
		System.out.println(Arrays.toString(words(" ,, one;two? three")));
		System.out.print("Input: ");
		System.out.println("one!! two:? three,  ");
		System.out.print("Output: ");
		System.out.println(Arrays.toString(words("one!! two:? three,  ")));
		System.out.print("Input: ");
		System.out.println("  one; \"two,:\" three  ");
		System.out.print("Output: ");
		System.out.println(Arrays.toString(words("  one; \"two,:\" three  ")));		
		System.out.print("Input: ");
		System.out.println("  ");
		System.out.print("Output: ");
		System.out.println(Arrays.toString(words("  ")));		
		System.out.print("Input: ");
		System.out.println((String)null);
		System.out.print("Output: ");
		System.out.println(Arrays.toString(words(null)));		
	}

}

package week1;

import java.awt.Rectangle;
/**
 * Tester for working with primitive and reference types.
 * @author CS140
 */
public class Class1 {

	/**
	 * @param args not used
	 */
	public static void main(String[] args) {
		int width = 10;
		System.out.println(width);
		width += 20; //means width = width + 20;
		width ++;
		System.out.println(width);
		Rectangle rect = new Rectangle(5,10,20,30);
		rect.translate(5, 6);
		System.out.println(rect.getX());
	}

}

package slides03.test03;
import slides03.test03a.Child;
public class Parent {
	public void m1(int x) {
	    System.out.println("Parent.m1");
	}
	public static void main(String[] args) {
		Parent p = new Child( );
		p.m1(1);
	}
}
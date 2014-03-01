package slides03.test06;
import slides03.test06a.Child;
public class Parent {
	void m1(int x) {
	    System.out.println("Parent.m1");
	}
	public static void main(String[] args) {
		Parent p = new Child();
		p.m1(1);
		
		// The package visible m1 is
		// not overridden in Child but
		// it is overridden in GrandChild
		p = new GrandChild();
		p.m1(1);
	}
}
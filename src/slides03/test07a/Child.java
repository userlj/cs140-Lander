package slides03.test07a;
import slides03.test07.Parent;
public class Child extends Parent {
	// it is legal but not required to put
	// the @Override annotation here
	public void m1(int x) {
		System.out.println("Child.m1");
	}
}
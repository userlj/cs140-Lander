package slides03.test02;
public class Child extends Parent {
	// it is legal but not required to put
	// the @Override annotation here
	public void m1(int x) {
		System.out.println("Child.m1");
	}
}
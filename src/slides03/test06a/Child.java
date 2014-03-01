package slides03.test06a;
import slides03.test06.Parent;
public class Child extends Parent {
	// Cannot override m1 in Parent
	void m1(int x) {
		System.out.println("Child.m1");
	}
}
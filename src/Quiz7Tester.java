class Quiz7Parent {
	private int x;

	public Quiz7Parent(int x) {
		this.x = x;
	}

	public int method(int a) {
		return a - x;
	}

	public int test(int u) {
		return method(u + 3);
	}

}

class Quiz7Child extends Quiz7Parent {
	private int y;

	public Quiz7Child(int x, int y) {
		super(x);
		this.y = y;
	}

	@Override
	public int method(int a) {
		return y + a;
	}
}

class Quiz7Grandchild extends Quiz7Child {
	private int z;

	public Quiz7Grandchild(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	@Override
	public int method(int a) {
		return z * a;
	}

	@Override
	public int test(int u) {
		return method(u - 2);
	}
}

public class Quiz7Tester {
	public static void main(String[] args) {
		Quiz7Parent p = new Quiz7Parent(1);
		System.out.println(p.test(10)); //-------Output:_______________
		p = new Quiz7Child(2,3);
		System.out.println(p.test(11)); //-------Output:_______________
		p = new Quiz7Grandchild(4,5,6);
		System.out.println(p.test(12)); //-------Output:_______________
	}
}

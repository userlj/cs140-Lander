class Quiz7Parent1 {
	private int x;

	public Quiz7Parent1(int x) {
		this.x = x;
	}

	private int method(int a) {
		return a - x;
	}

	public int test(int u) {
		return method(u + 3);
	}

}

class Quiz7Child1 extends Quiz7Parent1 {
	private int y;

	public Quiz7Child1(int x, int y) {
		super(x);
		this.y = y;
	}

	
	public int method(int a) {
		return y + a;
	}
}

class Quiz7Grandchild1 extends Quiz7Child1 {
	private int z;

	public Quiz7Grandchild1(int x, int y, int z) {
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

public class Quiz7Tester1 {
	public static void main(String[] args) {
		Quiz7Parent1 p = new Quiz7Parent1(1);
		System.out.println(p.test(10)); //-------Output:_______________
		p = new Quiz7Child1(2,3);
		System.out.println(p.test(11)); //-------Output:_______________
		p = new Quiz7Grandchild1(4,5,6);
		System.out.println(p.test(12)); //-------Output:_______________
	}
}

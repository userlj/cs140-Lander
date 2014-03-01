package assignment08;
public class Question1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A[] array = {new A(), new K(), new L(), new M(), new X(), new Y()};
		for(A a : array) {
			a.call();
		}
		
		array[0].a();
		((K)array[1]).k();
		((L)array[2]).l();
		((M)array[3]).m();
		((X)array[4]).x();
		((Y)array[5]).y();

		array = new A[]{new K(), new L(), new M(), new X(), new Y(), new A()};
		array[0].a();
		((K)array[1]).k();
		((L)array[2]).l();
		((M)array[3]).m();
		((X)array[4]).x();
		((Y)array[5]).y();
	}
	
}

public class BasicHash {
	public static void main(String[] args) {
		BasicHash obj1 = new BasicHash();
		System.out.println(obj1);
		System.out.println(obj1.hashCode());
		System.out.println(Integer.toHexString(obj1.hashCode()));

		BasicHash obj2 = new BasicHash();
		System.out.println(obj2);
		System.out.println(obj2.hashCode());
		System.out.println(Integer.toHexString(obj2.hashCode()));

		BasicHash obj3 = new BasicHash();
		System.out.println(obj3);
		System.out.println(obj3.hashCode());
		System.out.println(Integer.toHexString(obj3.hashCode()));	
	}
}

package subclassconstructor;

public class ParentExample {
	private int field1;
	private String field2;
	
	public ParentExample(int field1, String field2) {
		super(); // first call constructor of Object
		this.field1 = field1;
		this.field2 = field2;
	}

	public int getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}
	
}

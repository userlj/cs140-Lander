package subclassconstructor;

public class GrandChildExample extends ChildExample {
	private int fieldGc1;
	private String fieldGc2;
	
	public GrandChildExample(int field1, String field2, 
			int fieldC1, String fieldC2, int fieldGc1, 
			String fieldGc2) {
		super(field1, field2, fieldC1, fieldC2); // constructor of ChildExample
		this.fieldGc1 = fieldGc1;
		this.fieldGc2 = fieldGc2;
	}

	public GrandChildExample(int field1, int fieldC1) {
		super(field1, "", fieldC1, "");
		fieldGc2 = "";
	}
	
	public int getFieldGc1() {
		return fieldGc1;
	}

	public String getFieldGc2() {
		return fieldGc2;
	}

}

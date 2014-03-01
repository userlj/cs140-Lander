package subclassconstructor;

public class ChildExample extends ParentExample {
	private int fieldC1;
	private String fieldC2;
	public ChildExample(int field1, 
			String field2, int fieldC1, String fieldC2) {
		super(field1, field2); // call constructor of ParentExample
		this.fieldC1 = fieldC1;
		this.fieldC2 = fieldC2;
	}
	
	public int getFieldC1() {
		return fieldC1;
	}
	
	public String getFieldC2() {
		return fieldC2;
	}

}

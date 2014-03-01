
public class Example2 {
	private String river;
	private int len;
	
	public Example2(String river) {
		this.river = river;
		len = river.length();
	}

	public static void main(String[] args) {
		Example2 test = new Example2("Mississippi");
		int length = test.len;
	}
		
}

// SLIDE 3:33
public class Test {

	public static void main(String[] args) {
		IFace var1 = new E1();
		IFace var2 = new D1();

		B1 var3 = new C1();
		if(var3 instanceof IFace) {
			var2 = (IFace)var3;
		}
		//var2 = (IFace)var3;

		// var3 = new Alpha();
		Alpha var4 = new B1();
		var4 = new D1();
		if(var4 instanceof C1) {
			var3 = (C1)var4;
		}
//		var3 = (C1)var4;
		
//		if(var3 instanceof D1) {
//		}		
//		var1 = (D1)var3;
		System.out.println("Done");
	}

}

interface IFace {
	void method();
}

class Beta {
	
}

class Alpha extends Beta {
	
}

class B1 extends Alpha {
	
}

class D1 extends Alpha implements IFace {
	public void method() {
	}	
}

class C1 extends B1 {
	
}

class E1 extends D1 {
	
}

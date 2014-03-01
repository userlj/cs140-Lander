import java.io.Serializable;

public class Node implements Cloneable, Serializable {
	private static final long serialVersionUID = -8248280170423291193L;
	private double data;
	private Node next;
	public Node(double data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public double getData() {
		return data;
	}
	public Node clone() throws CloneNotSupportedException {
		//THE PRINTLNs HAVE NOTHING TO DO WITH CLONING, IT IS JUST
		// INFORMATIONAL
		System.out.println("Note that the clone() in Object changes the hashcode");
		System.out.println("this hash code: " + hashCode());
		System.out.println("the hash code of Node.class (using geClass(): " + getClass().hashCode());
		Node obj = (Node) super.clone();
		System.out.println("clone's hash code: " + obj.hashCode() );
		System.out.println("the hash code of Node.class (using obj.getClass(): " + obj.getClass().hashCode());
		System.out.println("clone: " + data + " -> " + obj.data);
		if(next != null) {
			obj.next = next.clone();
		}
		return obj;
	}

}
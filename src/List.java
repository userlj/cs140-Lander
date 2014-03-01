import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class List implements Cloneable, Serializable  {

	private Node head = null;

	public void insertList(double d) {
		Node temp = new Node(d, head);
		head = temp;
	}

	public double removeFromList() {
		// thows NullPointer if rear is null
		Node first = head;
		head = head.getNext();
		return first.getData();
	}

	public boolean isEmpty() {
		return head == null;
	}

	public List clone() throws CloneNotSupportedException {
		List obj = (List) super.clone();
		if(!isEmpty()) {
			obj.head = head.clone();
		}
		return obj;
	}
	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
		List list = new  List();
		list.insertList(1);
		list.insertList(2);
		list.insertList(3);
		list.insertList(4);
		if(!list.isEmpty()) {
			System.out.println(list.removeFromList());
		}
		list.insertList(5);
		list.insertList(6);
		if(!list.isEmpty()) {
			System.out.println(list.removeFromList());
		}
		list.insertList(7);
		list.insertList(8);
		if(!list.isEmpty()) {
			System.out.println(list.removeFromList());
		}
		list.insertList(9);
		list.insertList(10);
		if(!list.isEmpty()) {
			System.out.println(list.removeFromList());
		}
		while(!list.isEmpty()) {
			System.out.println(list.removeFromList());
		}
		System.out.println("-----------------");

		list.insertList(0);
		list.insertList(1);
		list.insertList(2);
		list.insertList(3);
		List list1 = list.clone();
		while(!list1.isEmpty()) {
			System.out.println(list1.removeFromList());
		}
		while(!list.isEmpty()) {
			System.out.println(list.removeFromList());
		}
		System.out.println("-----------------");

		list.insertList(0);
		list.insertList(1);
		list.insertList(2);
		list.insertList(3);
		
		System.out.println("-----------------");

		ByteArrayOutputStream baos = new ByteArrayOutputStream( );
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(list);
		ByteArrayInputStream bais = 
				new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		List listCopy = (List)ois.readObject( );
		
		System.out.println("-----------------");
		while(!listCopy.isEmpty()) {
			System.out.println(listCopy.removeFromList());
		}

		System.out.println("-----------------");
		while(!list.isEmpty()) {
			System.out.println(list.removeFromList());
		}

	}

}

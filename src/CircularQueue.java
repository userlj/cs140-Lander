import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CircularQueue implements Cloneable, Serializable  {

	private static final long serialVersionUID = -3820839358306877830L;
	private Node rear = null;

	public void insertQueue(double d) {
		Node temp = new Node(d, null);
		if (rear == null) {
			temp.setNext(temp);
		} else {
			temp.setNext(rear.getNext());
			rear.setNext(temp);
		}
		rear = temp;
	}

	public double removeFromQueue() {
		// thows NullPointer if rear is null
		Node first = rear.getNext();
		if(rear == rear.getNext()) {
			rear = null;
		} else {
			rear.setNext(first.getNext());
		}

		return first.getData();
	}

	public boolean isEmpty() {
		return rear == null;
	}

	public CircularQueue clone() throws CloneNotSupportedException {
		CircularQueue obj = (CircularQueue) super.clone();
		if(!isEmpty()) {
			obj.rear = rear.clone();
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
		CircularQueue queue = new  CircularQueue();
		queue.insertQueue(1);
		queue.insertQueue(2);
		queue.insertQueue(3);
		queue.insertQueue(4);
		if(!queue.isEmpty()) {
			System.out.println(queue.removeFromQueue());
		}
		queue.insertQueue(5);
		queue.insertQueue(6);
		if(!queue.isEmpty()) {
			System.out.println(queue.removeFromQueue());
		}
		queue.insertQueue(7);
		queue.insertQueue(8);
		if(!queue.isEmpty()) {
			System.out.println(queue.removeFromQueue());
		}
		queue.insertQueue(9);
		queue.insertQueue(10);
		if(!queue.isEmpty()) {
			System.out.println(queue.removeFromQueue());
		}
		while(!queue.isEmpty()) {
			System.out.println(queue.removeFromQueue());
		}
		System.out.println("-----------------");

		queue.insertQueue(0);
		queue.insertQueue(1);
		queue.insertQueue(2);
		queue.insertQueue(3);
		CircularQueue queue1 = queue.clone(); // would run infinitely

		ByteArrayOutputStream baos = new ByteArrayOutputStream( );
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(queue);
		ByteArrayInputStream bais = 
				new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		CircularQueue queueCopy = (CircularQueue)ois.readObject( );
		
		System.out.println("-----------------");
		while(!queueCopy.isEmpty()) {
			System.out.println(queueCopy.removeFromQueue());
		}

		System.out.println("-----------------");
		while(!queue.isEmpty()) {
			System.out.println(queue.removeFromQueue());
		}

	}

}

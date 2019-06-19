package Queue;

public class Queue<T> {

	class Node<T> {
		T data;
		Node next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}

	}

	private Node front, rear;

	boolean isEmpty() {
		return front == null;
	}

	void enqueue(T data) {
		Node<T> n = new Node(data);
		// if queue is empty
		if (isEmpty()) { // front = rear = null
			front = n; 
			rear = n;
		} else { // if queue has elements //front and read != null
			rear.next = n;
			rear = n;
		}
	}

	T dequeue() {
		// check if empty
		// if not empty then does it contains only 1 element --> after dequeue() queue
		// will be empty
		if (!isEmpty()) {
			Node<T> n = front;
			System.out.println("Dequeuing the element = "+n.data);
			if (front != rear) // more than 1 elements are present
				front = front.next;
			else if (front == rear) // only 1 element was left --> after dequeue() queue is now empty
				front = rear = null;
			return n.data;
		}
		System.out.println("Queue is Empty");
		return null;
	}

	T peek() {
		if (!isEmpty()) {
			System.out.println("Element at the front of the queue = "+front.data);
			return (T) front.data;
		}
		System.out.println("Queue is Empty");
		return null;
	}

	void displayAllElementsInQueue() {
		if (!isEmpty()) {
			Node n = front;
			while (n != null) {
				System.out.println(n.data);
				n = n.next;
			}
		}else
			System.out.println("Queue is Empty");
	}

	
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<>();
		q.displayAllElementsInQueue();
		q.enqueue(2);
		q.enqueue(3);
		q.peek();
		q.displayAllElementsInQueue();
		q.dequeue();
		q.peek();
		q.displayAllElementsInQueue();
		q.dequeue();
		q.peek();
		q.displayAllElementsInQueue();
		
		/*
		 * 
		 * Queue is Empty
			Element at the front of the queue = 2
			2
			3
			Dequeuing the element = 2
			Element at the front of the queue = 3
			3
			Dequeuing the element = 3
			Queue is Empty
			Queue is Empty
		 */
	}
}

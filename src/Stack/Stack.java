package Stack;

/*
 * This is Stack implementation as a LinkedList
 */

public class Stack<T> {

	private Node top;
	
	class Node<T>{
		T data; 
		Node next;
		
		public Node(T data) {
			super();
			this.data = data;
			this.next = null;
		}
	}
	
	boolean isEmpty() {
		if(top==null)
			return true; 
		return false;
	}
	
	void push(T data) {
		Node n = new Node<T>(data);
		System.out.println("Inserting data = "+ n.data);
		if(!isEmpty()) {
			n.next = top; 
		}
		top = n;
	}
	
	T pop() {
		if(!isEmpty()) {
			Node<T> n = top;
			System.out.println("Popping data = "+ n.data);
			top = top.next; 
			return n.data;
		}
		System.out.println("Stack is Empty");
		return null;
	}
	
	T peek() {
		if(!isEmpty()) {
			Node<T> n = top; 
			System.out.println("Element on top of the stack = "+ n.data);
			return n.data;
		}
		System.out.println("Stack is Empty");
		return null;
	}
	
	
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.isEmpty();
		s.pop();
		s.push(5);
		s.peek();
		s.push(6);
		s.peek();
		s.pop();
		s.pop();
		s.pop();
		s.peek();
		
		/*
		 * Stack is Empty
			Inserting data = 5
			Element on top of the stack = 5
			Inserting data = 6
			Element on top of the stack = 6
			Popping data = 6
			Popping data = 5
			Stack is Empty
			Stack is Empty

		 */
	}

}

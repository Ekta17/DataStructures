package Stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {

	@Test
	void testIsEmptyWhenEmpty() {
		Stack<Integer> s = new Stack<>();
		assertTrue(s.isEmpty(), "Stack is empty");	
	}
	
	@Test
	void testIsEmptyWhenNotEmpty() {
		Stack<Integer> s = new Stack<>();
		s.push(5);
		assertFalse(s.isEmpty(), "Stack is not empty");	
	}

	@Test
	void testPushWhenStackIsEmpty() {
		Stack<Integer> s = new Stack<>();
		s.push(5);
		assertFalse(s.isEmpty(), "Stack is not empty");
		assertTrue(s.peek() == 5, "Element on top of the stack is 5");
	}
	
	@Test
	void testPushWhenStackIsNotEmpty() {
		Stack<Integer> s = new Stack<>();
		s.push(5);
		assertFalse(s.isEmpty(), "Stack is not empty");
		s.push(6);
		assertFalse(s.peek() == 5, "Element on top of the stack is not 5");
		assertTrue(s.peek() == 6, "Element on top of the stack is 6");
	}

	@Test
	void testPopWhenStackIsEmpty() {
		Stack<Integer> s = new Stack<>();
		assertNull(s.pop(), "Stack is empty");
	}
	
	@Test
	void testPopWhenStackIsNotEmpty() {
		Stack<Integer> s = new Stack<>();
		s.push(6);
		s.push(5);
		
		int itemFromTopOfStack = s.pop();
		assertNotNull(itemFromTopOfStack, "Stack is not empty");
		assertTrue(itemFromTopOfStack == 5, "Item on top of stack was 5");
		assertFalse(s.isEmpty(), "Stack is not empty after first pop");
	}
	
	@Test
	void testPopWhenStackIsNotEmptyAndHasJustOneElement() {
		Stack<Integer> s = new Stack<>();
		s.push(5);
		int itemFromTopOfStack = s.pop();
		assertNotNull(itemFromTopOfStack, "Stack is not empty");
		assertTrue(itemFromTopOfStack == 5, "Item on top of stack was 5");
		assertTrue(s.isEmpty(), "Stack is empty after first pop");
	}

	@Test
	void testPeekWhenStackIsEmpty() {
		Stack<Integer> s = new Stack<>();
		assertNull(s.peek(), "Stack is Empty");
	}
	
	@Test
	void testPeekWhenStackIsNotEmpty() {
		Stack<Integer> s = new Stack<>();
		s.push(5);
		assertNotNull(s.peek(), "Stack is not Empty");
		assertTrue(s.peek() == 5, "Element on top of the stack is 5");
	}

}

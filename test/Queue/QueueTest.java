package Queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {

	@Test
	void testIsEmptyWhenQueueIsEmpty() {
		Queue<Integer> q = new Queue<>();
		assertTrue(q.isEmpty(), "Queue is Empty");
	}

	@Test
	void testIsEmptyWhenQueueIsNotEmpty() {
		Queue<Integer> q = new Queue<>();
		q.enqueue(2);
		assertFalse(q.isEmpty(), "Queue is not Empty");
	}

	@Test
	void testEnqueue() {
		Queue<Integer> q = new Queue<>();
		q.enqueue(2);
		assertTrue(q.peek() == 2, "Element in front of the queue is 2");
		q.enqueue(3);
		assertTrue(q.peek() == 2, "Element in front of the queue is still 2");
	}

	@Test
	void testDequeueWhenQueueIsEmpty() {
		Queue<Integer> q = new Queue<>();
		assertNull(q.dequeue(), "Queue is Empty");
	}

	@Test
	void testDequeueWhenQueueIsNotEmptyAndHasOneElement() {
		Queue<Integer> q = new Queue<>();
		q.enqueue(2);
		int itemFromFrontOfTheQueue = q.dequeue();
		assertNotNull(itemFromFrontOfTheQueue, "Item successfully dequeued from front of the queue");
		assertTrue(itemFromFrontOfTheQueue == 2,
				"Item dequeued from front of the queue is the first element inserted in the queue");
		assertNull(q.peek(), "Queue is now empty after dequeuing the last element");
	}

	@Test
	void testDequeueWhenQueueIsNotEmptyAndHasMoreThanOneElement() {
		Queue<Integer> q = new Queue<>();
		q.enqueue(2);
		q.enqueue(3);
		int itemFromFrontOfTheQueue = q.dequeue();
		assertNotNull(itemFromFrontOfTheQueue, "Item successfully dequeued from front of the queue");
		assertTrue(itemFromFrontOfTheQueue == 2,
				"Item dequeued from front of the queue is the first element inserted in the queue");
		assertNotNull(q.peek(), "Queue is not empty after dequeuing an element");
		assertTrue(q.peek() == 3, "Front of the queue element is 3");
	}

	@Test
	void testPeekWhenQueueIsEmpty() {
		Queue<Integer> q = new Queue<>();
		assertNull(q.peek(), "Queue is empty");
	}

	@Test
	void testPeekWhenQueueIsNotEmpty() {
		Queue<Integer> q = new Queue<>();
		q.enqueue(2);
		assertNotNull(q.peek(), "Queue is not empty");
		assertTrue(q.peek() == 2, "Element at the front of the queue is 2");
	}

}

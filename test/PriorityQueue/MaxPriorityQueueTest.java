package PriorityQueue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PriorityQueue.PriorityQueue.HEAP_TYPE;

class MaxPriorityQueueTest {
	
	PriorityQueue<Integer> pq;

	@BeforeEach
	void setUp() throws Exception {
		pq = new PriorityQueue<>(5, HEAP_TYPE.MAX_HEAP);  
	}

	@AfterEach
	void tearDown() throws Exception {
		this.pq = null;
	}

	@Test
	void testIsEmpty_whenEmpty() {
		assertTrue(this.pq.isEmpty());		
	}
	
	@Test
	void testIsEmpty_whenNotEmpty() {
		this.pq.add(2);
		assertFalse(this.pq.isEmpty());
	}

	@Test
	void testPeek() {
		this.pq.add(2);
		this.pq.add(3);
		this.pq.add(5);
		assertEquals(5, this.pq.peek());
	}

	@Test
	void testPoll() {
		this.pq.add(2);
		this.pq.add(3);
		this.pq.add(5);
		assertEquals(5, this.pq.poll());
		assertFalse(this.pq.contains(5));
	}

	@Test
	void testContains() {
		this.pq.add(2);
		this.pq.add(3);
		this.pq.add(5);
		assertTrue(this.pq.contains(2));
		assertFalse(this.pq.contains(4));
	}

	@Test
	void testAdd() {
		this.pq.add(2);
		assertTrue(this.pq.contains(2));
	}

	@Test
	void testRemove() {
		this.pq.add(2);
		this.pq.add(3);
		assertTrue(this.pq.contains(2));
		assertTrue(this.pq.contains(3));
		assertTrue(this.pq.remove(2)); 
		assertFalse(this.pq.contains(2));
		assertTrue(this.pq.contains(3));
	}

	@Test
	void testRemoveAt() {
		this.pq.add(2);
		this.pq.add(3);
		assertEquals(3, this.pq.removeAt(0)); 
		assertFalse(this.pq.contains(3));
		assertTrue(this.pq.contains(2));
	}

	@Test
	void testHeapify() {
		this.pq.add(4);
		this.pq.add(3);
		this.pq.add(2);
		this.pq.heapify(0);
		assertEquals(4, this.pq.getElementAt(0));
		assertEquals(3, this.pq.getElementAt(1));
		assertEquals(2, this.pq.getElementAt(2));
	}

}


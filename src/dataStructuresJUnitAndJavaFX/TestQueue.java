
package dataStructuresJUnitAndJavaFX;

import org.junit.jupiter.api.Test;
import dataStructuresJUnitAndJavaFX.arrayQueue.ArrayQueue;
//import dataStructuresJUnitAndJavaFX.queue.LinkedQueue;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;

/**
 * @author Robin
 *
 */
public class TestQueue {

	private ArrayQueue q;

	@BeforeEach
	public void setUp() {
		q = new ArrayQueue();
	}

	@Test
	public void testSizeIsEmpty() {
		assertEquals(0, q.size());
		assertTrue(q.isEmpty());
		q.enqueue(1);
		q.enqueue(2);
		assertEquals(2, q.size());
		assertFalse(q.isEmpty());
	}

	@Test
	public void testEnqDeq() {
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		assertEquals(6, q.size());
		assertEquals(6, q.last());
		assertEquals(1, q.first());
		q.dequeue(); 
		assertEquals(5, q.size());
		assertEquals(2, q.first());
	}

	@Test
	public void testFirstLast() {
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		assertEquals(3, q.last());
		assertEquals(1, q.first());
		q.dequeue();
		q.dequeue();
		assertTrue(q.first() == q.last());
	}

	@Test
	public void testItToString() {
		q.enqueue(1);
		assertTrue(q.iterator().hasNext());
		assertEquals(1, q.iterator().next());
		q.dequeue();
		assertFalse(q.iterator().hasNext());
		q.enqueue(1);
		q.enqueue(2);
		assertEquals("1 2 ", q.toString());		
	}
	

	@Test
	public void testExc() {
		assertThrows(NullPointerException.class, () -> q.dequeue());
		assertThrows(NullPointerException.class, () -> q.first());
		assertThrows(NullPointerException.class, () -> q.last());		
	}

}

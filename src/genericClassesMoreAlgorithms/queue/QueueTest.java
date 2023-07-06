/**
 * 
 */
package genericClassesMoreAlgorithms.queue;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Class Queue test, testing functionality
 * 
 * @author Robin
 *
 */
public class QueueTest {

	Queue<String> strings = new LinkedQueue<String>();
	Queue<Integer> integers = new LinkedQueue<Integer>();

	@Test
	public void testIsEmpty() {
		assertTrue(strings.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(0, strings.size());
	}

	@Test
	public void testEnqueue() {
		strings.enqueue("s");
		assertEquals(1, strings.size());
		assertEquals("s", strings.first());
		assertEquals("s", strings.last());
	}

	@Test
	public void testDequeue() {
		strings.enqueue("s");
		assertEquals(1, strings.size());
		strings.dequeue();
		assertTrue(strings.isEmpty());
	}

	@Test
	public void testEnqueueInt() {
		integers.enqueue((Integer) 1);
		assertEquals(1, integers.size());
		assertEquals((Integer) 1, integers.first());
		assertEquals((Integer) 1, integers.last());
		integers.enqueue((Integer) 2);
		assertEquals((Integer) 2, integers.last());
	}

	@Test
	public void testDequeuInt() {
		integers.enqueue(1);
		integers.dequeue();
		assertEquals(0, integers.size());
		assertTrue(integers.isEmpty());
	}
	
	@Test
	public void testToString() {
		strings.enqueue("something");
		strings.enqueue("or");
		strings.enqueue("other");
		assertEquals("something, or, other, ", strings.toString());		
	}

}

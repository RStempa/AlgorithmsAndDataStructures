/**
 * 
 */
package genericClassesMoreAlgorithms.binheap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * @author Robin
 *
 */
public class BinaryIntHeapTest {
	
	BinaryIntHeap binheap = new BinaryIntHeap();
	
	private void insert(int size) {
		for (int i = 0; i < size; i++) {
			binheap.insert(i);
		}
	}

		
		@Test
		public void testInsert() {
			insert(4);
			assertEquals(4,binheap.size());
		}

		@Test (expected = NoSuchElementException.class)
		public void testPullHighest() {
			binheap.pullHighest();
			
			insert(4);
			assertEquals(3,binheap.pullHighest());
		}

		@Test
		public void testIsEmpty() {
			assertTrue(binheap.isEmpty());
			binheap.insert(10);
			assertFalse(binheap.isEmpty());
		}
		
	}



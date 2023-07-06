/**
 * 
 */
package genericClassesMoreAlgorithms.binheap;

import java.util.NoSuchElementException;

/**
 * @author Robin
 * 
 *         Implementation of an array based binary integer heap. Source for some
 *         of the code is https://www.youtube.com/watch?v=W81Qzuz4qH0.
 *
 */
public class BinaryIntHeap {
	private int size;
	private int[] binheap;

	/**
	 * Constructing a new Binary integer heap with an array of size 11.
	 */

	public BinaryIntHeap() {
		binheap = new int[11];
		 size = 0;
	}

	/**
	 * Private method sift up for finding the correct position of inserted
	 * integer.
	 */

	private void siftUp() {
		int k = size;
		while (k > 0) {
			int p = (k - 1) / 2;
			int item = binheap[k];
			int parent = binheap[p];

			if (item < parent) {
				swap(binheap, k, p);
				k = p;
			} else
				break;
		}
	}

	/**
	 * Private method sift down for finding the correct position of next integer
	 * in heap after pull highest is called.
	 */

	private void siftDown() {
		int k = 0;
		int l = 2 * k + 1;
		while (l < size) {
			int max = l;
			int r = l + 1;

			if (r < size) {
				if (binheap[r] < binheap[l]) {
					max++;
				}
			}
			if (binheap[k] < binheap[max]) {
				swap(binheap, k, max);
				k = max;
				l = 2 * k + 1;
			} else
				break;
		}
	}

	/**
	 * Inserting a new integer in the heap.
	 * 
	 * @param n
	 */

	public void insert(int n) {
		binheap[size] = n;
		siftUp();
		size++;
		if (size == binheap.length)
			resize();
	}

	/**
	 * Method for pulling first integer with highest priority.
	 * 
	 * @return
	 * @throws NoSuchElementException
	 */

	public int pullHighest() throws NoSuchElementException {
		if (size == 0) 
			throw new NoSuchElementException();
		if (size == 1) 
			return binheap[0];
		
		int hold = binheap[0];
		for (int i = 0; i < binheap.length; i++) {
			binheap[i] = binheap[i + 1];
		}
		size--;
		siftDown();
		return hold;
	}

	/**
	 * The current size of the array.
	 * 
	 * @return
	 */

	public int size() {
		return size;
	}

	/**
	 * True if array is empty.
	 * 
	 * @return
	 */

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Private method for resizing array when full
	 */

	private void resize() {
		int[] tmp = new int[binheap.length * 2];
		System.arraycopy(binheap, 0, tmp, 0, binheap.length);
		binheap = tmp;
	}

	/**
	 * 
	 * @param a
	 * @param i
	 * @param j
	 * 
	 *            Private method for swapping elements in the array, used in
	 *            sift up and sift down.
	 */

	private void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}

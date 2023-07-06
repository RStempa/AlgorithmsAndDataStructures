package genericClassesMoreAlgorithms.binheap;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * BinaryHeapQueue implements a priority queue based on binary heaps using
 * arrayList.
 * 
 * @author Robin
 *
 */
public class BinaryHeapQueue implements PriorityQueue {
	private ArrayList<Task> binheap; // the binary heap

	public BinaryHeapQueue() {
		binheap = new ArrayList<Task>();
	}

	/**
	 * insert adds a task to the heap.
	 */
	@Override
	public void insert(Task t) {
		binheap.add(t);
		percUp();
	}

	/**
	 * finds positon of added task.
	 */
	private void percUp() {
		int k = binheap.size() - 1;

		while (k > 0) {
			int p = (k - 1) / 2;
			Task task = binheap.get(k);
			Task parent = binheap.get(p);

			if (task.compare(parent) > 0) {
				swap(binheap, k, p);
				k = p;
			} else
				break;
		}
	}

	/**
	 * private swap place method.
	 * 
	 * @param binheap
	 * @param k
	 * @param p
	 */
	private void swap(ArrayList<Task> binheap, int k, int p) {
		Task temp = binheap.get(k);
		binheap.set(k, binheap.get(p));
		binheap.set(p, temp);
	}

	/**
	 * return the task with highest priority.
	 */
	@Override
	public Task pullHighest() throws NoSuchElementException {
		if (binheap.size() == 0)
			throw new NoSuchElementException();
		else if (binheap.size() == 1)
			return binheap.remove(0);
		else {
			Task t = binheap.get(0);
			swap(binheap, 0, binheap.size() - 1);
			binheap.remove(binheap.size() - 1);
			percDown();
			return t;
		}
	}

	/**
	 * finds position of new index 0 after removing task.
	 */
	private void percDown() {
		int k = 0;
		int left = 2 * k + 1;

		while (left < binheap.size()) {
			int max = left;
			int right = left + 1;

			if (right < binheap.size()) {
				if ((binheap.get(right).compare(binheap.get(left)) > 0)) {
					max++;
				}
			}
			if ((binheap.get(k).compare(binheap.get(max))) < 0) {
				swap(binheap, k, max);
				k = max;
				left = 2 * k + 1;
			} else
				break;
		}
	}

	/**
	 * returns true if heap contains task.
	 */
	@Override
	public boolean contains(Task t) {
		return binheap.contains(t);
	}

	/**
	 * returns size of heap.
	 */
	@Override
	public int size() {
		return binheap.size();
	}

	/**
	 * return true if empty.
	 */
	@Override
	public boolean isEmpty() {
		return binheap.size() == 0;
	}

	/**
	 * return highest priority task without removing it.
	 */
	@Override
	public String peekHighest() {
		Task t = binheap.get(0);
		String s = Integer.toString(t.priority) + ": " + t.getDescription();
		return s;
	}

	/**
	 * to string method for heap.
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < binheap.size(); i++) {
			str += Integer.toString(binheap.get(i).getPriority()) + ":" + binheap.get(i).getDescription() + ", ";
		}
		return str;
	}
}

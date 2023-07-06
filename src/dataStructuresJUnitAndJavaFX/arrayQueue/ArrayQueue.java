/**
 * 
 */
package dataStructuresJUnitAndJavaFX.arrayQueue;

import java.util.Iterator;

/**
 * A class that implements Queue by using a circular array.
 * 
 * @author Robin
 *
 */
public class ArrayQueue implements Queue {
	private int theSize; // size of the queue
	private int first; // index of first object
	private int last;// index of last object
	private Object[] queue;

	/**
	 * Constructor sets initial size to 5.
	 */
	public ArrayQueue() {
		theSize = 5;
		first = 0;
		last = 0;
		queue = new Object[theSize];
	}

	/**
	 * Returns the current size of the queue.
	 */
	@Override
	public int size() {
		return getSize();
	}

	private int getSize() {
		return (queue.length - first + last) % queue.length;
	}

	/**
	 * Returns true if queue is empty.
	 */
	@Override
	public boolean isEmpty() {
		if (first == last)
			return true;
		else
			return false;
	}

	/**
	 * Resize method, doubles the size of array.
	 */
	private void resize() {
		int objects = size();
		theSize = theSize * 2;
		int lastIndex = objects + 1; // last index in old array.
		Object[] temp = new Object[theSize]; // new array.
		int i = 0;

		for (int o = objects; o > 0; o--) {
			temp[i++] = queue[first++]; // first in queue is set to index 0 in new array.
			if (first == lastIndex)
				first = 0;
		}

		last = i++;
		first = 0;
		queue = temp;
	}

	/**
	 * Adds a new object to the queue.
	 */
	@Override
	public void enqueue(Object element) {
		Object obj = element;
		if (size() == queue.length - 1)
			resize();
		queue[last++] = obj;
		if (last == queue.length)
			last = 0;
	}

	/**
	 * Returns and removes the first object in the queue.
	 */
	@Override
	public Object dequeue() throws NullPointerException {
		if (isEmpty())
			throw new NullPointerException("Queue is empty!");
		Object obj = queue[first++];
		if (first == queue.length)
			first = 0;
		return obj;
	}

	/**
	 * Returns the first object in the queue.
	 */
	@Override
	public Object first() throws NullPointerException {
		if (isEmpty())
			throw new NullPointerException("Queue is empty!");
		return getFirst();
	}

	private Object getFirst() {
		return queue[first];
	}

	/**
	 * Returns the last object in the queue.
	 */
	@Override
	public Object last() throws NullPointerException {
		if (isEmpty())
			throw new NullPointerException("Queue is empty!");
		return getlast();
	}

	private Object getlast() {
		return queue[last - 1]; // last -1 because enqueue increments last index;
	}

	/**
	 * Returns a string representation of the objects in the queue.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Iterator<Object> it = this.iterator();
		if (!this.isEmpty()) {
			while (it.hasNext())
				sb.append(it.next() + " ");
		} else
			System.err.println("There are no objects in list. ");
		return sb.toString();

	}

	/**
	 * Returns a new iterator from private inner class QueueIterator.
	 */
	@Override
	public Iterator<Object> iterator() {
		return new QueueIterator();
	}

	/**
	 * Private class QueueIterator with methods hasNext and next.
	 * 
	 * @author Robin
	 *
	 */
	private class QueueIterator implements Iterator<Object> {
		private int f = first;

		/**
		 * Returns object first in queue.
		 */
		@Override
		public boolean hasNext() {
			return queue[f] != null;
		}

		/**
		 * Returns the next object in the queue.
		 */
		@Override
		public Object next() {
			Object obj = queue[f++];
			return obj;
		}
	}
}

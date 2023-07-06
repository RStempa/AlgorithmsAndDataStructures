/**
 * 
 */
package genericClassesMoreAlgorithms.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Robin
 * 
 *         The Class LinkedQueueis a generic version of the linked
 *         implementation of a queue. It is a FIFO, first in first out data
 *         structure. It has a head object at first position and tail object at
 *         last.
 *
 */
public class LinkedQueue<T> implements Queue<T> {
	private int size;
	private Node head; // First node
	private Node tail; // Last node

	/**
	 * Instantiates a new linked queue.
	 */
	public LinkedQueue() {
		size = 0;
		head = null;
		tail = null;
	}

	/**
	 * Size.
	 * 
	 * @return the integer corresponding to the number of objects in the queue.
	 */

	@Override
	public int size() {
		return size;
	}

	/**
	 * Checks if the queue is empty.
	 *
	 * @return true, if is empty
	 */

	@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	/**
	 * Enqueue.
	 *
	 * @param element
	 *            the element is to be added to the queue. size increase with one.
	 */

	@Override
	public void enqueue(T element) {
		Node newTail = new Node(element);
		if (head == null) {
			head = newTail;
			tail = newTail;
		} else {
			tail.next = newTail;
			tail = newTail;
		}
		size++;
	}

	/**
	 * Dequeue.
	 *
	 * @return and remove the object in head position and decrease size with one.
	 * @throws NullPointerException
	 */

	@Override
	public T dequeue() throws NullPointerException {
		if (head != null) {
			T temp = head.t;
			head = head.next;
			size--;
			return temp;
		} else
			tail = null;
		throw new NullPointerException("Queue is empty!");
	}

	/**
	 * First.
	 *
	 * @return the object (without removing)head position.
	 * @throws IndexOutOfBoundsException
	 */

	@Override
	public T first() throws IndexOutOfBoundsException {
		if (size != 0)
			return head.t;
		else
			throw new IndexOutOfBoundsException("Queue is empty!");
	}

	/**
	 * Last.
	 *
	 * @return the object (without removing) tail position.
	 * @throws IndexOutOfBoundsException
	 */

	@Override
	public T last() throws IndexOutOfBoundsException {
		if (size != 0)
			return tail.t;
		else
			throw new IndexOutOfBoundsException("Queue is empty!");
	}

	/**
	 * Iterator.
	 *
	 * @return the iterator going over all objects in queue.
	 * @throws NoSuchElementException
	 */

	@Override
	public Iterator<T> iterator() throws NoSuchElementException {
		if (size != 0)
			return new QueueIterator();
		else
			throw new NoSuchElementException("Queue is empty!");
	}

	/**
	 * To string.
	 *
	 * @return the string representation of the queue content.
	 */

	public String toString() {
		StringBuffer sb = new StringBuffer();
		Iterator<T> it = this.iterator();
		if (!this.isEmpty()) {
			while (it.hasNext())
				sb.append(it.next() + ", ");
		} else
			System.err.println("There are no objects in list. ");
		return sb.toString();
	}

	/**
	 * The inner Class Node. creates a node object with some value and a link to the
	 * next node in the link.
	 */

	private class Node {
		private T t;
		Node next;
		Node(T o) {
			t = o;
		}
	}

	/**
	 * The inner Class QueueIterator.
	 */
	private class QueueIterator implements Iterator<T> {
		private Node node = head;

		/**
		 * returns true if next iteration is an object.
		 */
		@Override
		public boolean hasNext() {
			return node != null;
		}

		/**
		 * returns the next object in the iteration.
		 */
		@Override
		public T next() {
			T element = node.t;
			node = node.next;
			return element;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException(); // Not implemented
		}

	}

}

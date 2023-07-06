/**
 * 
 */
package dataStructuresJUnitAndJavaFX.queue;

import dataStructuresJUnitAndJavaFX.arrayQueue.Queue;

import java.util.Iterator;

/**
 * A class that implements a FIFO structure and implements the Queue interface
 * with head and tail approach.
 * 
 * @author Robin
 *
 */
public class LinkedQueue implements Queue {

	private Node head; // first node
	private Node tail; // last node
	private int size; // size of queue

	/**
	 * Constructor sets head, tail to null and size to zero.
	 */
	public LinkedQueue() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Returns the size of the queue.
	 */
	@Override
	public int size() {
		return getSize();
	}

	private int getSize() {
		return size;
	}

	/**
	 * Returns true if queue is empty.
	 */
	@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	/**
	 * Adds a new object to the queue.
	 */
	@Override
	public void enqueue(Object element) {
		Node newNode = new Node(element);
		if (head == null) {
			head = newNode;
			tail = head;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	/**
	 * Returns and removes the first object in the queue.
	 */
	@Override
	public Object dequeue() throws NullPointerException {
		if (isEmpty())
			throw new NullPointerException("Queue is empty!");
		else {
			return getDecueue();
		}
	}

	private Object getDecueue() {
		Object ret = head.obj;
		head = head.next;
		size--;
		return ret;
	}

	/**
	 * Returns the first object in the queue.
	 */
	@Override
	public Object first() throws NullPointerException {
		if (isEmpty())
			throw new NullPointerException("Queue is empty!");
		return getHead();
	}

	private Object getHead() {
		return head.obj;
	}

	/**
	 * Returns the last object in the queue.
	 */
	@Override
	public Object last() throws NullPointerException {
		if (isEmpty())
			throw new NullPointerException("Queue is empty!");
		return getTail();
	}

	private Object getTail() {
		return tail.obj;
	}

	/**
	 * Returns a new iterator from private inner class QueueIterator.
	 */
	@Override
	public Iterator<Object> iterator() {
		return new QueueIterator();
	}

	/**
	 * Returns a string representation of the objects in the queue.
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Iterator<Object> it = this.iterator();
		if (!this.isEmpty()) {
			while (it.hasNext())
				sb.append(it.next() + " ");
		} else
			System.err.println("There are no objects in list. ");
		return sb.toString();
	}

	/**
	 * Private class Node that only knows about itself and the next Node.
	 * 
	 * @author Robin
	 *
	 */
	private class Node {
		Object obj;
		Node next = null;

		private Node(Object o) {
			obj = o;
		}
	}

	/**
	 * Private class QueueIterator with methods hasNext and next.
	 * 
	 * @author Robin
	 *
	 */
	private class QueueIterator implements Iterator<Object> {
		private Node node = head;

		/**
		 * Returns the node if not null.
		 */
		@Override
		public boolean hasNext() {
			return node != null;
		}

		/**
		 * Returns the next node in the queue.
		 */
		@Override
		public Object next() {
			Object obj = node.obj;
			node = node.next;
			return obj;
		}

	}

}

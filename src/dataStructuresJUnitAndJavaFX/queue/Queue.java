package rs222nv_assignment2and3.rs222nv_assignment2.queue;

import java.util.Iterator;

/**
 * 
 * Interface for the implementation of a Queue
 *
 */
public interface Queue {
	/**
	 * 
	 * @return current queue size
	 */
	public int size();

	/**
	 * 
	 * @return true if queue is empty
	 */
	public boolean isEmpty();

	/**
	 * add element at end of queue
	 * 
	 * @param element
	 */
	public void enqueue(Object element);

	/**
	 * 
	 * @return return and remove first element.
	 */
	public Object dequeue();

	/**
	 * 
	 * @return // return (without removing) first element
	 */
	public Object first();

	/**
	 * 
	 * @return return (without removing) last element
	 */
	public Object last();

	/**
	 * 
	 * @return return a string representation of the queue content
	 */
	public String toString();

	/**
	 * 
	 * @return element iterator
	 */
	public Iterator<Object> iterator();
}

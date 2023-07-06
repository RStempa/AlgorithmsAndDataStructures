package genericClassesMoreAlgorithms.queue;

import java.util.Iterator;

/**
 * 
 * @author Robin
 * @param <T>
 *            Interface for the generic type of queue.
 */

public interface Queue<T> {
	public int size(); // current queue size
	public boolean isEmpty(); // true if queue is empty
	public void enqueue(T element); // add element at end of queue
	public T dequeue(); // return and remove first element.
	public T first(); // return (without removing) first element
	public T last(); // return (without removing) last element
	public String toString(); // return a string representation of the queue							
	public Iterator<T> iterator(); // element iterator

}

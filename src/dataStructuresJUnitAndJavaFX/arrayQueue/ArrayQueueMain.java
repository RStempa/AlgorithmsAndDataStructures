/**
 * 
 */
package dataStructuresJUnitAndJavaFX.arrayQueue;

import java.util.Iterator;

/**
 * @author Robin
 *
 */
public class ArrayQueueMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayQueue lq = new ArrayQueue();
		System.out.println("is empty is " + lq.isEmpty());
		lq.enqueue("one");
		lq.enqueue("two");
		lq.enqueue("hello");

		System.out.println("size is " + lq.size());

		System.out.println("is empty = " + lq.isEmpty());
		System.out.println(lq.last() + " = hello");
		System.out.println(lq.first() + " = 1");

		System.out.println("decued is " + lq.dequeue());

		System.out.println("is it empty? " + lq.isEmpty());
		System.out.println("size is " + lq.size());
		System.out.println("last should be hello and is " + lq.last());
		System.out.println("first should be two " + lq.first());
		lq.enqueue(4);
		System.out.println("last should be 4 and is " + lq.last() + " size should be 3 " + lq.size());
		lq.enqueue(5);
		lq.enqueue(6);
		System.out.println("last should be 6 and is " + lq.last() + " size should be 5 and is " + lq.size());

		Iterator<Object> it = lq.iterator();

		System.out.println();
		while (it.hasNext())
			System.out.println(it.next());

		System.out.println();
		System.out.println("dequeue: " + lq.dequeue());
		System.out.println("dequeue: " + lq.dequeue());
		System.out.println("dequeue: " + lq.dequeue());
		System.out.println("dequeue: " + lq.dequeue());
		System.out.println("dequeue: " + lq.dequeue());
		System.out.println("dequeue: " + lq.dequeue());// exception
	}

}

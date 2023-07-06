/**
 * 
 */
package dataStructuresJUnitAndJavaFX.queue;

import dataStructuresJUnitAndJavaFX.queue.LinkedQueue;

import java.util.Iterator;

/**
 * @author Robin
 *
 */
public class LinkedQueueMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedQueue lq = new LinkedQueue();
        //lq.dequeue();
		lq.enqueue(1);
		lq.enqueue(2);
		lq.enqueue("hello");
		
		System.out.println(lq.toString());

		System.out.println(lq.isEmpty());
		System.out.println(lq.size());
		System.out.println(lq.last());
		System.out.println(lq.first());

		System.out.println(lq.dequeue());

		System.out.println(lq.isEmpty());
		System.out.println(lq.size());
		System.out.println(lq.last());
		System.out.println(lq.first());
		System.out.println();
		lq.enqueue(4);

		Iterator<Object> it = lq.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		System.out.println(lq.size());
		System.out.println(lq.toString());
		System.out.println(lq.size());
		System.out.println(lq.dequeue());
		System.out.println("Size" + lq.size());
		System.out.println("3 " + lq.first());
		System.out.println("4 " + lq.last());
	}

}

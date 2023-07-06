package genericClassesMoreAlgorithms.binheap;

/**
 * Class testing implementation of binary heap queue.
 * 
 * @author Robin
 *
 */

public class WorkMain {
	private static BinaryHeapQueue bhq = new BinaryHeapQueue();

	public static void main(String[] args) {

		Task task1 = new WorkTask("description", 15);
		Task task2 = new WorkTask("description", 10);
		Task task3 = new WorkTask("description", 9);
		Task task4 = new WorkTask("description", 8);
		Task task5 = new WorkTask("description", 9);
		Task task6 = new WorkTask("description", 6);
		Task task7 = new WorkTask("description", 3);
		Task task8 = new WorkTask("description", 4);
		Task task9 = new WorkTask("description", 2);
		bhq.insert(task3);
		bhq.insert(task2);
		bhq.insert(task1);
		bhq.insert(task7);
		bhq.insert(task5);
		bhq.insert(task6);
		bhq.insert(task4);
		bhq.insert(task8);
		bhq.insert(task9);
		
		System.out.println(bhq.toString());
		System.out.println("highest priority " + bhq.pullHighest().getPriority());
		System.out.println(bhq.toString());
		System.out.println("Highest priority - " + bhq.peekHighest());
		System.out.println("is empty = " + bhq.isEmpty() + ", size is = " + bhq.size());
		System.out.println("contains the task = " + bhq.contains(task7));

	}

}

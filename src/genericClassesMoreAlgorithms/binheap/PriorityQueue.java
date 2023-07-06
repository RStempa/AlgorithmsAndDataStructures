package genericClassesMoreAlgorithms.binheap;

public interface PriorityQueue {
	
	public void insert(Task t); // add a task
	public Task pullHighest(); // return the task with highest priority
	public boolean contains(Task t); // true if queue contains Task
	public int  size(); // return size of queue
	public boolean isEmpty(); // true if empty
	public String peekHighest(); // show but not remove highest

}

package genericClassesMoreAlgorithms.binheap;

/**
 * abstract class Task
 * 
 * @author Robin
 *
 */
public abstract class Task {

	protected String description;
	protected int priority;

	public Task(String desc, int prior) { // constructor takes a description and priority
		description = desc;
		if (prior < 0)
			System.err.println("Priority must be a positive integer!");
		else
			priority = prior;
	}

	abstract String getDescription();
	abstract int getPriority();
	abstract int compare(Task t);

}

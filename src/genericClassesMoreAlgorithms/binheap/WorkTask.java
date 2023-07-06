package genericClassesMoreAlgorithms.binheap;

/**
 * implementation of abstract class Task.
 * 
 * @author Robin
 *
 */
public class WorkTask extends Task {

	public WorkTask(String desc, int prior) {
		super(desc, prior);
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public int getPriority() {
		return priority;
	}

	/**
	 * compare method for highest priority in Task.
	 */
	@Override
	public int compare(Task t) {
		if (this.priority < t.priority)
			return -1;
		if (this.priority > t.priority)
			return 1;
		else
			return 0;
	}

}

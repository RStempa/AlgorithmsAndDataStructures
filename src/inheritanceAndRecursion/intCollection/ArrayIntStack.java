/**
 * 
 */
package rs222nv_assignment1.intCollection;

/**
 * @author Robin
 *
 */
public class ArrayIntStack extends AbstractIntCollection implements IntStack {

	public ArrayIntStack() {
		size = 0;
	}
	/* Add integer at top of stack. */
	@Override
	public void push(int n) {
		if (super.checkIndex(size, values.length - 1)) {
			values[size] = n;
			size++;
		} else {
			super.resize();
			values[size] = n;
			size++;
		}
	}
	/* Returns and removes integer at top of stack  */
	@Override
	public int pop() throws IndexOutOfBoundsException {
		if (!super.isEmpty()) {
			int x = values[size - 1];
			size--;
			return x;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	/* Returns without removing integer at top of stack */
	@Override
	public int peek() throws IndexOutOfBoundsException {
		if (!super.isEmpty()) {
			return values[size - 1];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	/* Number of integers currently stored. */
	public int size() {
		return super.size;
	}

	/* Returns true if collection is empty. */
	public boolean isEmpty() {
		return super.isEmpty();

	}

	/* String of type "[ 7 56 -45 68 ... ]" */
	public String toString() {
		return super.toString();

	}

}

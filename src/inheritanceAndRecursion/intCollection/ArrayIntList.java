/**
 * 
 */
package rs222nv_assignment1.intCollection;

/**
 * @author Robin
 *
 */
public class ArrayIntList extends AbstractIntCollection implements IntList {

	public ArrayIntList() {
		size = 0;
	}

	@Override
	public void add(int n) {
		// adds integer to list values
		if (super.iterator().hasNext()) {
			values[size] = n;
			size++;
		} else {
			super.resize();
			values[size] = n;
			size++;
		}
	}

	@Override
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		// Adds integer at certain index
		if (super.checkIndex(index, size)) {
			for (int i = size; i > index; i--) {
				values[i] = values[i - 1];
			}
			values[index] = n;
			size++;
		} else
			throw new IndexOutOfBoundsException();
	}

	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		// remove integer from index
		if (super.checkIndex(index, size - 1)) {
			for (int i = index; i <= size - 1; i++) {
				values[i] = values[i + 1];
			}
		} else {
			throw new IndexOutOfBoundsException();
		}
		size--;
	}

	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		// gets element from index
		if (index < size) {
			return values[index];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int indexOf(int n) {
		// returns index of n otherwise -1
		for (int i = 0; i < size; i++) {
			if (values[i] == n)
				return i;
		}
		return -1;
	}
	@Override
	//  String of type "[ 7 56 -45 68 ... ]"
	public String toString() {
		return super.toString();
	}
}

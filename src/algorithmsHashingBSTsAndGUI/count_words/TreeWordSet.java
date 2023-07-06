/**
 * 
 */
package algorithmsHashingBSTsAndGUI.count_words;

import java.util.Iterator;

/**
 * @author Robin
 * 
 *         Implements the interface wordset using binary search tree. Contains a
 *         private inner class BST.
 *
 */
public class TreeWordSet implements WordSet {

	private BST root;
	private int size;

	public TreeWordSet() {
		root = null;
		size = 0;
	}

	@Override
	public void add(Word word) {
		if (root == null) {
			root = new BST(word);
			size++;
		} else {
			root.add(word);
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Iterator<Word> iterator() {
		root.write();
		return null;
	}

	@Override
	public boolean contains(Word word) {
		return new BST(word).contains(word);
	}

	/**
	 * private inner class
	 * 
	 * @author Robin
	 *
	 */

	private class BST {
		private Word value;
		private BST left = null;
		private BST right = null;

		public BST(Word word) {
			value = word;
		}

		public void add(Word word) {
			if (word.compareTo(value) > 0) {
				if (left == null) {
					left = new BST(word);
					size++;
				} else
					left.add(word);

			} else if (word.compareTo(value) < 0) {
				if (right == null) {
					right = new BST(word);
					size++;
				} else
					right.add(word);
			}
		}

		public boolean contains(Word word) {
			if (word.compareTo(value) > 0) {
				if (left == null)
					return false;
				else
					return left.contains(word);
			} else if (word.compareTo(value) < 0) {
				if (right == null)
					return false;
				else
					right.contains(word);
			}
			return true;
		}

		public void write() {
			if (right != null) {
				right.write();
			}
			System.out.println(value);
			if (left != null) {
				left.write();
			}
		}
	}
}

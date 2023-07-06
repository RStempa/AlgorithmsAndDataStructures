/**
 * 
 */
package algorithmsHashingBSTsAndGUI.count_words;

import java.util.Iterator;

/**
 * @author Robin
 * 
 *         Implements the interface wordset using hashing. Contains a private
 *         inner class node.
 *
 */
public class HashWordSet implements WordSet {

	private int size;
	private Node[] buckets;

	public HashWordSet() {
		size = 0;
		buckets = new Node[20];
	}

	@Override
	public Iterator<Word> iterator() {
		for (Node n : buckets) {
			if (n == null) {
				continue;
			}
			while (n != null) {
				System.out.println(n.value);
				n = n.next;
			}
		}
		return null;
	}

	@Override
	public void add(Word word) {
		int pos = getBucketNumber(word);
		Node node = buckets[pos];

		while (node != null) {
			if (node.value.equals(word))
				return;
			else
				node = node.next;
		}
		node = new Node(word);
		node.next = buckets[pos];
		buckets[pos] = node;
		size++;
		if (size == buckets.length)
			rehash();
	}

	@Override
	public boolean contains(Word word) {
		boolean b = false;
		for (int i = 0; i < buckets.length; i++) {
			Node w = buckets[i];
			Word s = w.value;
			if (s.equals(word))
				b = true;
		}
		return b;
	}

	@Override
	public int size() {
		return getSize();
	}

	private int getSize() {
		return this.size;
	}

	private void rehash() {
		Node[] temp = new Node[size * 2];
		System.arraycopy(buckets, 0, temp, 0, buckets.length);
		buckets = temp;
	}

	private int getBucketNumber(Word w) {
		int hc = w.hashCode();
		if (hc < 0)
			hc = -hc;
		return hc % buckets.length;
	}

	/**
	 * private inner class node
	 * 
	 * @author Robin
	 *
	 */
	private class Node {
		private Word value;
		private Node next = null;

		public Node(Word w) {
			value = w;
		}

		public String toString() {
			return value.toString();
		}
	}
}

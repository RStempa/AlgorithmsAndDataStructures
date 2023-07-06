package algorithmsHashingBSTsAndGUI.sort;

import java.util.Comparator;

/**
 * 
 * @author Robin
 * 
 *         This program presents four sorting algorithms. Insertion sort and
 *         merge sort for both integers and strings.
 * 
 *         I watched tutorial about megesorting integers
 *         https://www.youtube.com/watch?v=0X_DZSmW66Q 
 *
 */

public class SortingAlgorithms {

	public static Comparator<String> c = (s1, s2) -> s1.compareTo(s2);

	// insertion sort for integer array
	public static int[] insertionSort(int[] in) {
		int[] out = new int[in.length];
		System.arraycopy(in, 0, out, 0, in.length);

		for (int i = 1; i < out.length; i++) {
			int temp = out[i];

			for (int j = i - 1; j >= 0 && temp < out[j]; j--) {
				out[j + 1] = out[j];
				out[j] = temp;
			}
		}
		return out;
	}

	// insertion sort for string array
	public static String[] insertionSort(String[] in, Comparator<String> c) { 

		String[] out = new String[in.length];
		System.arraycopy(in, 0, out, 0, in.length);

		for (int i = 1; i < out.length; i++) {
			String temp = out[i];

			for (int j = i - 1; j >= 0 && c.compare(temp, out[j]) < 0; j--) {
				out[j + 1] = out[j];
				out[j] = temp;
			}
		}
		return out;
	}

	// merge sort for integer
	public static int[] mergeSort(int[] in) {
		int[] out = new int[in.length];
		System.arraycopy(in, 0, out, 0, in.length);

		if (out.length == 1)
			return out;
		else {
			int n = (int) Math.floor(out.length / 2);
			int[] b = new int[n];
			int[] c = new int[out.length - n];

			for (int i = 0; i < out.length; i++) {
				if (i < n)
					b[i] = out[i];
				else
					c[i - n] = out[i];
			}
			b = mergeSort(b);
			c = mergeSort(c);
			out = merge(b, c);
			return out;
		}

	}

	// merge part of merge sort
	public static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int j = 0;
		int k = 0;
		for (int i = 0; i < a.length + b.length; i++) {
			if (j == a.length) {
				c[i] = b[k];
				++k;
			} else if (k == b.length) {
				c[i] = a[j];
				++j;
			} else if (a[j] > b[k]) {
				c[i] = b[k];
				++k;
			} else {
				c[i] = a[j];
				++j;
			}
		}
		return c;
	}

	// merge sort for string array
	public static String[] mergeSort(String[] in, Comparator<String> cs) {
		String[] out = new String[in.length];
		System.arraycopy(in, 0, out, 0, in.length);

		if (in.length == 1)
			return out;
		else {
			int n = (int) Math.floor(out.length / 2);
			String[] b = new String[n];
			String[] c = new String[out.length - n];

			for (int i = 0; i < out.length; i++) {
				if (i < n)
					b[i] = out[i];
				else
					c[i - n] = out[i];
			}
			b = mergeSort(b, cs);
			c = mergeSort(c, cs);
			out = merge(b, c);
			return out;
		}
	}

	// merge part of merge sort
	public static String[] merge(String[] a, String[] b) {
		String[] c = new String[a.length + b.length];
		int j = 0;
		int k = 0;
		for (int i = 0; i < a.length + b.length; i++) {
			if (j == a.length) {
				c[i] = b[k];
				++k;
			} else if (k == b.length) {
				c[i] = a[j];
				++j;
			} else if (a[j].compareTo(b[k]) > 0) {
				c[i] = b[k];
				++k;
			} else {
				c[i] = a[j];
				++j;
			}
		}
		return c;
	}
}

/**
 * 
 */
package genericClassesMoreAlgorithms.time;

import java.util.Random;

import algorithmsHashingBSTsAndGUI.sort.SortingAlgorithms;

/**
 * @author Robin Class checking time efficiency of sorting algoritms merge and
 *         insertion sort.
 */
public class SortingTimeMain {
	private static String str = "ABCDEFGHIJKLMNOPQRSTUVXYZabcdefghijklmnopqrst";
	private static int[] intarr = new int[10];
	private static String[] stringarr = new String[10];
	private static Random ran = new Random();

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			int j = ran.nextInt(43);
			String s = str.substring(j, j + 1);
			intarr[i] = j;
			stringarr[i] = s;
		}

		int count = 0;
		long time = 0;
		long before = System.nanoTime();

		before = System.nanoTime();
		while (time / 1000000000 <= 1) {
			SortingAlgorithms.mergeSort(intarr);
			time = System.nanoTime() - before;
			count++;
		}
		System.out.println("Merge sort sorted integers " + count * 10 + " in one second.");
		count = 0;
		time = 0;

		before = System.nanoTime();
		while (time / 1000000000 <= 1) {
			SortingAlgorithms.mergeSort(stringarr, SortingAlgorithms.c);
			time = System.nanoTime() - before;
			count++;
		}
		System.out.println("Merge sort sorted strings " + count * 10 + " in one second.");
		count = 0;
		time = 0;

		before = System.nanoTime();
		while (time / 1000000000 <= 1) {
			SortingAlgorithms.insertionSort(intarr);
			time = System.nanoTime() - before;
			count++;
		}
		System.out.println("Insertion sorted integer " + count * 10 + "in one second.");
		count = 0;
		time = 0;

		before = System.nanoTime();
		while (time / 1000000000 <= 1) {
			SortingAlgorithms.insertionSort(stringarr, SortingAlgorithms.c);
			time = System.nanoTime() - before;
			count++;
		}
		System.out.println("Insertion sorted strings " + count * 10 + " in one second.");
		count = 0;
		time = 0;
	}

}

/**
 * 
 */
package algorithmsHashingBSTsAndGUI.sort;

import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.Random;

import org.junit.Test;

/**
 * @author Robin The program runs the sorting algorithms selection sort and
 *         merge sort as a JUnit test.
 */
public class SortTest {

	String str = "When you need to focus, Distraction Free Mode is there to help you out. "
			+ "Distraction Free Mode is full screen, chrome free editing, with nothing "
			+ "but your text in the center of the screen. You can incrementally "
			+ "show elements of the UI, such as tabs and the find panel, as you need them.";

	int[] arr = new int[] { 10, 7, 5, 1, 9, 8, 12, 3, 4, 2, 11, 6 };
	String[] arrStr = new String[] { "E", "D", "F", "B", "A", "C", "j", "D", "G", "I", "H" };
	int[] none = new int[] { 1 };
	String[] oneStr = new String[] { "A" };
	int[] largeInt = intArr(100, 100);
	String[] largeStr = stringArr(100);
	
	Comparator<String> c = SortingAlgorithms.c;

	@Test
	public void test() {

		int[] arr1 = SortingAlgorithms.insertionSort(arr);
		int[] arr2 = SortingAlgorithms.mergeSort(arr);
		String[] arr3 = SortingAlgorithms.insertionSort(arrStr, c); 
		String[] arr4 = SortingAlgorithms.mergeSort(arrStr, c);
		int[] arr5 = SortingAlgorithms.insertionSort(none);
		String[] arr6 = SortingAlgorithms.mergeSort(oneStr, c);
		int[] arr7 = SortingAlgorithms.insertionSort(largeInt);
		int[] arr8 = SortingAlgorithms.mergeSort(largeInt);
		String[] arr9 = SortingAlgorithms.insertionSort(largeStr, c);
		String[] arr10 = SortingAlgorithms.mergeSort(largeStr, c);

		for (int i = 0; i < arr1.length - 1; i++) {
			assertTrue(arr1[i] <= arr1[i + 1]);
		}
		for (int i = 0; i < arr2.length - 1; i++) {
			assertTrue(arr2[i] <= arr2[i + 1]);
		}
		for (int i = 0; i < arr3.length - 1; i++) {
			assertTrue(arr3[i].compareTo(arr3[i + 1]) <= 0);
		}
		for (int i = 0; i < arr4.length - 1; i++) {
			assertTrue(arr4[i].compareTo(arr4[i + 1]) <= 0);
		}
		for (int i = 0; i < arr5.length - 1; i++) {
			assertTrue(arr5[i] <= arr5[i + 1]);
		}
		for (int i = 0; i < arr6.length - 1; i++) {
			assertTrue(arr6[i].compareTo(arr6[i + 1]) <= 0);
		}
		for (int i = 0; i < arr7.length - 1; i++) {
			assertTrue(arr7[i] <= arr7[i + 1]);
		}
		for (int i = 0; i < arr8.length - 1; i++) {
			assertTrue(arr8[i] <= arr8[i + 1]);
		}
		for (int i = 0; i < arr9.length - 1; i++) {
			assertTrue(arr9[i].compareTo(arr9[i + 1]) <= 0);
		}
		for (int i = 0; i < arr10.length - 1; i++) {
			assertTrue(arr10[i].compareTo(arr10[i + 1]) <= 0);
		}

	}

	public int[] intArr(int size, int max) {
		Random ran = new Random();
		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {
			int j = 1 + ran.nextInt(max);
			arr[i] = j;
		}
		return arr;
	}

	public String[] stringArr(int size) {
		Random ran = new Random();
		String[] arr = new String[size];

		for (int i = 0; i < size; i++) {
			int j = 1 + ran.nextInt(str.length() - 4);
			arr[i] = str.substring(j, j + 3);
		}
		return arr;
	}
}

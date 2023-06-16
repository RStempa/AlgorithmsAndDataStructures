package inheritanceAndRecursion.chart;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HistogramXY {

		public static void main(String[] args) throws FileNotFoundException {
	// Histogram counts integers within a certain margin. Sending the file path from String args.

			String path = args[0];

			File input = new File(path);

			Scanner in = new Scanner(input);

			ArrayList<Integer> list = new ArrayList<Integer>();

			while (in.hasNext()) {
				int i = in.nextInt();
				list.add(i);
			}

			in.close();

			System.out.println("Läser heltal från filen: C:\\Users\\Robin\\Desktop\\lab4.txt");
			System.out.println("Antal i intervallet [1,100]: " + intervall(list, 1, 100));
			System.out.println("Övriga: " + (list.size() - intervall(list, 1, 100)));
			System.out.println("Histogram");
			System.out.println("1   - 10  | " + printStar(intervall(list, 1, 10)));
			System.out.println("11  - 20  | " + printStar(intervall(list, 11, 20)));
			System.out.println("21  - 30  | " + printStar(intervall(list, 21, 30)));
			System.out.println("31  - 40  | " + printStar(intervall(list, 31, 40)));
			System.out.println("41  - 50  | " + printStar(intervall(list, 41, 50)));
			System.out.println("51  - 60  | " + printStar(intervall(list, 51, 60)));
			System.out.println("61  - 70  | " + printStar(intervall(list, 61, 70)));
			System.out.println("71  - 80  | " + printStar(intervall(list, 71, 80)));
			System.out.println("81  - 90  | " + printStar(intervall(list, 81, 90)));
			System.out.println("91  - 100 | " + printStar(intervall(list, 91, 100)));

		}

		private static int intervall(ArrayList<Integer> list, int a, int b) {
			int counter = 0;
			for (int i = 0; i < list.size(); i++)
				if (list.get(i) >= a && list.get(i) <= b) {
					counter++;
				}

			return counter;
		}

		private static StringBuffer printStar(int x) {
			String s = "*";
			StringBuffer b = new StringBuffer();
			for (int i = 0; i < x; i++) {
				b.append(s);
			}
			return b;
		}


}

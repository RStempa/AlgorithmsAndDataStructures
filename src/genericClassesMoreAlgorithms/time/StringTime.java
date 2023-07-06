package genericClassesMoreAlgorithms.time;

/**
 * @author Robin
 * 
 *         Main class showing the number of concatenations using the + operator
 *         and the string builder class in one second. Also giving the length of
 *         each string after concatenation.
 *
 */
public class StringTime {
	
	private static String shortstr = "a";
	private static String longstr = "aaaaaaaaaa aaaaaaaaaa aaaaaaaaaa aaaaaaaaaa aaaaaaaaaa aaaaaaaaaa aaaaaaaaaa aaaaaaaaaa";

	public static void main(String[] args) {
		System.out.println(append(shortstr));
		System.out.println(append(longstr));
		System.out.println(concat(shortstr));
		System.out.println(concat(longstr));
	}

	private static String append(String s) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		long before = System.nanoTime();
		long time = 0;

		while (time / 1000000000 <= 1) {
			sb.append(s);
			time = System.nanoTime() - before;
			count++;
		}
		return "StrinBuilder strings length is " + sb.toString().length() + ". Appended " + count + " times in 1 sec.";
	}
	
	public static String concat(String s) {
		String str = s;
		int count = 0;
		long before = System.nanoTime();
		long time = 0;

		while (time / 1000000000 <= 1) {
			str += s;
			time = System.nanoTime() - before;
			count++;
		}
		return "Concatenating strings length is " + str.length() + ". Appended " + count + " times in 1 sec.";
	}

}

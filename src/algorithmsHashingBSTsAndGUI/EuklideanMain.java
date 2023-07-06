/**
 * 
 */
package algorithmsHashingBSTsAndGUI;

/**
 * @author Robin This is the Euklidean algorithm computing the greatest common
 *         denominator.
 */
public class EuklideanMain {

	public static void main(String[] args) {

		int gcd = GCDrec(42, 56);
		System.out.println(gcd);
		int gcd2 = GCD(42, 56);
		System.out.println(gcd2);

	}

	/**
	 * A recursive method for the GCD.
	 * 
	 * @param a
	 * @param b
	 * @return the greatest common denominator of a and b.
	 */

	public static int GCDrec(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

	/**
	 * Non recursive method for GCD:
	 * 
	 * @param one
	 * @param two
	 * @return the greatest common denominator of integer one and two;
	 */

	public static int GCD(int one, int two) {
		int a = one;
		int b = two;
		int c;
		
		while (b > 0) {
			c = a % b;
			a = b;
			b = c;
		}
		int gcd = a;
		return gcd;
	}

}

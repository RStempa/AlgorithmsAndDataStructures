/**
 * 
 */
package inheritanceAndRecursion;

/**
 * @author Robin
 *
 */
public class SumMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int sum;
		sum = sumUpToN(4);
		System.out.println(sum);
	}

	public static int sumUpToN(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return (n / 2 + sumUpToN(n / 2)) + (n + sumUpToN((n - 1) - (n / 2 + sumUpToN(n / 2 - 1))));
	}

}

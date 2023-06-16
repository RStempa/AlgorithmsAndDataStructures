/**
 * 
 */
package inheritanceAndRecursion.ferry;

/**
 * @author Robin
 *
 */
public class Lorry extends Vehicle {

	public Lorry(int p) {
		super(p);
		maxPass = 2;
		if (maxPass >= p) {
			size = 8;
			cost = 300 + passengers * 15;
		} else {
			super.tooMany();
		}
	}
}

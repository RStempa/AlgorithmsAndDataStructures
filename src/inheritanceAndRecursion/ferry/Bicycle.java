/**
 * 
 */
package inheritanceAndRecursion.ferry;

/**
 * @author Robin
 *
 */
public class Bicycle extends Vehicle {

	public Bicycle(int p) {
		super(p);
		maxPass = 1;
		if (maxPass >= p) {
			size = 0.25;
			cost = 40;
		} else {
			super.tooMany();
		}
	}
}

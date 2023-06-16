/**
 * 
 */
package inheritanceAndRecursion.ferry;

/**
 * @author Robin
 *
 */
public class Car extends Vehicle {

	public Car(int p) {
		super(p);
		maxPass = 4;
		if (maxPass >= p) {
			size = 1;
			cost = 100 + passengers * 15;
		} else {
			super.tooMany();
		}
	}
}

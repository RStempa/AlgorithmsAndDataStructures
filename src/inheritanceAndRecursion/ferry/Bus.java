/**
 * 
 */
package inheritanceAndRecursion.ferry;

/**
 * @author Robin
 *
 */
public class Bus extends Vehicle {

	public Bus(int p) {
		super(p);
		maxPass = 20;
		if (maxPass >= p){
			size = 4;
			cost = 200 + passengers * 10;
		} else {
			super.tooMany();
		}		
	}
}

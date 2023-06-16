/**
 * 
 */
package inheritanceAndRecursion.ferry;

/**
 * @author Robin
 *
 */
public abstract class Vehicle {
	protected int maxPass;
	protected int passengers;
	protected int cost;
	protected double size;

	public Vehicle(int p) {
		passengers = p;
	}

	int getCost() {
		return cost;
	}

	double getSize() {
		return size;
	}

	public int getPass() {
		return passengers;
	}

	protected void tooMany() {
		passengers = 0;
		size = 0;
		cost = 0;
		System.err.println("too many passangers on this " + this.getClass().getSimpleName());
	}
}

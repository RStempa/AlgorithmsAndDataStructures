/**
 * 
 */
package inheritanceAndRecursion.ferry;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Robin
 *
 */
public class Ferry implements FerryInterface {

	protected int space;
	protected int passengers;
	protected int usedSpace;
	protected int size;
	protected int money;
	protected ArrayList<Vehicle> ferry;

	public Ferry() {
		space = 200;
		size = 40;
		money = 0;
		passengers = 0;
		usedSpace = 0;
		ferry = new ArrayList<Vehicle>();

	}

	@Override
	public int countPassengers() {
		return passengers;
	}

	@Override
	public int countVehicleSpace() {
		return usedSpace;
	}

	@Override
	public int countMoney() {
		return money;
	}

	@Override
	public Iterator<Vehicle> iterator() {
		// Vehicle iterator
		return new VehicleIterator(ferry, ferry.size() - 1);
	}

	@Override
	public void embark(Vehicle v) {
		if (size < v.size + usedSpace) {
			System.err.println("Not enough room for vehicle.");
		} else if (ferry.contains(v)) {
			System.err.println("Vehicle has already embarked.");
		} else if (v.getPass() + passengers > space) {
			System.err.println("Not enough room left for passengers.");
		} else {
			ferry.add(v);
			passengers += v.getPass();
			usedSpace += v.getSize();
			money += v.getCost();
		}
	}

	@Override
	public void embark(Passenger p) {
		if (passengers < space) {
			passengers++;
			money += 20;
		} else
			System.err.println("Not enough room left for passenger!");
	}

	@Override
	public void disembark() {
		ferry.clear();
		passengers = 0;
		usedSpace = 0;
	}

	@Override
	public boolean hasSpaceFor(Vehicle v) {
		return usedSpace + v.getSize() < size;
	}

	@Override
	public boolean hasRoomFor(Passenger p) {
		return passengers < space;
	}

	public String toString() {
		return "Ferry has " + ferry.size() + " vehicles onboard. " + "\n" + "Ferry has " + countPassengers()
				+ " passengers on board " + "\n" + "It has room for " + (space - passengers) + " passengers " + "\n"
				+ "It has " + (size - usedSpace) + " units of space for vehicles " + "\n" + "Money is " + countMoney();
	}

	/**
	 * 
	 * @author Robin
	 * 
	 *         This is a private inner class used by the iterator method,
	 *         creating a vehicle iterator. It has the methods next returning
	 *         the next vehicle and has next returning true or false depending
	 *         on if there is any more vehicles on board.
	 */

	private class VehicleIterator implements Iterator<Vehicle> {

		private int nextVehicle = 0;
		private Vehicle[] vehicles;
		private final int MAX;

		public VehicleIterator(ArrayList<Vehicle> list, int size) {

			Vehicle[] v = new Vehicle[list.size()];
			vehicles = ferry.toArray(v);
			MAX = size;
		}

		@Override
		public boolean hasNext() {
			return nextVehicle < MAX;
		}

		@Override
		public Vehicle next() {
			return (Vehicle) vehicles[nextVehicle++];
		}

	}

}

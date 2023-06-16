/**
 * 
 */
package inheritanceAndRecursion.ferry;

/**
 * @author Robin
 *
 */
public class FerryMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Ferry ferry = new Ferry();
		Car car = new Car(4);
		Bicycle b = new Bicycle(1);
		Lorry l = new Lorry(2);
		Lorry m = new Lorry(2);
		Lorry n = new Lorry(2);
		Lorry o = new Lorry(2);
		Bus bus = new Bus(20);
		ferry.embark(b);
		ferry.embark(car);
		ferry.embark(bus);
		ferry.embark(l);
		ferry.embark(m);
		ferry.embark(n);
		ferry.embark(o);
		System.out.println(ferry.toString());
		Bus bus2 = new Bus(20);
		ferry.embark(bus2);
		System.out.println(ferry.toString());
		
		for (int i = 0; i < 168; i++){
			Passenger p = new Passenger();
			ferry.embark(p);
		}
		System.out.println(ferry.toString());
		System.out.println(ferry.hasSpaceFor(bus) + " has space for bus." + ferry.hasSpaceFor(car) + " has space for car.");

	}

}

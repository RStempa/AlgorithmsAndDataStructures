/**
 * 
 */
package rs222nv_assignment1.intCollection;

/**
 * @author Robin
 *
 */
public class CollectionMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Testing ArrayIntStack and ArrayIntList

		ArrayIntList a = new ArrayIntList();
		a.add(3);
		a.add(5);
		System.out.println(a.get(1));
		System.out.println(a.indexOf(5));
		a.addAt(8, 0);
		System.out.println(a.toString());
		a.remove(0);
		System.out.println(a.toString());

		ArrayIntStack s = new ArrayIntStack();
		s.push(2);
		System.out.println("Top element is " + s.peek());
		System.out.println(s.pop());
		s.push(3);
		System.out.println(s.toString());
		System.out.println(s.size);
		System.out.println(a.isEmpty());
	}

}

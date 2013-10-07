
public class LinkedListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Character> aList = new LinkedList<Character>();
		aList.add('A');
		aList.add('B');
		aList.add('C');
		System.out.println(aList);
		System.out.println(aList.contains('A'));
		System.out.println(aList.contains('B'));
		System.out.println(aList.contains('C'));
		System.out.println(aList.contains('D'));
		System.out.println("POP:" + aList.pop());
		//System.out.println("POP:" + ((LinkedListNode)aList.pop()).getElement());
	}

}

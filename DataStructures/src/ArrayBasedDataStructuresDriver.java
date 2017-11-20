/**
 *  @Author Samuel L. Peoples, 1527650
 *  Driver for Testing ArrayLists, Queue, and Stack
 */

public class ArrayBasedDataStructuresDriver {

	public static void main(String[] args) {
		stackTests();
		queueTests();
		arrayListTests();
	}

	private static void arrayListTests() {
		System.out.println("---===---ARRAYS---===---");
		//todo: make more tests here
		ArrayList a = new ArrayList();
		
		a.insert('B', 0);
		a.insert('a',0);
		a.insert('t',1);
		a.insert('q', 1);
		a.insert('H', 4);
		a.insert('Z', 5);
		a.insert('M', a.size());
		ArrayList b = new ArrayList();
		//b = a;  this copies the location and treats them as the same object. Need to copy.
		for(int i=0;i<a.size();i++)
			b.insert(a.get(i), i);
		ArrayList c = new ArrayList();
		c.insert('a', 0);
		System.out.println("Sizes a,b,c: "+a.size()+", "+b.size()+", "+c.size()+", ");
		System.out.println("a: "+a.toString());
		System.out.println("b: "+b.toString());
		System.out.println("c: "+c.toString());
		System.out.println("a = b: "+a.equals(b));
		System.out.println("a = c: "+a.equals(c));
		b.insert('p',0);
		System.out.println("b: "+b.toString());
		System.out.println("a = b: "+a.equals(b));
		System.out.println("a:B: "+a.indexOf('B'));
		System.out.println("a:Q: "+a.indexOf('Q'));
		while(a.isEmpty() == false) {
			System.out.println("Removed: "+a.remove(0)+"; remaining: "+a.toString());
		}
		//Index out of bounds ends program.
		//System.out.println("Inserting \"X\" to a[10]:");
		//a.insert('X',10);
		
	}

	private static void queueTests() {
		System.out.println("---===---QUEUES---===---");
		//todo: make more tests here
		Queue a = new Queue();
		
		a.enqueue('B');
		a.enqueue('a');
		a.enqueue('t');
		System.out.println(a.toString());
		
		Queue b = new Queue();
		
		b.enqueue('B');
		b.enqueue('B');
		b.enqueue('a');
		b.enqueue('t');
		System.out.println(b.toString());
		System.out.println("a=b?: "+a.equals(b));
		System.out.println("Dequeuing: "+b.dequeue()+", Remaining: "+b.toString());
		System.out.println("a=b?: "+a.equals(b));
		System.out.println("a At 0: "+a.get(0));
		System.out.println("b At 2: "+b.get(2));
		
		while(a.isEmpty() == false) {
			System.out.println(a.dequeue()+", remaining: "+a.toString());
		}

	}

	private static void stackTests() {
		System.out.println("---===---STACKS---===---");
		//todo: make more tests here
		Stack a = new Stack();
		
		a.push('B');
		a.push('a');
		a.push('t');
		a.push('B');
		a.push('a');
		a.push('t');
		a.push('B');
		a.push('a');
		a.push('t');
		a.push('B');
		a.push('a');
		a.push('t');
		a.push('B');
		a.push('a');
		a.push('t');
		a.push('B');
		a.push('a');
		a.push('t');
		Stack a1 = new Stack();
		
		a1.push('B');
		a1.push('a');
		a1.push('t');
		Stack a2 = new Stack();
		
		a2.push('B');
		a2.push('a');
		a2.push('t');
		System.out.println(a.toString());
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		System.out.println(a1.equals(a));
		System.out.println(a1.equals(a2));
		a1.push('N');
		System.out.println(a1.toString());
		System.out.println(a1.equals(a));
		while(a.isEmpty() == false) {
			System.out.println(a.pop());
		}
	}
	

}

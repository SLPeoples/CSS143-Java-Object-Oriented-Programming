import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class test {
	public static void main(String args[]){
		removeBadPairs();
		int[] a = {3, 8, 17, 9, 17, 8, 3};
		isPalindrome(a);
		int[] b = {3, 8, 17, 9, 8, 8, 3};
		isPalindrome(b);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] c = {5,4,3,8,1,2};
		for (Integer i: c)
			list.add(i);
		System.out.println(collapse(list));
		mystery5();
	}
	public static void removeBadPairs(){
		Integer[] array = {3, 7, 9, 2, 5, 5, 8, 5, 6, 3, 4, 7, 3, 1};
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
		int count = list.size();
		int index = 0;
		while (index < count){
			if (list.get(index) > list.get(index+1)){
				list.remove(index);list.remove(index);
				count -= 2;}
			else
				index += 2;}
		System.out.println(list.toString());
		}
	
	public static void isPalindrome(int[] input){
		LinkedList<Integer> q = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		//Populate q with input
		for (Integer elt: input)
			q.add(elt);
		
		//Populate a stack with half of q
		int halfLen = input.length/2;
		for (int i = 0; i < halfLen; i++)
			stack.push(q.removeFirst());
		
		//Remove the extra entry if there were originally odd elements
		boolean odd = (input.length %2 == 1);
		if (odd)
			q.removeFirst();
		
		boolean result = true;
		for (int i = 0; i < q.size(); i++){
			if (q.removeFirst() != stack.pop()){
				result = false;
				break;
				}
			}
		//String
		String string = "{";
		for(int i=1;i<input.length;i++){
			if(i<input.length-1)
				string+=input[i]+", ";
			else
				string+=input[i];
		}
		string+="}";
		//Print
		System.out.println("Is "+string+" a palindrome? "+result);
	}
	
	public static ArrayList collapse(ArrayList c){
		ArrayList<Integer> col = new ArrayList<>();
		for(int i=0;i<c.size()-1;i++){
			col.add((int) c.get(i)+(int) c.get(i+1));
			i++;
		}
		return col;
	}
	public static void mystery5(){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(-1);
		list.add(3);
		list.add(28);
		list.add(17);
		list.add(9);
		list.add(33);
			for(int i = 0; i < list.size(); i++) {
				int element = list.get(i);
				list.remove(i);
				list.add(0, element + 1);
				}
		System.out.println(list);
	}
}

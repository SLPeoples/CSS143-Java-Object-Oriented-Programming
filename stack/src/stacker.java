import java.util.Stack;

public class stacker {
public static void main(String args[]){
	Stack<Integer> a = new Stack<>();
	for(int i=0;i<10;i++)
		a.push(i);
	//This is original stack passed in
	System.out.println(a.toString());
	
	Stack<Integer> tempStack = new Stack<>();
	Stack<Integer> newStack = new Stack<>();
	for(int i=0;i<10;i++)
		tempStack.push(a.pop());
	for(int i=0;i<10;i++){
		int j = tempStack.pop();
		newStack.push(j);
		a.push(j);
	}
	System.out.println(newStack.toString());
	System.out.println(a.toString());
}
}

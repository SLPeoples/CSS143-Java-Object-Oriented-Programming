/**
 * @author Samuel L. Peoples, 1527650
 * stack Class, LIFO
 *
 */
public class Stack {
	private Object[] stack = new Object[1];
	public static void main(String[] args) {}

	/**
	 * Places a new element at the front of the line
	 * @param c, Object to be placed
	 */
	public void push(Object object) {
		Object[] other = new Object[this.size()+1];
		other[0] = object;
		System.arraycopy(this.stack, 0, other, 1, this.size());
		this.stack = other;
	}
	
	/**
	 * Removes element at the end of the list.
	 * @return removed, object removed
	 */
	public Object pop() {
		Object removed = this.stack[0];
		Object[] other = new Object[this.stack.length-1];
		System.arraycopy(this.stack, 1, other, 0, this.size()-1);
    	this.stack = other;
		return removed;
	}
	
	/**
	 * Copies the stack to a new stack twice the size.
	 */
	public void largerStack(){
		Object[] other = new Object[this.stack.length*2];
		System.arraycopy(this.stack, 0, other, 0, this.stack.length);
		this.stack = other;
	}
	
	/**
	 * @return true if there are null elements
	 */
	public boolean isEmpty() {
		boolean bool = true;
		for (Object element : this.stack) {
			if(element!=null){
				bool = false;
				break;
			}
			else{
				bool = true;
				break;
		}
		}
		return bool;
	}
	
	/**
	 * Determines the real length of the stack
	 * @return length of non-null elements
	 */
	public int size(){
		int count = 0;
		for(int i=0;i<this.stack.length;i++){
			if(this.stack[i]==null)
				continue;
			else
				count++;
		}
		return count;
	}
	
	/**
	 * Converts stack to string.
	 * @return the stack as a string
	 */
	public String toString(){
		String string = "";
		for(int i=0;i<this.size();i++){
			if(i<this.size()-1)
				string += this.stack[i]+", ";
			else
				string += this.stack[i];
		}
		return string;
	}
	
	/**
	 * Similar to get, imput the character, retrieve index.
	 * @param object, what we're looking for
	 * @return index
	 */
	int indexOf(Object object){
		int index = -1;
		for(int i=0;i<this.stack.length;i++){
			if(this.stack[i]==(object))
				index = i;
			else continue;
		}
		return index;
	}
	/**
	 * @param object, stack tyoe
	 * @return true, if the elements of the stacks are equivalent.
	 */
	public boolean equals(Stack object){
		boolean bool = false;
		int thisLength = this.stack.length;
		int objectLength = object.stack.length;
		if(this.size()!=object.size())
			return false;
		if(thisLength > objectLength){
			for(int i=0;i<this.stack.length;i++)
				if(this.stack[i] == object.stack[i])
					bool = true;
				else{
					bool = false;
					break;
				}
		}
		else{
			for(int i=0;i<this.stack.length;i++)
				if(this.stack[i] == object.stack[i])
					bool = true;
				else{
					bool = false;
					break;
				}
		}
		return bool;
	}
	
	/**
	 * Getter to check what is at an index
	 * @param index, location
	 * @return the character at this position
	 */
	Object get(int index){
		return this.stack[index];
	}
}

	



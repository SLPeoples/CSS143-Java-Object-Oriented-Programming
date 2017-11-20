/**
 * @author Samuel L. Peoples, 1527650
 * Queue Class, FIFO
 *
 */
public class Queue {
	private Object[] queue = new Object[1];
	public static void main(String[] args) {}

	/**
	 * Places a new element at the back of the line
	 * @param c, Object to be placed
	 */
	public void enqueue(Object c) {
		int count = 0;
		try {
			this.queue[this.size()] = c;
		}
		catch(ArrayIndexOutOfBoundsException exception) {
		    largerQueue();
		    if(++count == 2){
		    	System.out.println("Something went wrong.");
		    	System.exit(0);
		    }
		    else
		    	this.enqueue(c);
		}
	}
	
	/**
	 * Removes element at the front of the list.
	 * @return temp, object removed
	 */
	public Object dequeue() {
		Object temp = this.queue[0];
		Object[] other = new Object[this.queue.length-1];
    	for(int j=0;j<this.size()-1;j++)
    		other[j] = this.queue[j+1];
    	this.queue = other;
		return temp;
	}
	
	/**
	 * Copies the queue to a new queue twice the size.
	 */
	public void largerQueue(){
		Object[] other = new Object[this.queue.length*2];
		System.arraycopy(this.queue, 0, other, 0, this.queue.length);
		this.queue = other;
	}
	
	/**
	 * @return true if there are null elements
	 */
	public boolean isEmpty() {
		boolean bool = true;
		for (Object element : this.queue) {
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
	 * Determines the real length of the queue
	 * @return length of non-null elements
	 */
	public int size(){
		int count = 0;
		for(int i=0;i<this.queue.length;i++){
			if(this.queue[i]==null)
				continue;
			else
				count++;
		}
		return count;
	}
	
	/**
	 * Converts queue to string.
	 * @return the Queue as a string
	 */
	public String toString(){
		String string = "";
		for(int i=0;i<this.size();i++){
			if(i<this.size()-1)
				string += this.queue[i]+", ";
			else
				string += this.queue[i];
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
		for(int i=0;i<this.queue.length;i++){
			if(this.queue[i]==(object))
				index = i;
			else continue;
		}
		return index;
	}
	/**
	 * @param object, Queue tyoe
	 * @return true, if the elements of the queues are equivalent.
	 */
	public boolean equals(Queue object){
		boolean bool = false;
		int thisLength = this.queue.length;
		int objectLength = object.queue.length;
		if(thisLength > objectLength){
			for(int i=0;i<object.queue.length;i++)
				if(this.queue[i] == object.queue[i])
					bool = true;
				else{
					bool = false;
					break;
				}
		}
		else{
			for(int i=0;i<this.queue.length;i++)
				if(this.queue[i] == object.queue[i])
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
		return this.queue[index];
	}
}

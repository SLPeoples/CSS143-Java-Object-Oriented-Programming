import java.util.Iterator;

/**
 * @author Samuel L. Peoples, 1527650
 * ArrayList Class
 *
 */
public class ArrayList implements Iterable<Object>{
    Object[] array = new Object[0];
	/**
	 * Places new element at location
	 * @param c, element to be inserted
	 * @param i, location it is to be placed
	 */
	public void insert(char c, int i) {
		if(i>this.size()){
			System.out.println("Index "+i +" outside of list size; max: " +this.size());
			System.exit(0);
		}
		int count = 0;
		try {
			Object[] other = new Object[this.array.length+1];
			switch(i){
		    case 0:{
		    	other[0] = c;
		    	for(int j=1;j<other.length;j++)
		    		other[j] = this.array[j-1];
		    	
		    	this.array = other;
		    	break;
		    }
		    default: {
		    	for(int j=0;j<i;j++)
		    		other[j] = this.array[j];
		    	other[i] = c;
		    	for(int k=i+1;k<other.length;k++)
		    		other[k] = this.array[k-1];
		    	this.array = other;
		    	break;
		    }
		    }
		}
		catch(ArrayIndexOutOfBoundsException exception) {
		    largerArray();
		    if(++count == 2){
		    	System.out.println("Something went wrong.");
		    	System.exit(0);
		    } 
		}
	}
	
	/**
	 * Places new element at location
	 * @param object, element to be inserted
	 * @param index, location it is to be placed
	 */
	void insert(Object object, int index){
		if(index>this.size()){
			System.out.println("Index "+index +" outside of list size; max: " +this.size());
			System.exit(0);
		}
		int count = 0;
		try {
			Object[] other = new Object[this.array.length+1];
			switch(index){
		    case 0:{
		    	other[0] = object;
		    	for(int j=1;j<other.length;j++)
		    		other[j] = this.array[j-1];
		    	
		    	this.array = other;
		    	break;
		    }
		    default: {
		    	for(int j=0;j<index;j++)
		    		other[j] = this.array[j];
		    	other[index] = object;
		    	for(int k=index+1;k<other.length;k++)
		    		other[k] = this.array[k-1];
		    	this.array = other;
		    	break;
		    }
		    }
		}
		catch(ArrayIndexOutOfBoundsException exception) {
		    largerArray();
		    if(++count == 2){
		    	System.out.println("Something went wrong.");
		    	System.exit(0);
		    } 
		}
	}
	/**
	 * Places new element at the end of the array
	 * @param object, element to be inserted
	 */
	void add(Object object){
		int count = 0;
		try {
			Object[] other = new Object[this.array.length+1];
		    for(int j=0;j<this.array.length;j++)
		    	other[j] = this.array[j];
		    other[this.array.length] = object;
		    this.array = other;
		}
		catch(ArrayIndexOutOfBoundsException exception) {
		    largerArray();
		    if(++count == 2){
		    	System.out.println("Something went wrong.");
		    	System.exit(0);
		    } 
		}
	}
	/**
	 * Removes element at index
	 * @param index, location to remove
	 * @return temp, object removed
	 */
	Object remove(int index){
		if(index>this.size()){
			System.out.println("Index "+index +" outside of list size; max: " +this.size());
			System.exit(0);
		}
		Object temp = this.array[index];
		int count = 0;
		try {
			Object[] other = new Object[this.array.length-1];
			switch(index){
		    case 0:{
		    	other[0] = this.array[1];
		    	for(int j=1;j<other.length;j++)
		    		other[j] = this.array[j+1];
		    	
		    	this.array = other;
		    	break;
		    }
		    default: {
		    	for(int j=0;j<index;j++)
		    		other[j] = this.array[j];
		    	for(int k=index;k<other.length;k++)
		    		other[k] = this.array[k+1];
		    	this.array = other;
		    	break;
		    }
		    }
		}
		catch(ArrayIndexOutOfBoundsException exception) {
		    largerArray();
		    if(++count == 2){
		    	System.out.println("Something went wrong.");
		    	System.exit(0);
		    } 
		}
		return temp;
	}
	
	/**
	 * Copies the array to a new array twice the size.
	 */
	public void largerArray(){
		Object[] other = new Object[this.array.length*2];
		System.arraycopy(this.array, 0, other, 0, this.array.length);
		this.array = other;
	}
	
	/**
	 * @return true if there are null elements
	 */
	public boolean isEmpty() {
		boolean bool = true;
		for (Object element : this.array) {
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
	 * Determines the real length of the array
	 * @return length of non-null elements
	 */
	public int size(){
		int count = 0;
		for(int i=0;i<this.array.length;i++){
			if(this.array[i]==null)
				break;
			else
				count++;
		}
		return count;
	}
	
	/**
	 * Converts array to string.
	 * @return the Array as a string
	 */
	public String toString(){
		String string = "";
		for(int i=0;i<this.size();i++){
			if(i<this.size()-1)
				string += this.array[i]+", ";
			else
				string += this.array[i];
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
		for(int i=0;i<this.array.length;i++){
			if(this.array[i]==(object))
				index = i;
			else continue;
		}
		return index;
	}
	
	/**
	 * @param object, Arraylist tyoe
	 * @return true, if the elements of the arrays are equivalent.
	 */
	public boolean equals(ArrayList object){
		boolean bool = false;
		int thisLength = this.array.length;
		int objectLength = object.array.length;
		if(thisLength > objectLength){
			for(int i=0;i<this.array.length;i++)
				if(this.array[i] == object.array[i])
					bool = true;
				else{
					bool = false;
					break;
				}
		}
		else{
			for(int i=0;i<object.array.length;i++)
				if(this.array[i] == object.array[i])
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
		return this.array[index];
	}

	/** 
	 * creates a new Iterator for the iterable implementation
	 * @return a new Iterator
	 */
	@Override
	public Iterator<Object> iterator() {
		return new MyIterator<Object>(this.array);
	}
}

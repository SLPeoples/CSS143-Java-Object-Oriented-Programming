import java.util.Iterator;

/**
 * @author Samuel L. Peoples, 1527650
 * Iterator class
 */
public class MyIterator<T> implements Iterator<Object> {
private Object[] list;
private int index;
	/**
	 * Constructs an iterator
	 * @param array, parent array
	 */
	public MyIterator(Object[] array){
		this.list = new Object[array.length];
		for(int i=0;i<this.list.length;i++){
			this.list[i]=array[i];
		}
		this.index = 0;
	}
	/** 
	 * hasNext method
	 * @return true if the array has a next element
	 */
	@Override
	public boolean hasNext() {
		return this.index < this.list.length;
	}

	/** 
	 * next method
	 * @return the next Object and increase the index.
	 */
	@Override
	public Object next() {
		this.index++;
		return this.list[index-1];
	}

}

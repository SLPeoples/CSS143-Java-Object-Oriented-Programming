/**
 * @author Samuel L. Peoples, 1527650
 * CharList constructor class
 */
public class CharList {
	private char[] charList = new char[100];
	private int numElements;
	/**
	 * Constructor from string
	 * @param string, sets string characters to the charlist
	 */
	public CharList(String string) {
		for(int i=0;i<string.length();i++){
			this.charList[i]=string.charAt(i);
			this.numElements++;
		}
	}

	/**
	 * Empty constructor 
	 */
	public CharList() {
	}

	/**
	 * Copy constructor
	 * @param b, sets b to this
	 */
	public CharList(CharList b) {
		for(int i=0;i<b.size();i++){
			this.charList[i]= b.charList[i];
			this.numElements++;
		}
	}

	/**
	 * concantinates c to this charlist
	 * @param c, character to add
	 */
	public void add(char c) {
		this.charList[this.numElements] = c;
		this.numElements++;
	}

	/**
	 * @return numelements
	 */
	public int size() {
		return numElements;
	}
	
	/**
	 * Overrides the inherited toString
	 * @return string value of charlist
	 */
	public String toString(){
		String string="";
		for(int i=0;i<this.size();i++)
			string+=this.charList[i];
		return string;
	}

	/**
	 * Determines equivalence
	 * @param other, compares this to other
	 * @return boolean, true if all characters equivalent
	 */
	public boolean equals(CharList other){
		boolean bool = false;
		for(int i=0;i<this.size();i++){
			if(this.charList[i]== other.charList[i])
				bool = true;
			else
				bool = false;
		}
		return bool;
	}
}

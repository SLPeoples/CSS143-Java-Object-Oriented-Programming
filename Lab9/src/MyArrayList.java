import java.util.*;
import java.util.Comparator;

/**
 * This class implements multiple sort algorithms to be used with ints, chars, and Stings.
 * Bubble sort, Selection sort, and Insertion sorts are implemented here
 * 
 * @author Samuel L. Peoples
 */
 
public class MyArrayList implements Comparable<MyArrayList>{
   
    // instance data
    protected int[] IntList;
    protected char[] CharList;
    protected String[] StringList;
    
    /**
     * Builds three arrays, constructor
     */
    public MyArrayList() {
        this.IntList = new int[10];
        this.CharList = new char[10];
        this.StringList = new String[5];
        
        // fill all 3 arrays with data
        for(int i = 0; i < IntList.length; i++) {
            IntList[i] = (int) (Math.random()*52);
       }
	   
       // Populate char array
       for(int i = 0; i < CharList.length; i++) {
           
          Random random = new Random();
          CharList[i] = (char)(random.nextInt(26) + 'a');
       }
	   
       // Populate String array
       StringList[0] = "joe";
       StringList[1] = "mark";
       StringList[2] = "abbey";
       StringList[3] = "tony";
       StringList[4] = "kevin";    
    }
    
    /**
     * @return 1 if the first element of the intList is greater than Other's,
     * 			-1 if it is less,
     * 			0 if they are equal.
     */
    public int compareTo(MyArrayList other) {
           
    	if(this.IntList[0]<other.IntList[0]){    			
                System.out.println("compareTo() is returning -1, array[0] < other[0]"); 
                return -1;
            }
                                       
    	else if(this.IntList[0]>other.IntList[0]){
              System.out.println("compareTo() is returning 1, array[0] > other[0]");
              return 1;
            }
              
            else {
                System.out.println("compareTo() is returning 0, array[0] = other[0] ");
                return 0;
            }
    }
      

    
    /**
     * Int bubble sort
     */
    public void intBubbleSort() {
    	// Implement your sort, call a helper swap method  
        for(int i=0; i < IntList.length; i++)
        	for(int j=1; j < (IntList.length-i); j++)
                swapInts(IntList, j);  
    }
        
    
    /**
     * Character bubble sort
     */
    public void charBubbleSort() {
       // Implement your sort, call a helper swap method 
        for(int i=0; i < CharList.length; i++)
        	for(int j=1; j < (CharList.length-i); j++)
                swapChars(CharList, j);  
            
    }
    
    /**
     * String bubble sort
     */
    public void stringBubbleSort() {
       // Implement your sort, call a helper swap method  
    	for(int i=0; i < StringList.length; i++)
    		for(int j=1; j < (StringList.length-i); j++)
    			swapStrings(StringList, j);  
    }

    /**
     * Swaps integers
     * @param intList, list passed in
     * @param j, index to check
     */
    public void swapInts(int[] intList, int j) { 
    	int swap = 0;
    	if(intList[j-1] > intList[j]){  
            //swap elements  
            swap = intList[j-1];  
            IntList[j-1] = intList[j];  
            IntList[j] = swap;  
            }        
    }
    /**
     * Swaps characters
     * @param charList, list passed in
     * @param j, index to check
     */    
    public void swapChars(char[] charList, int j) { 
    	char swap = ' ';
    	if(charList[j-1] > charList[j]){  
            //swap elements  
            swap = charList[j-1];  
            CharList[j-1] = charList[j];  
            CharList[j] = swap;  
            }  
    }
    
    /**
     * Swaps strings
     * @param stringList, list passed in
     * @param j, index to check
     */
    public void swapStrings(String[] stringList, int j) { 
    	String swap = "";
    	if(stringList[j-1].compareTo(stringList[j]) > 0){  
            //swap elements  
            swap = stringList[j-1];  
            StringList[j-1] = stringList[j];  
            StringList[j] = swap;  
            }  
    }
    
    /**
     *selection sort for ints 
     */
    public void selectionSort() {
    	for (int i = 0; i < IntList.length - 1; i++){
            int index = findSmallest(IntList, i, IntList.length);
    		for (int j = i + 1; j < IntList.length; j++)
            	if (IntList[j] < IntList[index]) 
                    index = j;
            swap(IntList, index, i);
            
    	}
        // Implement your sort, call swapSelection(int[] intList, int i, int nextMin) 
    }
    
    /**
     * swaps elements in int array
     * @param list, array passed in
     * @param index1, index to swap
     * @param index2, index to swap
     */
    public void swap(int[] list, int index1, int index2){
    	int swap = list[index1];  
        IntList[index1] = list[index2];
        IntList[index2] = swap;  
    }
    
    /**
     * Finds the smallest int
     * @param arr, int array passed in
     * @param begin index
     * @param end index
     * @return minimum index
     */
    public int findSmallest(int[] arr, int begin, int end) {
        //returns the index of the smallest element
        int minIndex = begin;       //hint
        for(int i = begin; i < end ; i++) {
            if(arr[begin + 1] > arr[begin]) {
                minIndex = begin + 1;
            } else 
                minIndex = begin;
        }
        return minIndex;
    }
    
    /**
     * Selection sort for strings
     */
    public void stringSelectionSort() {
       // Implement your sort, call swapSelectionStrings(String[] StringList, int i)
	   // and findSmallest(IntList, i, IntList.length) from your method
    	for (int i = 0; i < StringList.length - 1; i++){
            int index = findSmallestStr(StringList, i, StringList.length);
    		for (int j = i + 1; j < StringList.length; j++)
            	if (StringList[j].compareTo( StringList[index]) <0) 
                    index = j;
            swapStr(StringList, index, i);
    	}
    }

    
    /**
     * swaps two elements
     * @param stringList, passed list
     * @param index1, index to swap
     * @param index2, index to swap
     */
    private void swapStr(String[] stringList, int index1, int index2) {
    	String swap = stringList[index1];  
        StringList[index1] = stringList[index2];
        StringList[index2] = swap;  
	}

	/**
	 * Finds the smallest string
	 * @param arr, array passed in
	 * @param begin, begin index
	 * @param end, end index
	 * @return smallest index
	 */
	public int findSmallestStr(String[] arr, int begin, int end) {
        int minIndex = begin;       //hint
        for(int i = begin; i < end ; i++) {
            if(arr[begin + 1].compareTo(arr[begin]) > 0) {
                minIndex = begin + 1;
            } else 
                minIndex = begin;
        }
        return minIndex;
	}
    
    /**
     * Insertion sort
     */
    public void insertionSort() {        
        for (int i = 1; i < IntList.length; i++) {  
            int current = IntList[i];  
            int j = i-1;  
            while ( (j > -1) && ( IntList [j] > current ) ) {  
                IntList [j+1] = IntList [j];  
                j--;  
            }  
            IntList[j+1] = current;  
        }

    } 
    public static void main(String args[]){
    	MyArrayList a = new MyArrayList();
    	//Tested using debugger. Followed each list.
    	a.intBubbleSort();
    	a.charBubbleSort();
    	a.stringBubbleSort();
    }
} 

    


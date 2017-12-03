import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * MorseTree.java
 * CSSSKL 162 Binary Search Tree Lab
 * Author: Rob Nash
 * 
 * This class reads in data from a text file ("data.txt") and populates a binary tree with an 
 * ordering constraint.  See the lab instructions for more information, but in general, dots go right 
 * and dashes go left when constructing or traversing a Morse code tree.  Search for //TODO
 * in the code to see what code you have to implement.
 * 
 * Start with the constructor. In your constructor read each line in from the textfile first, 
 * calling add() for each {letter, morseCodeStr} pair.
 * @author Samuel L. Peoples
 */

public class MorseTree {
	private TreeNode root;
    /**
     * Constructor for the morseTree, Opens file and reads the morse translation
     */
    public MorseTree() {
       
		//first, open data.txt, add each line to the tree
		Scanner fin;
		try {
			File file = new File("data.txt");
			fin = new Scanner(file);
			while(fin.hasNextLine()){
				String temp = fin.nextLine();
				//We're going to add the morseString from the second position onwards,
				//then we'll add the character(data object) from the 0 position
				add(temp.substring(2), temp.charAt(0));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}
	}

    /**
     * add sends to insertInSubtree
     * @param morseStr, morese code string 
     * @param letter, character to add
     */
    public void add(String morseStr, char letter) {
        root = insertInSubtree(morseStr, letter, root);
    }
    
	/**
	 * Inserts the character to the appropriate location within the tree
	 * @param morseStr, string of -,.
	 * @param letter, character to add
	 * @param subtree, subtree to place
	 * @return treenode once finalized.
	 */
	private TreeNode insertInSubtree(String morseStr, char letter, TreeNode subtree) {
		//check null, can't edit without a node
		if(subtree == null)
			return insertInSubtree(morseStr, letter, new TreeNode());
		//if the morse string has been shaved down to nothing, set the data.
		if(morseStr.length() == 1){
			subtree.data = letter;
			return subtree;
		}
		//If it's ., go right, and set right
		else if(morseStr.charAt(0)=='.')
			subtree.setRight(insertInSubtree(morseStr.substring(1), letter, subtree.right));
		//if it's -, go left, and set left
		else if(morseStr.charAt(0)=='-')
			subtree.setLeft(insertInSubtree(morseStr.substring(1), letter, subtree.left));
		return subtree;  //always the last line, always return the node you are working on
	}
    
    /**
     * translate (given a morsestring)
     * @param morseStr, string to check
     * @return character value of morsestring
     */
    public Character translate(String morseStr) {
        return findInSubtree(morseStr, root);
    }
    
	private Character findInSubtree(String morseStr, TreeNode subtree) {
		//something went wrong if this happens (not in the tree)
		if(subtree == null)
			return null;
		//once the string is shaved down, return the data
		if(morseStr.length() == 0)
			return (Character) subtree.data;
		//else, go right or left, and shave the string via its first char
		else if(morseStr.charAt(0)=='.')
			return findInSubtree(morseStr.substring(1), subtree.right);
		else if(morseStr.charAt(0)=='-')
			return findInSubtree(morseStr.substring(1), subtree.left);
		return null;
		
	}
    
	/**
	 * translates a string by concantenating a string of morseStrings
	 * @param tokens, string of token morseStrings
	 * @return string of translated morseStrings
	 */
	public String translateString(String tokens) {
		String retVal = "";
		Scanner input = new Scanner(tokens);
		while(input.hasNext())
			retVal += findInSubtree(input.next(), this.root)+ " ";
		input.close();
		return retVal;
	}
	/*
    public String toMorseCode(Character c) {
        .
        //walk the tree looking for the TreeNode with the char c in it
            //preorder walk?
            //inorder walk?
            //postorder walk?
        
        //when you've found the char c, report the path from the root to the node
        //and build the morse code by adding a "." when you go right, "-" when you go left
        return new String("You wish.");
    }
    public String toString() {
        return inorderWalk();
    }
    private String inorderWalk() {  
        
        return new String("Another wish.");
    }  
    */
    /**
     * easy main
     * @param args
     */
    public static void main(String[] args) {
        MorseTree mt = new MorseTree();  //builds our tree using data from a file
        System.out.println();
        System.out.println(mt.translateString(".- -... -.-. -.. ."));  //prints out A B C D E
        
        System.out.println(mt.translateString("..-. --. .... .. .---"));  //prints out F G H I J
        
        System.out.println(mt.translateString("-.- .-.. -- -. ---"));  //prints out K L M N O
        
        System.out.println(mt.translateString(".--. --.- .-. ... -"));  //prints out P Q R S T
        
        System.out.println(mt.translateString("..- ...- .-- -..- -.--"));  //prints out U V W X Y
        
        System.out.println(mt.translateString("--.. ----- .---- ..--- ...--"));  //prints out Z 0 1 2 3
        
        System.out.println(mt.translateString("....- ..... -.... --... ---.."));  //prints out 4 5 6 7 8
        
        System.out.println(mt.translate("----."));  //prints out 9
        System.out.println(mt.translate(".......-"));  //prints out null
        
        System.out.println(mt.translateString("... --- ..."));  //SOS
        //System.out.println(mt.toMorseCode('S'));  //find where we are in the tree, remember path to root
    }

    /**
     * Inner class to create the linked structure
     */
    private class TreeNode {
        Object data;
        TreeNode right;
        TreeNode left;
        
        /**
         *  null constructor
         */
        public TreeNode() {
            this.data = null;
            this.right = null;
            this.left = null;
        }
        
        /**
         * data constructor
         * @param data
         * @param leftNode
         * @param rightNode
         */
        public TreeNode(Object data, TreeNode leftNode, TreeNode rightNode){
        	this.data = data;
        	this.left = leftNode;
        	this.right = rightNode;
        }
        
        public void setRight(TreeNode rightNode) {
            this.right = rightNode;
        }
        
         public void setLeft(TreeNode leftNode) {
            this.left = leftNode;
        }
            
    }
}

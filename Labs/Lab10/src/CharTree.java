import java.io.*;
import java.util.*;

/**
 * Class invariant: This code for a binary tree satisfies the
 * binary search tree storage rule.
 * CSSSKL 162
 * @author Samuel L. Peoples
/**
 */

 public class CharTree {
     
     /*Inner class Node, 2 references(pointers), one data element
      * The only reason this inner class is static is that it is used in 
      * the static methods insertInSubtree , isInSubtree , and 
      * showElementsInSubtree. This class should have more methods. 
      * This is just a sample of possible methods.
      */
     private static class TreeNode {
	 
		// Declare private data type char
        // Declare 2 links, rightLink & leftLink of type TreeNode
       private char data;
       private TreeNode leftLink;
       private TreeNode rightLink;
         
         
         /**
          * Parametrized constructor to build a node
         * @param newData, char to add
         * @param newLeftLink, left <
         * @param newRightLink, right >=
         */
        public TreeNode(char newData, TreeNode newLeftLink, TreeNode newRightLink) {
		    this.data = newData;
		    this.leftLink = newLeftLink;
		    this.rightLink = newRightLink;
             
         }
     }           //End of IntTreeNode inner class
     
     // The first node of the tree, called root
     private TreeNode root;
     
     // Default constructor to build the CharTree
     /**
     * Constructor initializes root as null
     */
    public CharTree( ) {
         root = null;
     }
     
     // Utility methods for CharTree:
     /**
      * adds an item
     * @param item, char to add
     */
    public void add(char item) {
         root = insertInSubtree(item, root);
     }
 
     
     /**
      * Contains method
     * @param item to call
     * @return true if item is in the tree
     */
    public boolean contains(char item) {
         return isInSubtree(item, root);
     }
     
     /**
     * shows the elements in the tree
     */
    public void showElements( ) {
         showElementsInSubtree(root);
     }
     
     /**
     Returns the root node of a tree that is the tree with root node
     subTreeRoot, but with a new node added that contains item.
     */
     private static TreeNode insertInSubtree(char item, TreeNode subTreeRoot) {
         if (subTreeRoot == null)
            return new TreeNode(item, null, null);
         else if (item < subTreeRoot.data) {
             subTreeRoot.leftLink = insertInSubtree(item, subTreeRoot.leftLink);
                return subTreeRoot;
         }
         else {         //item >= subTreeRoot.data
               subTreeRoot.rightLink = insertInSubtree(item, subTreeRoot.rightLink);
                 return subTreeRoot;
         }
     }
     
     /**
      * determines if item is in the subtree
     * @param item to find
     * @param subTreeRoot to search
     * @return true if found
     */
    private static boolean isInSubtree(char item, TreeNode subTreeRoot) {
		// base case: is subTreeRoot null?    then return false
    	 if(subTreeRoot == null)
    		 return false;
    	 else if(subTreeRoot.data == item)
    		 return true;
    	 else if(item < subTreeRoot.data)
    		 return isInSubtree(item, subTreeRoot.leftLink);
    	 else if(item >= subTreeRoot.data)
    		 return isInSubtree(item, subTreeRoot.rightLink);
    	 return false; // Failsafe
        }
        
     /**
      * shows the elements in the sub tree
     * @param subTreeRoot, to show
     */
    private static void showElementsInSubtree(TreeNode subTreeRoot) { //Uses inorder traversal.
         if (subTreeRoot != null) {
             
             showElementsInSubtree(subTreeRoot.leftLink);
             System.out.print(subTreeRoot.data + " ");
             showElementsInSubtree(subTreeRoot.rightLink);
         }                    //else do nothing. Empty tree has nothing to display.
     }

    /**
     * testing main
     * @param args
     */
    public static void main(String[] args) {
        CharTree tree = new CharTree();
        tree.add('c');
        tree.add('a');
        tree.add('t');
        tree.add('s');
        showElementsInSubtree(tree.root);
        System.out.println();
        System.out.println("Is 'a' in the subtree? "+isInSubtree('a', tree.root));
        System.out.println("Is 't' in the subtree? "+isInSubtree('t', tree.root));
        System.out.println("Is 'b' in the subtree? "+isInSubtree('b', tree.root));
		
    }
 }

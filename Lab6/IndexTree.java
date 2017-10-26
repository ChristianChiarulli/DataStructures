import java.util.*;
import java.io.*;


// Your class. Notice how it has no generics.
// This is because we use generics when we have no idea what kind of data we are getting
// Here we know we are getting two pieces of data:  a string and a line number
public class IndexTree {

	// This is your root
	// again, your root does not use generics because you know your nodes
	// hold strings, an int, and a list of integers
	private IndexNode root;
	public static int lineNumber = 0;
	//private String returnVal;
	//private int size;
	//private int lineNumber = 1;
	// Make your constructor
	// It doesn't need to do anything
	public IndexTree() {
		//this.size = 0;
	}

	// complete the methods below

	// this is your wrapper method
	// it takes in two pieces of data rather than one
	// call your recursive add method
	public boolean add(String word) {
		this.root = add(this.root, word, lineNumber);
		//size++;
		//root.occurences++;
		return true;
	}

	// returns true if the word is in the index
	public boolean contains(String word) {
		return contains(this.root, word);
	}

	public boolean contains(IndexNode root, String word) {
		if(root==null) {
			return false;
		}

		if(word.compareTo(root.word) == 0) {
			return true;
		} else if(word.compareTo(root.word) < 0) {
			return contains(root.left, word);
		} else {
			return contains(root.right, word);
		}
	}

	public int size() {
		return size(root);
	}

	public int size(IndexNode root) {
		if(root== null) {
			return 0;
		}
		int leftSize = size(root.left);
		int rightSize= size(root.right);
		int mySize  = 1;

		return leftSize +rightSize + mySize;
	}


	// your recursive method for add
	// Think about how this is slightly different the the regular add method
	// When you add the word to the index, if it already exists,
	// you want to  add it to the IndexNode that already exists
	// otherwise make a new indexNode
	private IndexNode add(IndexNode root, String word, int lineNumber){
		if(root == null){
			return new IndexNode(word, lineNumber);
		}
		else if(word.compareTo(root.word) == 0){
			//item is equal to localRoot
			root.occurences++;
			//root.list.add(lineNumber);
			return root;
		}
		else if(word.compareTo(root.word) < 0){
			//item is less than localRoot
			root.left = add(root.left, word, lineNumber);
			return root;
		}
		else {
			//item is greater than localroot
			root.right = add(root.right, word, lineNumber);
			return root;
		}
	}

	// call your recursive method
	// use book as guide
	public void delete(String word) {
		this.root= delete(this.root , word);
	}

	// your recursive case
	// remove the word and all the entries for the word
	// This should be no different than the regular technique.
	public IndexNode delete(IndexNode root, String word) {
		if(root == null) {
			return null;
		}

		if(word.compareTo(root.word)  < 0) {
			root.left = delete(root.left, word);
			return root;
		} else if(word.compareTo(root.word) > 0) {
			root.right = delete(root.right, word);
			return root;
		} else { //  I'm the one they want to get rid of ;_;
			if(root.left == null && root.right == null) {
				return null;
			}
			else if(root.left != null && root.right == null) {
				return root.left;
			}
			else if(root.left == null && root.right != null) {
				return root.right;
			} else { // I have two kids

				if(root.left.right == null) {
					IndexNode pred = root.left;
					root.word = pred.word;
					root.left = pred.left;
					return root;
				}

				IndexNode parent = root.left;
				IndexNode pred = parent.right;
				while(pred.right != null) {
					pred = pred.right;
					parent = parent.right;
				}

				root.word = pred.word;
				parent.right = pred.left;
				return root;
			}
		}
	}


	/*// prints all the words in the index in inorder order
	// To successfully print it out
	// this should print out each word followed by the number of occurrences and the list of all occurrences
	// each word and its data gets its own line
	public void printIndex(){
		System.out.println(root.left);
		System.out.println(root);
		System.out.println(root.right);
	}*/

	public String toString() {
		return toString(root);
	}

	public String toString(IndexNode root) {
		if(root == null) {
			return "";
		}

		return toString(root.left) + " " + root
				+ "\n" + toString(root.right);
	}

	public static void main(String[] args){
		IndexTree index = new IndexTree();

		// add all the words to the tree

		// print out the index

		// test removing a word from the index

		String fileName = "pg100.txt";

		try {
			Scanner scanner = new Scanner(new File(fileName));
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				String[] words = line.split("\\s+");
				lineNumber++;
				for(String word : words){
					word = word.replaceAll("[^a-zA-Z0-9]","");
					index.add(word);
				}
				//lineNumber = 0;
			}
			scanner.close();

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(index);
	}
}

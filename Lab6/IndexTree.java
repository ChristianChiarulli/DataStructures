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

	// Make your constructor
	// It doesn't need to do anything
	public IndexTree(){								//added this
		//this.root = null;
	}

	// complete the methods below

	// this is your wrapper method
	// it takes in two pieces of data rather than one
	// call your recursive add method
	public void add(String word, int lineNumber){
		add(root, word, lineNumber);
	}



	// your recursive method for add
	// Think about how this is slightly different the the regular add method
	// When you add the word to the index, if it already exists,
	// you want to  add it to the IndexNode that already exists
	// otherwise make a new indexNode
	private IndexNode add(IndexNode root, String word, int lineNumber){
		if(root == null){
			return null;
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




	// returns true if the word is in the index																					//need to do this
	public boolean contains(String word){
		return false;
	}

	// added to check if the item is a leaf
	public boolean isLeaf(IndexNode root) {
		return (root.left == root.right && root.right == null);
	}

	// call your recursive method
	// use book as guide
	public void delete(String word){
		root = delete(root, word);
	}

	// your recursive case
	// remove the word and all the entries for the word
	// This should be no different than the regular technique.
	private IndexNode delete(IndexNode root, String word){
		if (root == null) { //item not found
			return null;
		}
		int comparison = word.compareTo(root.word);
		if (comparison < 0) { //item is less than localRoot
			root.left = delete(root.left, word);
			return root;
		}
		else if (comparison > 0) {
			root.right = delete(root.right, word);
			return root;
		}
		else{
			//the item is in the localroot
			if (isLeaf(root)) {
				//if the local root has no children, just delete it
				return null;
			}
			else if (root.right == null && root.left != null) {
				//if localRoot only has a left child
				return root.left;
			}
			else if (root.left == null && root.right != null) {
				//if localRoot only has a right child
				return root.right;
			}
			else {
				//localroot has two children
				IndexNode currentRoot = root.right;
				while (currentRoot.left != null) {
					currentRoot = currentRoot.left;
				}

				String place = root.word;
				root.word = currentRoot.word;
				currentRoot.word = place;

				root.right = delete(root.right, word);
				return root;
			}
		}
	}


	// prints all the words in the index in inorder order
	// To successfully print it out
	// this should print out each word followed by the number of occurrences and the list of all occurrences
	// each word and its data gets its own line
	public void printIndex(){
		System.out.println(root.toString());
	}



	/*public void find(String word) {
		IndexNode node;
		node = find(word, root);
		if (node != null) {
			System.out.print("Word: " + node + " Number of occurences: " + node.count + " Byte locations: ");
			for (int each : node.loc) {
				System.out.print(each + " ");
			}
			System.out.print("\n");
		}
		else {
			System.out.println("Could not find word");
		}

	}

	private Node<E> find(E item, Node<E> localRoot) {
		while (localRoot != null) {
			int comparison = item.compareTo(localRoot.element);
			if (comparison < 0) {
				localRoot = localRoot.left;
			}
			else if (comparison > 0) {
				localRoot = localRoot.right;
			}
			else { //found it!
				return localRoot;
			}
		}
		//Did not find the word, return null
		return null;
	}*/

















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
				//System.out.println(line);
				String[] words = line.split("\\s+");
				for(String word : words){
					word = word.replaceAll(":", "");
					word = word.replaceAll(",", "");
					index.add(word, 1);
					//System.out.println(word);
				}
			}
			scanner.close();

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		index.printIndex();
	}
}

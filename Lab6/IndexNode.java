
import java.util.List;
import java.util.*;
public class IndexNode  {

	// The word for this entry
	String word;
	// The number of occurrences for this word
	public int occurences;
	// A list of line numbers for this word.
	List<Integer> list = new ArrayList<>();



	IndexNode left;
	IndexNode right;


	// Constructors
	// Constructor should take in a word and a line number
	// it should initialize the list and set occurrences to 1
	public IndexNode(String word, int lineNumber){
		this.word = word;
		this.list. add(lineNumber);
		this.occurences +=1;
		this.left = null;
		this.right = null;

	}



	// Complete This
	// return the word, the number of occurrences, and the lines it appears on.
	// string must be one line

	public String toString(){
		return this.word.toString();
	}



}

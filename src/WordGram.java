/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author Shreyas Kulkarni
 *
 */

public class WordGram {
	
	
	private String[] myWords;  //The array of strings for each WordGram object 
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source The String array with all the words that will be selectively picked from
	 * @param start This is the start position respective to the source. The word at the start position in source will be the first word of the field myWords. 
	 * @param size this is the size of the myWords string array for the wordgram objext. 
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		int a = 0;
		for(int i = 0; i < source.length; i++) { 
			 
			if (i >= start && i < (start + size)) {
				myWords[a] = source[i];
				a++; 
			}
		}
		// TODO: initialize myWords and ...
		myToString = null; 
		myHash = 0; 
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * This returns the size of the objects myWord's field. Essentially however many words there are in the wordgram. 
	 * @return int of the size of myWords. 
	 */
	public int length(){
		return myWords.length;
	}


	@Override
	/**
	 * This checks if the parameter is of the WordGram sort and if so, checks if the WordGrams are equal based on the contents of their myWords. It goes through each word
	 * and their corresponding position and determines equality. At the first worst that is different between the two objects, it will return false, otherwise the loops 
	 * will go all they way through and return True
	 * @return boolean for whether the two objects are equal or not. 
	 */
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		
		WordGram temp = (WordGram) o; 
		
		for(int i = 0; i < temp.myWords.length; i++) { 
			if(!(this.myWords[i].equals(temp.myWords[i]))) { 
				return false; 
			}
		}
			
		
	    
		return true;
	}

	@Override
	/**
	 * This returns the hashcode of the objects myWords list in string form. Only calculated once. 
	 * @return HashCode of the string format of myWords
	 */
	public int hashCode(){
		if(this.myHash == 0) { 
			this.myHash = this.toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * This method creates a copy of the current object and then modifies the new object's myWords by removing the first word of the array and adds the parameter at the end
	 * of the copy's array. The size of myWords is conserved, just the first word has been removed, all the words moved to the right, and another word was added to the end.
	 * This method returns the copy object with the new myWord String array.  
	 * @param last is last String of returned WordGram
	 * @return a wordgram object with a modified myWords string array
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		for(int i = 1; i < this.myWords.length; i++) { 
			wg.myWords[i-1] = this.myWords[i]; 
		}
		wg.myWords[wg.myWords.length-1] = last;
		
		// TODO: Complete this method
		return wg;
	}

	@Override
	/**
	 * This returns the objects myWords list in string form. Only calculated once. 
	 * @return String format of myWords
	 */
	public String toString(){
		if (this.myToString == null) { 
			this.myToString = String.join(" ", myWords); 
		}
		return myToString;
	}
}

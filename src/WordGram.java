/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author Shreyas Kulkarni
 *
 */

public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
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
	 * Complete this comment
	 * @return
	 */
	public int length(){
		return myWords.length;
	}


	@Override
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
	public int hashCode(){
		if(this.myHash == 0) { 
			this.myHash = this.toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return			
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
	public String toString(){
		if (this.myToString == null) { 
			this.myToString = String.join(" ", myWords); 
		}
		return myToString;
	}
}

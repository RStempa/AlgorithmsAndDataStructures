/**
 * 
 */
package algorithmsHashingBSTsAndGUI.count_words;

/**
 * @author Robin
 * 
 *         This class represents a word. Two words are considered equal if they
 *         consist of the same sequence of letters.
 *
 */
public class Word implements Comparable<Word> {

	private String word;

	public Word(String str) {
		word = str;
	}

	public String getWord() {
		return this.word;
	}

	public String toString() {
		return word;
	}

	/**
	 * Method hash code gives a word a hash value based on the numeric characters in
	 * the Ascii table.
	 */
	@Override
	public int hashCode() {
		String word = this.getWord().toLowerCase();
		int hc = 0;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			hc += Character.getNumericValue(c);
		}
		return hc;
	}

	/**
	 * Method equals determines if two word are equal.
	 */
	@Override
	public boolean equals(Object other) {
		String word = this.word.toLowerCase();
		String otherWord = "";

		if (other instanceof Word) {
			otherWord = ((Word) other).getWord();
			otherWord = otherWord.toLowerCase();
		}
		return word.equals(otherWord);
	}

	/**
	 * Method compares two words. 0 = equal, < 0 if greater, > 0 if less than this
	 * string.
	 */

	@Override
	public int compareTo(Word w) {
		return this.getWord().toLowerCase().compareTo(w.getWord().toLowerCase());
	}

}

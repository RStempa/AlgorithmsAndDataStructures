/**
 * 
 */
package algorithmsHashingBSTsAndGUI.count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Robin
 * 
 *         This program reads the text from a file and creates a word object for
 *         every word in the file. The word is then added to a hash set and a
 *         tree set if they do not already contain the word. Also it iterates
 *         over the words and prints them out in alphabetical order and the size
 *         of each set which represents the word count.
 * 
 *
 */
public class WordCount1Main {

	public static void main(String[] args) {

		File input = new File("C:\\Users\\Robin\\Desktop\\words.txt");
		HashSet<Word> hs = new HashSet<Word>();
		TreeSet<Word> ts = new TreeSet<Word>();

		try {
			Scanner in = new Scanner(input);
			Word word;

			while (in.hasNext()) {
				word = new Word(in.next());
				hs.add(word);
				ts.add(word);
			}
			in.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(hs.size());
		System.out.println(ts.size());

	}
}

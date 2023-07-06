/**
 * 
 */
package algorithmsHashingBSTsAndGUI.count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Robin
 * 
 *         This program reads the text from a file and creates a word object for
 *         every word in the file. The word is then added to a hash word set and
 *         a tree word set. It counts the words and iterates over them.
 *
 */
public class WordCount2Main {

	public static void main(String[] args) {

		File input = new File("C:\\Users\\Robin\\Desktop\\words.txt");
		WordSet hws = new HashWordSet();
		WordSet tws = new TreeWordSet();

		try {
			Scanner in = new Scanner(input);
			Word word;

			while (in.hasNext()) {
				word = new Word(in.next());
				hws.add(word);
				tws.add(word);
			}
			in.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(hws.size());
		System.out.println(tws.size());
	}
}

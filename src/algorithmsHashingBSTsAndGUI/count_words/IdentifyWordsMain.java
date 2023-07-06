
package algorithmsHashingBSTsAndGUI.count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class reads a text file and divide the text into a sequence of words
 * 
 * @author Robin
 */
public class IdentifyWordsMain {

	public static void main(String[] args) {
		try {
			File input = new File("C:\\Users\\Robin\\Desktop\\HistoryOfProgramming.txt");
			Scanner in = new Scanner(input);
			File output = new File("C:\\Users\\Robin\\Desktop\\words.txt");
			PrintWriter printer = new PrintWriter(output);
			StringBuilder sb = new StringBuilder();
			while (in.hasNextLine()) {
				sb.append(in.nextLine() + " ");
			}

			String text = sb.toString();
			Pattern p = Pattern.compile("\\b[AaI]+\\b|\\b[A-Za-z]{2,}+\\b"); // one letter words a, A or I and then all otther words
			Matcher m = p.matcher(text);
			while (m.find()) {
				printer.print(text.substring(m.start(), m.end()) + " ");
			}
			in.close();
			printer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

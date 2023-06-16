
package inheritanceAndRecursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class PrintJavaMain {

	public static void main(String[] args) throws IOException {

		try {
			File directory = new File("C:\\JavaSkola\\1DV507\\src\\rs222nv_assignment3");
			if (directory.exists() && directory.isDirectory()) 
				System.out.println("Start: " + directory);
			 else 
				System.err.println("Can't find directory: " + directory);			
			printAllJavaFiles(directory);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void printAllJavaFiles(File directory) throws IOException { // try catch måste det vara!!
		File[] files = directory.listFiles();
		int linenumber = 0;

		for (File f : files) {
			if (f.isDirectory()) {
				printAllJavaFiles(f);
			} else if (f.getName().endsWith(".java")) {
				FileReader fr = new FileReader(f);
				LineNumberReader lnr = new LineNumberReader(fr);
				while (lnr.readLine() != null) {
					linenumber++;
				}
				lnr.close();
				System.out.println("     file:" + f.getName() + " lines:" + linenumber);
			}
		}
	}

}

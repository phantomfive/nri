package org.sample;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Loads the questions. Right now it only loads from CSV,
 *  but in the future it could be expanded to read from other
 *  file formats. 
 *  */
public class QuestionLoader {

	private static final String defaultFilename = "data/questions.csv";
	
	/**
	 * Parses questions from a CSV file.
	 * 
	 * Here is a sample of the expected format we are parsing here:
	 * 
	 * ========================================================================
	 * 
	 * strand_id,strand_name,standard_id,standard_name,question_id,difficulty
     * 1,Nouns,1,Common Nouns,1,0.7
     * 1,Nouns,1,Common Nouns,2,0.6
     *
     * ========================================================================
	 * @throws IOException 
	 */
	public static List<Question>LoadFromCSV(String filename) throws IOException{
		List<Question>rv = new ArrayList<Question>(100);
		
		Scanner s = openFile(filename);
		skipFirstLine(s);
		while(stillMoreToRead(s)) {
			String unparsed = GetNextLine(s);
			Question q = ParseSingleQuestion(unparsed);
			if(q==null) {
				break;
			}
			rv.add(q);
		}
		closeFile(s);
		
		return rv;
	}
	/**Loads the default question file*/
	public static List<Question>LoadFromCSV() throws IOException{
		return LoadFromCSV(defaultFilename);
	}


	/**This is the routine that does the hard work of parsing a single line,
	 * it parses a single line from the CSV. Over, and over, and over again.
	 */
	static Question ParseSingleQuestion(String line) {
		line = line.trim();
		
		String[]columns = line.split(",");
		if(columns.length!=6){
			//most likely some extra trailing space at the end of the file
			//Otherwise the file is corrupted, or not expected format.
			return null;
		}
		
		int strand_id        = Integer.parseInt  (columns[0]);
		String strand_name   =                   (columns[1]);
		int standard_id      = Integer.parseInt  (columns[2]);
		String standard_name =                   (columns[3]);
		int question_id      = Integer.parseInt  (columns[4]);
		double difficulty    = Double.parseDouble(columns[5]);
		
		Question rv = new Question(strand_id, strand_name,
				                   standard_id, standard_name,
				                   question_id, difficulty);
		
		return rv;
	}
	
	private static String GetNextLine(Scanner s) {
		return s.nextLine();
	}

	private static void skipFirstLine(Scanner s) {
		s.nextLine();
	}
	
	private static boolean stillMoreToRead(Scanner s) {
		return s.hasNextLine();
	}


	private static Scanner openFile(String filename) throws IOException {
	       Path p = Paths.get(filename);
	       Scanner s = new Scanner(p);
	       return s;
	}
	
	private static void closeFile(Scanner s) {
		s.close();
	}
}

package org.sample;

import java.util.List;
import java.util.Random;

/** Loads the entire question list into memory.
 *  Makes selections of questions, based on criteria.
 */
public class ChooseQuestionIds {

	private final List<Question>questions;
	private final Random rand = new Random();
	
	public ChooseQuestionIds() throws Exception {
		questions = QuestionLoader.LoadFromCSV();
	}

	/** In the first attempt, choose a question randomly. 
	 *  This isn't the best choice, but gives good distribution*/
	public int getNextQuestion() {
		
		return chooseRandomQuestion();	
	}
	
	private int chooseRandomQuestion() {
		int max = questions.size();
		
		int val = rand.nextInt(max);
		
		return questions.get(val).question_id;
	}
	
}

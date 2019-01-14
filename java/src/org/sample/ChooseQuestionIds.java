package org.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Loads the entire question list into memory.
 *  Makes selections of questions, based on criteria.
 */
public class ChooseQuestionIds {

	private List<Question>questions;
	private List<Question>alreadyChosen = new ArrayList<Question>(10);
	private final Random rand = new Random();
	
	public ChooseQuestionIds() throws Exception {
		questions = QuestionLoader.LoadFromCSV();
	}

	/** In the first attempt, choose a question randomly. 
	 *  This isn't the best choice, but gives good distribution*/
	public int getNextQuestion() {
		if(questions.size()<=0) {
			resetAlreadyChosen();
		}
		
		int questionIndex = chooseRandomQuestion();
		Question q = moveQuestionToAlreadyChosen(questionIndex);
		return q.question_id;
	}
	
	/**Mark this question as already chosen, so we don't keep sending the
	 * same question over and over */
	private Question moveQuestionToAlreadyChosen(int questionIndex) {
		Question q = questions.remove(questionIndex);
		alreadyChosen.add(q);
		return q;
	}
	
	/**Once we've already chosen every question, we can reset the question list*/
	private void resetAlreadyChosen() {
		//We move everything from the already chosen list back to the
		//unchosen list, but it's easier to just swap the variables.
		List<Question>t = questions;
		questions       = alreadyChosen;
		alreadyChosen   = t;
	}

	private int chooseRandomQuestion() {
		int max = questions.size();
		int val = rand.nextInt(max);
		return val;
	}
	
}

package org.sample;

/**Data object to keep track of questions.
 */
public class Question {
	
	//I want to point out that, although there is much metadata,
	//the question itself seems to be missing from this question object.
	public int strand_id;
	public String strand_name;
	public int standard_id;
	public String standard_name;
	public int question_id;
	public double difficulty;
	
	public Question(int strand_id, String strand_name,
			        int standard_id, String standard_name,
			        int question_id, double difficulty) {
		this.strand_id     = strand_id;
		this.strand_name   = strand_name;
		this.standard_id   = standard_id;
		this.standard_name = standard_name;
		this.question_id   = question_id;
		this.difficulty    = difficulty;	
	}
	
}

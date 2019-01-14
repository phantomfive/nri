package org.sample;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class QuestionLoaderTest {

	@Test
	void testLoadFromCSV() throws Exception {
	       System.out.println("Working Directory = " +
	               System.getProperty("user.dir"));
		List<Question> qs= QuestionLoader.LoadFromCSV("data/test/questions.csv");
		assertEquals(qs.size(), 12);
		
		Question q = qs.get(6);
		assertEquals(q.strand_id, 2);
		assertEquals(q.strand_name, "Verbs");
		assertEquals(q.standard_id, 4);
		assertEquals(q.standard_name, "Action Verbs");
		assertEquals(q.question_id, 7);
		assertEquals(q.difficulty, .9);
	}

	@Test
	void testLoadFromCSVString() {
		String s = "1,Nouns,1,Common Nouns,1,0.7";
		Question q = QuestionLoader.ParseSingleQuestion(s);
		
		assertEquals(q.strand_id, 1);
		assertEquals(q.strand_name, "Nouns");
		assertEquals(q.standard_id, 1);
		assertEquals(q.standard_name, "Common Nouns");
		assertEquals(q.question_id, 1);
		assertEquals(q.difficulty, .7);
	}
}

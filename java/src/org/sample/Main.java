package org.sample;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[]args) throws Exception {
		int count = 1;
		if(args.length>0) {
			count = Integer.parseInt(args[0]);
		}
		
		ChooseQuestionIds chooser = new ChooseQuestionIds();
		
		List<Integer>questionIds = new ArrayList<Integer>(count);
		
		for(int i=0;i<count;i++) {
			questionIds.add(new Integer(chooser.getNextQuestion()));
		}
		
		for(int i=0;i<count-1;i++) {
			System.out.print(questionIds.get(i) + ",");
		}
		System.out.println(questionIds.get(count-1));
	}
}

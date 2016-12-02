package hu.elte.txtuml.stdlib.util;

import dictionary_txtUML.model.Test;
import hu.elte.txtuml.api.model.Action;
import hu.elte.txtuml.api.model.execution.ModelExecutor;


/*
 * This class for testing dictionary methods with txtUML.
*/
public class Tester {
	
	static Test test;
	static void init(){
		test = Action.create(Test.class);
		Action.start(test);
}

	public static void main(String[] args)  {
		ModelExecutor.create().setTraceLogging(true).start(Tester::init);
		

	}

}

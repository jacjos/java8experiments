package com.java8.rules;

public class RulesEngine {
	
	private static void preProcess(){
		System.out.println("Preprocessing.");
	}
	
	public static <T,R> void runRule(IRule<T, R> rule, T t){
		preProcess();
		rule.executeRule(t);
	}

}

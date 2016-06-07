package com.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.java8.generics.IUtil;
import com.java8.generics.Pair;
import com.java8.generics.Util;
import com.java8.rules.IRule;
import com.java8.rules.Rule1;
import com.java8.rules.RulesEngine;

public class Java8Test {

	public static void main(String[] args) {

//	    testBiFunction();
//	    testPairs();
//		testSum();		
//		callCheckAIC();
		callRules();

	}
	
	public static void callRules(){
		
		IRule<String, Boolean> rule1 = new Rule1<>();
		RulesEngine.runRule(rule1, "This is rule param");
		
		RulesEngine.runRule(new IRule<String, Boolean>() { 
			public Boolean executeRule(String t) {
				System.out.println("executing AICRule : "+t);
				return true;
			}
		}, "This is anonym param");
		
		RulesEngine.runRule((t) -> {System.out.println("executing lambda rule : " + t); return "Done";} , 1);
		RulesEngine.runRule(Java8Test::checkValRule, "checkValRuleParam");
	}
	
	public static String checkValRule(String str){
		System.out.println("Executing checkValRule "+ str);
		return "Done";
	}
	
	public static void testBiFunction(){
		
	    BiFunction<String, String,String> bi = (x, y) -> {      
	      return x + y;
	    };
	    Function<String,String> f = x-> x+" new";
	    Function<String,String> f2 = x-> x+" new2";
	    
	   // System.out.println(bi.apply("Hello", "World"));
	    System.out.println(bi.andThen(f).andThen(f2).apply("java2s.com", " tutorial"));
		
	}
	
	public static void testPairs(){
	    Pair<String, String> p1  = new Pair<>("key1", "1");
	    Pair<String, String> p2  = new Pair<>("key2", "2");
	    Util.compare(p1, p2);
	}
	
	public static void testSum(){
		List<Integer> li = Arrays.asList(1, 2, 3);
		sum(li);
		sumSpecific(li);
	}
	
	public static void callCheckAIC(){
		
		checkAIC(new IUtil() {
			
			@Override
			public void execute() {
				System.out.println("executed");
				
			}
		});
		
		checkAIC(()->{System.out.println("invoking IUtil.execute as lambda");});
		checkAIC(Java8Test::utilExecute);
	}
	
	public static void utilExecute(){
		System.out.println("passed as a named function");
	}
	
	public static void checkAIC(IUtil iUtil){
		System.out.println("executing interface method");
		iUtil.execute();
		iUtil.defaultMethod();
	}
	
	public static void sum(List<? extends Number> numList){
		
		double dblVal = 0.0;
		for(Number num : numList){
			dblVal += num.doubleValue();
		}
		System.out.println("dblVal = "+dblVal);
	}
	
	public static <U extends Number> void sumSpecific(List<U> numList){
		
		double dblVal = 0.0;
		for(U num : numList){
			dblVal += num.doubleValue();
		}
		System.out.println("Specific dblVal = "+dblVal);
	}

}

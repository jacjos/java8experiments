package com.java8.rules;

public class Rule1<T,R> implements IRule<T, R> {

	@Override
	public R executeRule(T t) {
		System.out.println("executing Rule1 : "+t);
		return null;
	}

}

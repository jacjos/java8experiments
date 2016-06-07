package com.java8.rules;

@FunctionalInterface
public interface IRule<T,R> {
	
	public R executeRule(T t);
}

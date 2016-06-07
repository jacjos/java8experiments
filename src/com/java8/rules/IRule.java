package com.java8.rules;

import java.util.Objects;

@FunctionalInterface
public interface IRule<T,R> {
	
	public R executeRule(T t);
	public default <V> IRule<T,V> andThen(IRule<R, V> after){
		Objects.requireNonNull(after);
		return (T t) -> after.executeRule(executeRule(t));
	}
}

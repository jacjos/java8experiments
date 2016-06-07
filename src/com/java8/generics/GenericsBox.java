package com.java8.generics;

public class GenericsBox<T> {
	
	private T t;
	
	public void set(T t){
		this.t = t;
	}
	
	public T get(){
		return this.t;
	}
}

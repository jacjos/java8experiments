package com.java8.generics;

@FunctionalInterface
public interface IUtil{
	
	public void execute();
	public default void defaultMethod(){
		System.out.println("Default Method");
	};

}

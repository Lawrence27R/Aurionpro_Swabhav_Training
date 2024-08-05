package com.aurionpro.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionTest {
public static void main(String[] args) throws ClassNotFoundException {
	
	Class stringClass = Class.forName("java.lang.String");
	
	System.out.println(stringClass.getName());
	System.out.println(stringClass.getSimpleName());
	
	Method stringMethods[] = stringClass.getMethods();
	
	for(Method method: stringMethods){
		System.out.println(method.getName()+"\t"+method.getParameterCount());
		Parameter parameters[] = method.getParameters();
		for(Parameter parameter:parameters) {
			System.out.println(parameter.getName()+parameter.getType());
		}
	}
	Constructor constructors[] = stringClass.getConstructors();
	for(Constructor constructor:constructors) {
		System.out.println(constructor.getName());
	}
}
}

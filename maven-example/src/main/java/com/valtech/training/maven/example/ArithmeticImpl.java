package com.valtech.training.maven.example;

public class ArithmeticImpl implements Arithmetic {
	@Override
	public int add(int a,int b) {
		return a+b;
	}
	public int sub(int a,int b) {
		return a-b;
	}
	public int mul(int a,int b) {                                                                                
		return a*b;
	}
	public int div(int a,int b) {
		return a/b;
	}

}

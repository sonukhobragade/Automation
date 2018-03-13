package com.name.practice;

public class ClassInterface implements InterfaceEg{

	public static void main(String[] args) {
		InterfaceEg.method2();
		ClassInterface ci = new ClassInterface();
		ci.method1();
		ci.method3();
	}
	
	public void method1() {
		System.out.println("Method 1");
	}
	
	public void method3() {
		System.out.println("Class Interface");
	}
}
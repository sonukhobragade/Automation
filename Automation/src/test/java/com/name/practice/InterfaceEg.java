package com.name.practice;

interface InterfaceEg {
	
	
	int z = 1; //Variables are Final and Static
	
	void method1();
	
	public static void method2() {
		System.out.println("Method 2");
	}
	
	default void method3 () {
		System.out.println("Default");
	}
}
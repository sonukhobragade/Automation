package com.name.practice;

public class StringEg {

	/**
	 * String compare By equals() method By = = operator By compareTo() method
	 */
	public static void main(String[] args) {

		String s1 = "Bhanu";
		String s2 = "Bhanu";
		String s3 = new String("Bhanu");
		String s4 = "Pratap";
		/**
		 * The String equals() method compares the original content of the string
		 */
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s4));
		System.out.println("----------------------------");

		/**
		 * The String == operator compares the reference of the string
		 */
		String s5 = "Bhanu";
		String s6 = "Bhanu";
		String s7 = new String("Bhanu");
		// true (because both refer to same instance)
		System.out.println(s5 == s6);
		// false(because s7 refers to instance created in nonpool)
		System.out.println(s5 == s7);

		System.out.println(s6 == s7);

		System.out.println("------------------------");
		System.out.println(s5.equals(s7));
		System.out.println(s6.equals(s7));
		System.out.println("----------------");
		System.out.println(s3 == s7);
		System.out.println(s3.equals(s7));

	}

}

package com.name.practice;

public class ReverseString {

	public static void main(String[] args) {

		String s1 = "Sonu Is Talented";

		for (String w : s1.split("\\s")) {
			for (int i = w.length() - 1; i >= 0; i--) {
				char c = w.charAt(i);
				System.out.print(c);
			}
			System.out.print(" ");
		}
	}
}
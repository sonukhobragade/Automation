package com.name.practice;

import java.util.Scanner;

public class VowelCount {

	private static Scanner reader;

	public static void main(String args[]) {

		System.out.println("Please enter some text");

		reader = new Scanner(System.in);
		String input = reader.nextLine();
		char[] letters = input.toCharArray();
		int count = 0;
		for (char c : letters) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				count++;
		}
		System.out.println("Number of vowels in String [" + input + "] is : " + count);
	}
}
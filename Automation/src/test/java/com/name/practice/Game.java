package com.name.practice;

public class Game {

	public void type() {
		System.out.println("Game Indoor");
	}

	public static void main(String[] args) {
		Game gm = new Cricket();
		gm.type();
	}
}

class Cricket extends Game {

	public void type() {
		System.out.println("Cricket Outdoor");
	}
}

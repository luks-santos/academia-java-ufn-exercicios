package com.academia.primeiroprojeto.labs;

public class Quest3 {

	public static void main(String[] args) {
		int number = 6;
		System.out.println("The factorial of" + number + "is: ");
		System.out.println(factorial(number));

	}
	
	public static int factorial(int value) {
		if(value == 0) return 1;
		return value * factorial(value - 1);
	}
}

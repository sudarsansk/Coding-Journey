package com.practise.recursion;

import java.util.Scanner;

public class Fibonacci_Factorial {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Number: ");
		int number = scanner.nextInt();

		System.out.println("Factorial : " + factorial(number));
		System.out.print("Fibonaci : ");
		for (int i = 0; i <= number; i++) {
			System.out.print(fibo(i) + " ");
		}
		System.out.println();

		System.out.print("Factorial Without Recursion : ");
		fiboSeries(number);
	}

	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static int fibo(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fibo(n - 1) + fibo(n - 2);
	}

	public static void fiboSeries(int n) {
		int first = 0;
		int second = 1;
		int result;
		for (int i = 0; i <= n; i++) {
			System.out.print(first + " ");
			result = first + second;
			first = second;
			second = result;
		}
	}
}

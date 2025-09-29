package com.practise.recursion;

import java.util.Scanner;

public class Sum_Reverse_Palindrome_Digits {

	public static int temp;
	
	public static String actual;
	
	public static void main(String[] args) {
		System.out.println("Select the Choice");
		System.out.println("1. Number");
		System.out.println("2. String");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		switch(num){
		case 1:
			System.out.println("Please Enter the Number");
			int number = scanner.nextInt();
			temp = number;
			System.out.println("Sum Without Recursion : " + sum(number));
			System.out.println("Sum With Recursion : " + sumWithRecursion(number , 0));
			System.out.println("Reverse Without Recursion : " + reverse(number));
			System.out.println("Reverse With Recursion : " + reverseWithRecursion(number, 0));
			System.out.println("Palindrome With Recursion (Integer): " + palindromeWithRecursionIntger(number));
			break;
		case 2:
			System.out.println("Please Enter the String");
			String word = scanner.next();
			System.out.println("Palindrome Without Recursion : " + palindrome(word));
			System.out.println("Palindrome With Recursion " + palindromeWithRecursion(word, 0, word.length() - 1));
			break;
		default: 
			System.out.println("Please Enter the correct number");
			break;
		}
		scanner.close();
	}

	private static boolean palindromeWithRecursionIntger(int number) {
		if(number == 0) {
			return true;
		}
		if(!palindromeWithRecursionIntger(number / 10)) {
			return false;
		}
		int firstDigit = number % 10;
		int lastDigit = temp % 10;
		temp = temp / 10;
		
		return (firstDigit == lastDigit);
	}

	private static boolean palindromeWithRecursion(String word, int first, int last) {
		if(first > last) {
			return true;
		}
		if(word.charAt(first) != word.charAt(last)) {
			return false;
		}
		return palindromeWithRecursion(word, first++, last--);
	}

	private static boolean palindrome(String word) {
		int first = 0;
		int last = word.length() - 1;
		while(last > first) {
			if(word.charAt(first) != word.charAt(last)) {
				return false;
			}
			last--;
			first++;
		}
		
		return true;
	}

	private static int reverseWithRecursion(int number, int sum) {
		if (number == 0) {
			return sum;
		}
		sum = sum * 10 + number % 10;
		number = number / 10;
		return sumWithRecursion(number, sum);
	}

	private static int reverse(int number) {
		int result = 0;
		while (number > 0) {
			result = result * 10 + number % 10;
			number = number / 10;
		}
		return result;
	}

	private static int sumWithRecursion(int number, int sum) {
		if (number == 0) {
			return sum;
		}
		sum = sum + number % 10;
		number = number / 10;
		return sumWithRecursion(number, sum);
	}

	private static int sum(int number) {
		int result = 0;
		while (number > 0) {
			result = result + number % 10;
			number = number / 10;
		}
		return result;
	}

}

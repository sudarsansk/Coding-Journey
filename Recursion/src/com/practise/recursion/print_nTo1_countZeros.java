package com.practise.recursion;

import java.util.Scanner;

public class print_nTo1_countZeros {

	public static void main(String[] args) {
		System.out.println("Enter the number");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		int num = number % 10;

		printNumber(num);
		System.out.println();
		System.out.print("Count of Zero's : " + countZeros(number, 0));
		scanner.close();
	}

	private static int countZeros(int number, int count) {
		if(number == 0) {
			return count;
		}
		if(number % 10 == 0) {
			count++;
		}
		return countZeros(number / 10, count);
	}

	private static void printNumber(int number) {
		if (number == 0) {
			System.out.println();
			System.out.print("Reverse : ");
			return;
		}
		System.out.print(number + " ");
		printNumber(number - 1);
		System.out.print(number + " ");
	}
}

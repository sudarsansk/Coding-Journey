package com.practise.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Search_Front_Back {

	public static void main(String[] args) {
		System.out.println("Enter the Number to Search");
		int[] arr = { 2, 3, 4, 5, 6, 7, 9, 4, 1, 7, 9, 5 };
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		System.out.println("Front Back Search Without Recursion :" + front_back(arr, number));
		System.out.println("Back Search With Recursion : " + back_recur(arr, arr.length - 1, number));
		scanner.close();
	}

	public static List<List<Integer>> front_back(int[] arr, int target) {
		List<List<Integer>> result = new ArrayList<>();

		List<Integer> result1 = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == target) {
				result1.add(i);
			}
		}
		result.add(result1);
		
		List<Integer> result2 = new ArrayList<>();
		int y;
		for (int i = arr.length - 1; i >=0 ; i--) {
			y = 0;
			if(arr[i] == target) {
				result2.add(y);
			}
			y++;
		}
		
		result.add(result2);
		return result;
	}

	public static int back_recur(int[] arr, int index, int target) {
		if(index < 0) {
			return -1;
		}
		if(arr[index] == target) {
			return index;
		}
		
		return back_recur(arr, --index, target);
	}
}

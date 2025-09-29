package com.practise.search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 5, 6, 7, 9, 4, 7, 9, 5 };
		Arrays.sort(arr);

		System.out.println("Enter the target : ");
		Scanner scanner = new Scanner(System.in);
		int target = scanner.nextInt();

		System.out.println("Binary Search Without Recursion " + binarySearch(arr, target));
		System.out.println("Binary Search With Recursion " + binaryRec(arr, target, 0 , arr.length - 1));
		scanner.close();
	}

	//With Recursion
	private static int binaryRec(int[] arr, int target, int start, int end) {
		if(start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if(arr[mid] == target) {
			return mid;
		} else if (arr[mid] > target) {
			end = mid - 1;
		} else {
			start = mid + 1;
		}
		return binaryRec(arr, target, start, end);
	}

	//Without Recursion
	public static int binarySearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length;
		int mid;
		System.out.println(arr[2]);
		
		while (end > start) {
			mid= (start + end) / 2;
			if (arr[mid] == target) {
				return mid;
			}
			if (target > arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}
}

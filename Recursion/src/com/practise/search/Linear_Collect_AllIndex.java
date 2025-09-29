package com.practise.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Linear_Collect_AllIndex {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 5, 6, 7, 9, 4, 1, 7, 9, 5 };
		Arrays.sort(arr);

		System.out.println("Enter the target element");
		Scanner scanner = new Scanner(System.in);
		int target = scanner.nextInt();
		List<Integer> list = new ArrayList<>();
		System.out.println("Collection With List" + collectWithList(arr, list, 0, target));
		System.out.println("Collection Without List " + collectWithoutList(arr, 0, target));
		scanner.close();
	}

	private static List<Integer> collectWithList(int[] arr, List<Integer> newArr, int index, int target) {
		if(index == arr.length) {
			return newArr;
		}
		if(arr[index] == target) {
			newArr.add(index);
		}
		
		return collectWithList(arr, newArr, index + 1, target);
	}
	
	private static List<Integer> collectWithoutList(int[] arr, int index, int target) {
		List<Integer> newArr = new ArrayList<>();
		if(index == arr.length) {
			return newArr;
		}
		if(arr[index] == target) {
			newArr.add(index);
		}
		List<Integer> finalList = collectWithoutList(arr, index + 1, target);
		finalList.addAll(newArr);
		return finalList;
	}
}

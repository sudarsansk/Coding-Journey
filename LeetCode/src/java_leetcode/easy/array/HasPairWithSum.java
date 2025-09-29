package java_leetcode.easy.array;

import java.util.Arrays;

public class HasPairWithSum {

	public static boolean  hasPairWithSum(int[] arr, int target) {
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length - 1;
		while(left > right) {
			int sum = arr[left] + arr[right];
			if(sum == target) {
				return true;
			} else if(sum > target) {
				right--;
			} else {
				left++;
			}
		}
		return false;
	}
}

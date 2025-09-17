package java_stream.basics;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JavaStreamBasics {
	
	public static void main(String[] args) {
		
		//1. filter out even numbers 
		//2. Calculate the sum of all numbers in a list using streams
		//3. Convert a list of strings to uppercase
		//4. Find the first string that starts with "s" from a list
		//5. Count how many strings have length greater than 4
		//6. Find and merge First Letters of Each word problem 
		
		
		//Output - 1,2
		System.out.println(func_1_2());
		
		//Output - 3,4,5,6
		System.out.println(func_3_4_5_6());
	}

	private static String func_3_4_5_6() {
		List<String> str = Arrays.asList("sudarsan", "sreni", "mathi", "sabari", "Ara");
		List<String> upper = str.stream().map(name -> name.toUpperCase()).collect(Collectors.toList());
		Optional<String> first = upper.stream().filter(name -> name.length() > 4 && name.startsWith("S")).findFirst();
		System.out.println(upper.stream().map(name -> String.valueOf(name.charAt(0))).reduce("", (a , b) -> a + b));
		return first.orElse(":(");
	}

	private static int func_1_2() {
		List<Integer> arr = Arrays.asList(1,2,3,4,5,6,7,8);
		int output = arr.stream().filter(num -> num % 2 == 0).reduce(0, (a, b) -> a + b);
		return output;
	}

}

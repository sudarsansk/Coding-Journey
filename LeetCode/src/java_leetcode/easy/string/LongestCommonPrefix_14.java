package java_leetcode.easy.string;

public class LongestCommonPrefix_14 {
	
	public static String longestCommonPrefix(String[] str, String approach) {
		if(str.length == 0 || str == null) {
			return "";
		}
		
		//Using Prefix
		if(approach.equalsIgnoreCase("prefix")) {
			String prefix = str[0];
			for(int i = 1; i < str.length; i++) {
				while(!str[i].startsWith(prefix)) {
					prefix = prefix.substring(0, prefix.length() - 1);
					if(prefix.isEmpty()) return "";
				}
			}
			return prefix;	
		}
		
		//Using Vertical Check Approach
		for(int k = 0; k < str[0].length() ; k++) {
			char currentChar = str[0].charAt(k);
			
			for(int z =1; z < str.length ; z++) {
				if(k >= str[z].length() || currentChar != str[z].charAt(k)) {
					return str[0].substring(0, k);
				}
			}
		}
		return str[0];
	}

}

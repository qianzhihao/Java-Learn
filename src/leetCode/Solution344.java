//#344 Reverse String
package leetCode;

public class Solution344 {
	public static String reverseString(String s) {
		if (s == null || s.length() == 0) {
			return "";
		} else {
			StringBuilder sb = new StringBuilder();
			for (int index = s.length() - 1; index  >= 0; --index) {
				char temp = s.charAt(index);
				sb.append(temp);
			}
			return sb.toString();
		}
	}

}

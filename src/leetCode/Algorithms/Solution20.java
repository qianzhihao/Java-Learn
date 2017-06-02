package leetCode.Algorithms;

import java.util.Stack;

/**
 * @author HP
 * 
 * Valid Parentheses
 * 
 * Q：
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

   The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

public class Solution20 {
	public boolean isValid(String s) {
		// 新建一个堆栈 stack；
		Stack<Character> stack = new Stack<Character>();
		// for 循环，依次将字符串 s 转换成字符 c ；
		for (char c : s.toCharArray()) {
			// 如果字符 c 为“（”，则将“）”入堆栈 stack ；
			if (c == '(')
				stack.push(')');
			// 如果字符 c 为“{”，则将“｝”入堆栈 stack ；
			else if (c == '{')
				stack.push('}');
		    // 如果字符 c 为“[”，则将“]”入堆栈 stack ；
			else if (c == '[')
				stack.push(']');
			// 如果堆栈 stack 为空或者出栈元素与字符 c 不同，则返回 false；
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		// 如果堆栈为空，则返回 true，否则返回 false；
		return stack.isEmpty();
	}
}

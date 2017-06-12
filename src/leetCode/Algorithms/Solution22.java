package leetCode.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
/*	Q：Generate Parentheses

	Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

	For example, given n = 3, a solution set is:

	[
	  "((()))",
	  "(()())",
	  "(())()",
	  "()(())",
	  "()()()"
	]*/

	public List<String> generateParenthesis(int n) {
		// 新建一个用来存放字符串的 list ；
		List<String> list = new ArrayList<String>();
		// 调用函数 backtrack，传入参数如下所示；
		backtrack(list, "", 0, 0, n);
		// 返回 list，即所要求的结果；
		return list;
	}

	// 函数 backtrack，参数分别为使用函数之前的 list， 要添加的字符串， 左括号的个数，右括号的个数以及最大值。
	public void backtrack(List<String> list, String str, int open, int close, int max) {
		// 如果字符串 str 的长度等于最大值的两倍，则将字符串 str 添加到 list 中并返回；
		if(str.length() == max * 2) {
			list.add(str);
			return;
		}
		// 如果左括号的个数小于最大值，则调用函数 backtrack，传入参数如下所示；
		if (open < max)
			backtrack(list, str + "(", open + 1, close, max);
		// 如果右括号的个数小于左括号的个数，则调用函数 backtrack，传入参数如下所示；
		if (close < open)
			backtrack(list, str + ")", open, close + 1, max);
	}
}

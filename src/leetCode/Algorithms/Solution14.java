package leetCode.Algorithms;

/**
 * Q：Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

 */
public class Solution14 {
	public String longestCommonPrefix (String[] strs) {
		// 如果字符串为空，或者字符串的长度为零，则返回空；
		if (strs == null || strs.length == 0) {
			return "";
		}
		// 定义一个字符串 pre，初始化为字符串组中的第一个字符串；
		String pre = strs[0];
		int i = 1;
		// while 循环，循环条件是 i 小于字符串组的大小；
		while (i < strs.length) {
			// while 循环，循环条件是在字符串组第（i+1）个字符串中存在指定的字符串 pre ；
			while (strs[i].indexOf(pre) != 0) {
				// 字符串 pre 去掉最后一个字符然后赋值给自己；
				pre = pre.substring(0, pre.length() - 1);
			}
			i++;
		}
		// 返回 pre，即最终的求解结果；
		return pre;
	}
}

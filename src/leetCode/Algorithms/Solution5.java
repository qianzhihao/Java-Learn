package leetCode.Algorithms;

/**
 * Q: Long Palindromic Substring
 *  最长回文字符串
 *  Given a string s, find the longest palindromic substring in s.
 *  You may assume that the maximum length of s is 1000.
 * 
 * 如果一个字符串从左向右写和从右向左写是一样的，这样的字符串就叫做palindromic string，
 * 如aba,或者abba。本题是这样的，给定输入一个字符串，要求输出一个子串，使得子串是最长的
 * padromic string。
 * 
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 */

public class Solution5 {
	private int lo, maxLen;
	// 函数功能：返回最长回文串；
	public String longestPalindrome(String s) {
		// 定义一个整型变量 len ，初始化等于字符串的长度；
		int len = s.length();
		// 如果字符串长度为1，则直接返回该字符串；
		if (len < 2)
			return s;
		// 分奇偶两种情况进行最长回文串的扩展；
		for (int i = 0; i < len - 1; i++) {
			// 字符串为奇数个字符；
			extendPalindrome(s, i, i);
			// 字符串为偶数个字符；
			extendPalindrome(s, i, i + 1);
		}
		// 返回字符串 s 的子串开始的字符序号和结束的字符序号分别为 lo 和 （lo + maxLen）；
		return s.substring(lo, lo + maxLen);
	}
	// 函数功能：扩展回文字符；
	private void extendPalindrome(String s, int j, int k) {
		// while 循环，用 j 和 k 作为指针从字符串 s 的第（i + 1）个字符向两端移动，并且时刻比较两个指针指向的字符是否相同
		while ( j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		// 当 k 比 j 大 1时，回文串开始的下标为 （j + 1），结束的下标为 （k - j - 1）；
		if (maxLen < k - j -1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
}
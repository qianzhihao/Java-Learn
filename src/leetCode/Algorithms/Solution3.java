package leetCode.Algorithms;

import java.util.HashMap;

/**
 * @author qianzhihao
 * 
 * Q: 
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * A: 
 * 
 * the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values, and keep two pointers which define the max substring. move the right pointer to scan through the string , and meanwhile update the hashmap. If the character is already in the hashmap, then move the left pointer to the right of the same character last found. Note that the two pointers can only move forward.
 * 基本思路是：建一个存储字符串中每个字符及其所在位置的“哈希图”，用两个指针来定义最大的子串。移动右指针以扫描字符串，同时更新哈希图。如果右指针指向的字符已经存在哈希图中，则将左指针向右移动到相同的字符位置。
 *
 */
public class Solution3 {
	public int LengthOfLongestSubstring(String s) {
		//如果字符串s为空，则返回0
		if (s.length() == 0) {
			return 0;
		}
		//新建一个哈希图 map ；
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		//新建整型变量 max 并进行初始化 ；
		int max = 0;
		// for 循环，循环次数为字符串 s 的长度
		for (int i = 0, j = 0; i < s.length(); ++i) {
			//获取字符串 s 位置 i 的字符 s.charAt(i) ；
			//如果哈希图 map中包含 s.charAt(i) ，则执行以下代码 ；
			if (map.containsKey(s.charAt(i))) {
				//获取字符 s.charAt(i) 在哈希图 map 中的 Integer 值并加 1 ；
					//（map.get 方法——返回指定键所映射的值 ；）
				//将 j 和 map.get(s.charAt(i)) + 1 中最大的赋值给 j ；
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			//将 s.charAt(i)  ， i 作为 <Character, Integer> 传入哈希图 map 中 ；
			map.put(s.charAt(i), i);
			//将 max 和 i - j + 1 两个数字中的较大者赋值给 max ；
			max = Math.max(max, i - j + 1);
		}
		return max ;
	}
}
/**
今天在写代码注释的时候，因为翻译的问题，做不到信达雅，有些地方显得有些生硬。让我想起了柏杨版的资治通鉴中的翻译。
之前看知乎上面的人评价这本书，总是贬低大于褒奖。但是于我个人来说，我的文言理解能力可能达不到一定的高度，看柏杨先生的翻译，
对于像是资治通鉴这种鸿篇巨著我也不会那么望而却步了。虽然有些官职翻译的过于直白而丧失了古文的优美，但是其在译制大部头也是
花费了心血的，这是不能否认的，文学性上面的欠缺，不能诋毁其对于文言向白话转换的努力。所以这件事给我的启示就是我在做的这种事，
于人可能做不到制作精良，但是对于我个人知识的积累，对于很多编程入门还是有那么一点点的好处的罢
*/
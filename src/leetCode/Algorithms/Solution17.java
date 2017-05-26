package leetCode.Algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * @author HP
 * Q:
 * Letter Combinations of a Phone Number 
 * 
 * Given a digit string, return all possible letter combinations that the number could represent. 
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * 
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 */
public class Solution17 {
	
	public List<String> letterCombination(String digits) {
		// 新建一个链表 ans；
		LinkedList<String> ans = new LinkedList<String>();
		// 新建一个字符串组 mapping ，初始化为手机各个按键上面的字符串；
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		// for 循环，循环次数为按键的个数；
		for (int i = 0; i < digits.length(); i++) {
			// 将按键字符串中第（i+1）个字符表示的 int 值赋值给 x；
			int x = Character.getNumericValue(digits.charAt(i));
			// while 循环，循环条件是链表 ans 的顶端字符串的长度等于 i；
			while (ans.peek().length() == i) {
				// 链表 ans 删除第一个字符串，然后赋值给 t；
				String t = ans.remove();
				// foreach 循环，以字符串组 mapping 中第（x+1）个字符串转换成字符的形式进行循环；
				for (char s : mapping[x].toCharArray()) {
					// 链表 ans 添加字符 t 和 s；
					ans.add(t + s);
				}
			}
		}
		// 返回链表 ans，即所求得最终的结果；
		return ans ;
	}
}

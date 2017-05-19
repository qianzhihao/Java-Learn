package leetCode.Algorithms;

/*Q：Integer to Roman

Given an integer, convert it to a roman numeral.

Input is guaranteed to be whithin the range form 1 to 3999.*/

/*I = 1;
V = 5;
X = 10;
L = 50;
C = 100;
D = 500;
M = 1000;
其中每两个阶段的之间有一个减法的表示，比如900=CM， C写在M前面表示M-C。

范围给到3999，感觉情况不多直接打表其实更快，用代码判断表示估计比较繁琐。

然后就是贪心的做法，每次选择能表示的最大值，把对应的字符串连起来。 */

public class Solution12 {
	
	public String intToRoman (int num) {
		int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		
		// 创建一个StringBuilder;
		StringBuilder sb = new StringBuilder();
		
		// for 循环，循环次数为数组 values 的大小，每次循环后指向数组 values 中下一个数字 values[i]；
		for (int i = 0; i < values.length; i++) {
			// while 循环，循环条件是 num 大于数组中 values[i] 的值；
			while (num >= values[i]) {
				// num 减去 values[i] 的值赋值给自己；
				num -= values[i];
				// 将字符串 strs 中第(i+1)个字符添加到字符串 sb 后面；
				sb.append(strs[i]);
			}
		}
		// 将 StringBuilder sb 转换成字符串；
		return sb.toString();
	}
}

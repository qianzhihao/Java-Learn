package leetCode.Algorithms;

/**
 * Q: Reverse Integer
 * 
 * Example1: x = 123, return 321
 * 
 * Example2: x = -123, return -321
 *
 */

/**
 * 整体思路：利用除法取余取整来转换数字的顺序
 *
 */

public class Solution7 {
	public int reverse (int x) {
		int result = 0;
		// while 循环， x 为零时跳出；
		while (x != 0) {
			// 每次用10去除 x ，取余数，存放在 tail 变量中；
			int tail = x % 10;
			// 用10去乘上一次循环结束后的 result 值，加上刚才取得的余数，存放在 newResult 中；
			int newResult = result * 10 + tail;
			// 判断是否有溢出，有溢出的话就返回0；
			if ((newResult - tail) / 10 != result) {
				return 0;
			}
			// 将 newResult 暂存的数据赋给 result ；
			result = newResult;
			// 用10去除 x ，取整；
			x = x / 10;
		}
		// 循环结束，返回 result，即转换后的数字；
		return result;
	}
}

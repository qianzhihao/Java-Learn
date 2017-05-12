package leetCode.Algorithms;

public class Solution9 {
/**
	Q: Palindrome Number

	Determine whether an integer is a palindrome. Do this without extra space.

*/

// test

//	A1
	public boolean isPalindrome1 (int x) {
		// 如果是负数或者是10的倍数（0除外），则判断为假；
		if (x < 0 || (x != 0 && x % 10 == 0))
			return false;
		
		int rev = 0;
		// 通过 while 循环，将原来的数字转换成倒序的数字；
		while (x > rev) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}
		// 反转的数字与原数字相等或者整除10后与原数字相等就为真；
		return (x == rev || x == rev / 10);
	}

//	A2:
	public boolean isPalindrome2 (int x) {
		// 如果是负数，就判断为假
		if (x < 0)
			return false;
		
		int p = x;
		int q = 0;
		// p 大于等于10的话进行 while 循环
		while (p >= 10) {
			// 将 q 乘以10之后的数字赋值给 q；
			q *= 10;
			// 将 p 对10取余，加上 q 赋值给 q；
			q += p % 10;
			// 将 p 对10取整后赋值给 p；
			p /= 10;
		}
		// 当 q 与 x 对10取整后数字相等且 p 与 x 对10取余后数字相等的时候判断为真；
		return q == x / 10 && p == x % 10;
	}	
}

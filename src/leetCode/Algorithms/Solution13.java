package leetCode.Algorithms;

/**
 * Q: Roman to Integer
 * 
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 */

public class Solution13 {

	public int romanToInt(String s) {
		// 新建一个整型数组，用来存放每个罗马字母代表的数字，长度跟字符串 s 一样；
		int nums[] = new int[s.length()];
		// for 循环，循环次数为字符串 s 的大小；
		for (int i = 0; i < s.length(); i++) {
			// switch 循环，分别读取字符串 s 中 （i+1）位置上的字符，在整型数组 nums 中（i+1）的位置，赋值相应的数字；
			switch (s.charAt(i)) {
			case 'M':
				nums[i] = 1000;
				break;
			case 'D':
				nums[i] = 500;
				break;
			case 'C':
				nums[i] = 100;
				break;
			case 'L':
				nums[i] = 50;
				break;
			case 'X':
				nums[i] = 10;
				break;
			case 'V':
				nums[i] = 5;
				break;
			case 'I':
				nums[i] = 1;
				break;
			}
		}
		// 新建一个整型 sum，用来存放除 nums 最后两位数字外的数字之和；
		int sum = 0;
		// for 循环，循环次数为 nums 的长度减1；
		for (int i = 0; i < nums.length - 1; i++) {
			// 如果 nums 数组中第（i+1）位置的数字小于第（i+2）位置的数字，则 sum 减去第（i+1）位置的数字；
			if (nums[i] < nums[i + 1]) {
				sum -= nums[i];
			} 
			// 如果 nums 数组中第（i+1）位置的数字大于等于第（i+2）位置的数字，则 sum 加上第（i+1）位置的数字；
			else {
				sum += nums[i];
			}
		}
		// 返回 sum 和 nums 数组中倒数第二位数字之和，即罗马数字转换成十进制数字的结果；
		return sum  + nums[nums.length - 1];
	}
}

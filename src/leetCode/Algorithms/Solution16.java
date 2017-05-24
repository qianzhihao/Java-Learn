package leetCode.Algorithms;

import java.util.Arrays;

/**
 * @author HP
 * Q: 3Sum Closest
 * 
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class Solution16 {
	// 该方法传入两个参数，数组 num 和目标值 target, 返回数组
	public int threeSumClosest(int[] num, int target) {
		// 新建一个整数 result，初始化等于数组 num 第1个数字，第2个数字和最后一个数字之和；
		int result = num[0] + num[1] + num[num.length - 1];
		// 将数组 num 按照从小到大的顺序排列；
		Arrays.sort(num);
		// for 循环，循环次数为数组 num 的数字个数减1；
		for (int i = 0; i < num.length - 2; i++) {
			// 新建两个整数，分别初始化为 （i+1）和数组 num 的数字个数减1；
			int start = i + 1;
			int end = num.length - 1;
			// while 循环，循环条件是 start 小于 end；
			while (start < end) {
				// 新建一个整数 sum，初始化为数组 num 的第（i+1）个数、第（start+1）个数和第（end+1）个数的和；
				int sum = num[i] + num[start] + num[end];
				// 如果 sum 大于 目标数值 target，则 end 减1；
				if (sum > target) {
					end--;
				}
				// 否则，start 加1；
				else {
					start++;
				}
				// 如果（sum - target）的绝对值小于（result - target）的绝对值，则把 sum 的值赋值给 result；
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
			}
		}
		// 返回 result 的值，即最终的结果；
		return result ;
	}
}

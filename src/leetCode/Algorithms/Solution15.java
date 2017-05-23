package leetCode.Algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author QZh
 * @time 2017.05.23
 * Q：LeetCode#15：3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
   
   Note： The solution set must not contain duplicate triplets.
   
   For example, given array S = [-1, 0, 1, 2, -1, -4],
   A solution set is:
   [
   	[-1, 0, 1],
   	[-1, -1, 2]
   ]
 */
public class Solution15 {

	public List<List<Integer>> threeSum(int[] num) {
		// 对数组 num 中的数字按照从小到大的顺序进行排序；
		Arrays.sort(num);
		// 新建一个链表 res;
		List<List<Integer>> res = new LinkedList<>();
		// for 循环，循环的次数是 num 的大小减去2；
		for (int i = 0; i < num.length - 2; i++) {
			// 如果 i 等于 0 或者是数组 num 中第（i+1）个数字和第 i 个数字不相等，则执行一下语句；
			if (i == 0 || (i > 0 && num[i] != num[i-1])) {
				// 新建三个整数，lo 初始化为（i+1），hi初始化为数组 num 的长度减1，sum 初始化为数组 num 中最后一个数的相反数；
				int lo = i + 1;
				int hi = num.length - 1;
				int sum = 0 - num[i];
				// while 循环，循环条件是 lo 小于 hi；
				while (lo < hi) {
					// 如果 num 中第（lo+1）个数加上第（hi+1）个数等于 sum ，则执行以下语句；
					if (num[lo] + num[hi] == sum) {
						// 将数组 num 中第（i+1）个数，第（lo+1）个数和第（hi+1）个数添加到链表 res 中；
						res.add(Arrays.asList(num[i], num[lo], num[hi]));
						// while 循环，循环条件是 lo 小于 hi 且数组 num 中第（lo+1）个数和第（lo+2）个数相等；
						while (lo < hi && num[lo] == num[lo+1]) {
							lo++;
						}
						// while 循环，循环条件是 lo 小于 hi 且数组 num 中第（hi+1）个数和第 hi 个数相等；
						while (lo < hi && num[hi] == num[hi-1]) {
							hi--;
						}
						lo++;
						hi--;
					}
					// 如果 num 中第（lo+1）个数加上第（hi+1）个数小于 sum ，则执行以下语句；
					else if (num[lo] + num[hi] < sum) 
						lo++;
					else 
						hi--;
				}
			} 
		}
		// 返回链表 res，即求得的结果；
		return res;
	}
}

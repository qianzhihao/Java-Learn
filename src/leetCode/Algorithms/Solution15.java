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
		// 对数组中的数字按照从小到大的顺序进行排序；
		Arrays.sort(num);
		
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i-1])) {
				int lo = i + 1;
				int hi = num.length - 1;
				int sum = 0 - num[i];
				while (lo < hi) {
					if (num[lo] + num[hi] == sum) {
						res.add(Arrays.asList(num[i], num[lo], num[hi]));
						while (lo < hi && num[lo] == num[lo+1]) {
							lo++;
						}
						while (lo < hi && num[hi] == num[hi-1]) {
							hi--;
						}
						lo++;
						hi--;
					}
					else if (num[lo] + num[hi] < sum) 
						lo++;
					else 
						hi--;
				}
			} 
		}
		return res;
	}
}

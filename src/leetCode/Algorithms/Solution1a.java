package leetCode.Algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qianzhihao
 *		Given an array of integers, return indices of the two 
 *		numbers such that they add up to a specific target.
 *		You may assume that each input would have exactly one 
 *		solution, and you may not use the same element twice.
 *
 *		Example:
 *			Given nums = [2, 7, 11, 15], target = 9,
 *			Because nums[0] + nums[1] = 2 + 7 = 9,
 *			return [0, 1].
 *
 */

public class Solution1a {

//	函数入口，参数 nums 为给定的数组，target 为给定的两个数字之和
	public int[] twoSum(int[] nums, int target) {
//		新建一个 HashMap 类 tracker
		HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
//		新建一个 int 变量 len ，用来记录 nums 的长度
		int len = nums.length;
//		 for 循环，循环次数为 nums 的长度
		for (int i = 0; i < len; i++) {
//			 if 判断，若 tracker 中含有 nums[i] 这个值则运行以下两行代码
			if (tracker.containsKey(nums[i])) {
				int left = tracker.get(nums[i]);
				return new int[]{left+1, i+1};
			} 
//			tracker 中不含有 nums[i] 这个值则运行以下一行代码
			else {
				tracker.put(target - nums[i], i);
			}
		}
		return new int[2];
	}
}

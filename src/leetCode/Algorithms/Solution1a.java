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

//	������ڣ����� nums Ϊ���������飬target Ϊ��������������֮��
	public int[] twoSum(int[] nums, int target) {
//		�½�һ�� HashMap �� tracker
		HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
//		�½�һ�� int ���� len ��������¼ nums �ĳ���
		int len = nums.length;
//		 for ѭ����ѭ������Ϊ nums �ĳ���
		for (int i = 0; i < len; i++) {
//			 if �жϣ��� tracker �к��� nums[i] ���ֵ�������������д���
			if (tracker.containsKey(nums[i])) {
				int left = tracker.get(nums[i]);
				return new int[]{left+1, i+1};
			} 
//			tracker �в����� nums[i] ���ֵ����������һ�д���
			else {
				tracker.put(target - nums[i], i);
			}
		}
		return new int[2];
	}
}

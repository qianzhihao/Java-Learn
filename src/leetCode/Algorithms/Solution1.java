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
 * * 	Java Map ���������飺
 * 		 Map �ṩ��һ����ͨ�õ�Ԫ�ش洢������ Map ���������ڴ洢Ԫ�ضԣ�����ÿ��
 * 		��ӳ�䵽һ��ֵ���Ӹ����϶��ԣ����Խ� List �����Ǿ�����ֵ���� Map ����ʵ��
 * 		�ϣ����� List �� Map ���ڶ��� java.util ���⣬���߲�û��ֱ�ӵ���ϵ��

 */

public class Solution1 {

	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[1] = i + 1;
				result[1] = map.get(target - numbers[i]);
				return result;
			}
			map.put(numbers[i], i + 1);
		}
		return result;
	}

}

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

public class Solution1 {
//	������ڣ����� numbers Ϊ���������飬target Ϊ��������������֮��
	public int[] twoSum(int[] numbers, int target) {
//		�½�һ������ result�������������������
		int[] result = new int[2];
//		�½�һ�� HashMap �� map
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		 for ѭ����ѭ������Ϊ���������� numbers �ĳ���
		for (int i = 0; i < numbers.length; i++) {
//			map.containsKey���ж� map ���϶������Ƿ����ָ���ļ���
			if (map.containsKey(target - numbers[i])) {
				result[1] = i + 1;
//				map.get ����ָ������ӳ���ֵ
				result[0] = map.get(target - numbers[i]);
				return result;
			}
//			 map.put
//         1.��� key �Ƿ�Ϊ�գ�
//			2. ���� key �� hashcode ����table ����� index��
//			3. �ҵ� table �����Ԫ�أ� 
//			4. �����������û�о�put ��ȥ���о͸��£�
			map.put(numbers[i], i + 1);
		}
		return result;
	}

}

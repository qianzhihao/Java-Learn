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
//	函数入口，参数 numbers 为给定的数组，target 为给定的两个数字之和
	public int[] twoSum(int[] numbers, int target) {
//		新建一个数组 result，用来存放最终运算结果
		int[] result = new int[2];
//		新建一个 HashMap 类 map
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		 for 循环，循环次数为给定的数组 numbers 的长度
		for (int i = 0; i < numbers.length; i++) {
//			map.containsKey：判断 map 集合对象中是否包含指定的键名
			if (map.containsKey(target - numbers[i])) {
				result[1] = i + 1;
//				map.get 返回指定键所映射的值
				result[0] = map.get(target - numbers[i]);
				return result;
			}
//			 map.put
//         1.检查 key 是否为空；
//			2. 计算 key 的 hashcode 和在table 里面的 index；
//			3. 找到 table 上面的元素； 
//			4. 遍历链表，如果没有就put 进去，有就更新；
			map.put(numbers[i], i + 1);
		}
		return result;
	}

}

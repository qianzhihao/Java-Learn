package leetCode.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HP
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */

public class Solution18 {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		// 新建一个链表 res；
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		// 定义一个整数 len，大小初始化为数组 nums 的长度；
		int len = nums.length;
		// 如果数组 nums 为空或者长度小于4，则返回链表 res；
		if (nums == null || len < 4) {
			return res;
		}
		// 将数组 nums 中的数字按照从小到大的顺序重新进行排序；
		Arrays.sort(nums);
		// 定义一个整数 max，初始化为数组 nums 中最后一个数字（已按照从小到大的顺序重新排序后的数）；
		int max = nums[len - 1];
		// 如果给的目标值小于数组 nums 中最小数字的四倍或者大于 nums 中最大数字的四倍，则返回 res；
		if (4 * nums[0] > target || 4 * max < target) {
			return res;
		}
		// 定义两个整数 i 和 z；
		int i, z;
		// for 循环，循环次数为数组 nums 的长度；
		for (i = 0; i < len; i++) {
			// 将数组 nums 中第（i+1）个数字赋值给 z；
			z = nums[i];
			// 如果 i 大于0，且 z 等于前一个数字，则执行下一循环；
			if (i > 0 && z == nums[i - 1]) {
				continue;
			}
			// 如果 z 加上数组中最大数小于目标值，则执行下一循环；
			if (z + 3 * max < target) {
				continue;
			}
			// 如果 z 的四倍大于目标值，则跳出 for 循环；
			if (4 * z > target) {
				break;
			}
			// 如果 z 的四倍等于目标值，则执行以下 if 语句后跳出 for 循环；
			if (4 * z == target) {
				// 如果数组 nums 的长度大于（i+3）且数组 nums 中第（i+4）个数字等于 z，则将（z，z，z，z）这样一条结果添加到链表 res 中去；
				if (i + 3 < len && nums[i + 3] == z) {
					res.add(Arrays.asList(z, z, z, z));
				}
				break;
			}
			// 调用函数 threeSumForFourSum；
			threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
		}
		// 返回链表 res ，即最终求得结果；
		return res;
	}

	public void threeSumForFourSum(int[] nums, int target, int low, int high,  ArrayList<List<Integer>> fourSumList, int z1) {
		// 如果最小值加1大于等于最大值，则结束当前函数；
		if (low + 1 >= high) {
			return;
		}
		// 新建一个整数 max，初始化为数组 nums 中第（high+1）个数字；
		int max = nums[high];
		// 如果目标值小于新数组 nums 中最小数字的三倍或者大于新数组 nums 中最大数字的三倍，则结束当前函数；
		if (3 * nums[low] > target || 3 * max < target) {
			return;
		}
		// 新建整数 i 和 z；
		int i, z;
		// for 循环，循环次数为（high-low-1）次；
		for (i = low; i < high - 1; i++) {
			// 讲数组 nums 中第（i+1）个数字赋值给 z；
			z = nums[i];
			// 如果 i > low，且 z 等于数组 nums 中倒数第二个数字，则跳出当前循环，进入下一个循环；
			if (i > low && z == nums[i - 1]) {
				continue;
			}
			// 如果目标值大于 z 加上新数组中最大值的两倍，则跳出当前循环，进入下一个循环；
			if (z + 2 * max < target) {
				continue;
			}
			// 如果目标值小于 z 的三倍，则跳出当前函数；
			if (3 * z > target) {
				break;
			}
			// 如果目标值等于 z 的三倍，则执行万以下 if 语句后跳出当前函数；
			if (3 * z == target) {
				// 如果 i + 1 < high，且数组 nums 中第（i+3）个数字等于 z，则将（z1，z，z，z）这样一条结果添加到链表 fourSumList 中去；
				if (i + 1 < high && nums[i + 2] == z) {
					fourSumList.add(Arrays.asList(z1, z, z, z));
				}
				break;
			}
			// 调用函数 twoSumForFourSum；
			twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
		}
	}

	public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList, int z1,
			int z2) {
		// 如果 low >= high，则结束当前函数；
		if (low >= high) {
			return;
		}
		// 如果目标值小于新数组 nums 中最小数的两倍，或者大于新数组 nums 中最大数的两倍，则结束当前函数；
		if (2 * nums[low] > target || 2 * nums[high] < target) {
			return;
		}
		// 新建整数 i，初始化为 low，新建整数 j，初始化为 high，新建整数 sum，x；
		int i = low, j = high, sum, x;
		// while 循环，循环条件是 i < j；
		while (i < j) {
			// 将数组 nums 中第（i+1）和第（j+1）个数字之和赋值给 sum；
			sum = nums[i] + nums[j];
			// 如果 sum值等于目标值，则执行以下语句；
			if (sum == target) {
				// 将（z1，z2，nums[i], nums[j]）这样一条结果添加到链表 fourSumList 中去；
				fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));
				// 将 nums[i] 赋值给 x；
				x = nums[i];
				// while 循环，每次循环开始前 i 加1，循环到 i 等于 j 的时候结束；
				while (++i < j && x == nums[i]) {
					;
					
				}
				// 将 nums[j] 赋值给 x；
				x = nums[j];
				// while 循环，每次循环开始前 j 减1，循环到 j 等于 i 的时候结束；
				while (i < -- j && x == nums[j]) {
					;
				}
			}
			// 如果目标值大于 sum，则 i 加一；
			if (sum < target) {
				i++;
			}
			// 如果目标值小于 sum，则 j 减一；
			if (sum > target) {
				j--;
			}
		}
		return;
	}
}

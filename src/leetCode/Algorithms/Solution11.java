package leetCode.Algorithms;

/**
 * @author qzh
 * 
 * Q：Container With Most Water
 * 
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 *
 */

/*AKA, the general idea to find some max is to go through all cases where max value can possibly occur and keep updating the max value. The efficiency of the scan depends on the size of cases you plan to scan.
To increase efficiency, all we need to do is to find a smart way of scan to cut off the useless cases and meanwhile 100% guarantee the max value can be reached through the rest of cases.

In this problem, the smart scan way is to set two pointers initialized at both ends of the array. Every time move the smaller value pointer to inner array. Then after the two pointers meet, all possible max cases have been scanned and the max situation is 100% reached somewhere in the scan. Following is a brief prove of this.

Given a1,a2,a3.....an as input array. Lets assume a10 and a20 are the max area situation. We need to prove that a10 can be reached by left pointer and during the time left pointer stays at a10, a20 can be reached by right pointer. That is to say, the core problem is to prove: when left pointer is at a10 and right pointer is at a21, the next move must be right pointer to a20.

Since we are always moving the pointer with the smaller value, i.e. if a10 > a21, we should move pointer at a21 to a20, as we hope. Why a10 >a21? Because if a21>a10, then area of a10 and a20 must be less than area of a10 and a21. Because the area of a10 and a21 is at least height[a10] * (21-10) while the area of a10 and a20 is at most height[a10] * (20-10). So there is a contradiction of assumption a10 and a20 has the max area. So, a10 must be greater than a21, then next move a21 has to be move to a20. The max cases must be reached.*/

public class Solution11 {
	public int maxArea(int[] height) {
// 定义一个左指针，初始化为零，定义一个右指针，初始化为高度的大小减一；
	    int left = 0, right = height.length - 1;
		int maxArea = 0;
// while 循环，循环条件为左指针小于右指针；

		while (left < right) {
// 最大面积取以下两者中的最大者：1.上一次循环后的最大面积；2.左指针和右指针中较小的一个与左右指针差的乘积；
			maxArea = Math.max(maxArea, Math.min(height[left], height[right])
					* (right - left));
			// 如果左边的高度小于右边的高度，则左边向右移动一个单位；
if (height[left] < height[right])
				left++;
// 否则，右边向左移动一个单位
			else
				right--;
		}

// 返回最大面积

		return maxArea;
	}
}

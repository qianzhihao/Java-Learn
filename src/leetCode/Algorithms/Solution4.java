package leetCode.Algorithms;

public class Solution4 {
	// 函数 findKthSmallest 的功能：找到两个数组中第 K 个最小的数；
	public static int findKthSmallest(int[] a, int m, int begin1, int[] b, int n, int begin2, int k) {
		//把较短的数组放在前面，较长的放在后面；
		if (m > n)
			return findKthSmallest(b, n, begin2, a, m, begin1, k);
		//如果数组 a 为空，则返回数组 b 的第k个数字（题目给出的两个数组已经是排好序的，所以第 k 个数，就是第 k 个最小的数字）；
		if (m == 0)
			return b[begin2 + k - 1];
		// 如果要找的是第1个最小的数字，直接返回数组 a 和数组 b 的第一个数字中的比较小的那个；
		if (k == 1)
			return Integer.min(a[begin1], b[begin2]);
		// 将 k 分成两段， partA 和 partB ，如果 k 的一半比数组 a 的长度还要大，那就以数组 a 的长度为分界点分段，否则将 k 平均分成两半；
		int partA = Integer.min(k / 2, m), partB = k - partA;
		// 比较数组 a 的第 partA 个数字和数组 b 的第 partB 个数字
		// 如果相等，就返回数组 a 的第 partA 个数字；
		if (a[begin1 + partA - 1] == b[begin2 + partB - 1])
			return a[begin1 + partA - 1];
		// 如果数组 a 的第 partA 个数字比数组 b 的第 partB 个数字大，就返回数组 a 和数组 b （从第 begin2 + partB 个数开始取，个数为 n - partB）组成的数组第 k - partB 个最小的数字；
		else if (a[begin1 + partA - 1] > b[begin2 + partB - 1])
			return findKthSmallest(a, m, begin1, b, n - partB, begin2 + partB, k - partB);
		// 其他情况就返回数组 a （从第 begin1 + partA 个数开始取，个数为 m - partA）和数组 b 组成的数组第 k - partA 个最小的数字；
		else
			return findKthSmallest(a, m - partA, begin1 + partA, b, n, begin2, k - partA);
	}

	// 方法 findMedianSortedArrays 的功能：找到两个数组的中位数；
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// len1 为数组 nums1 的长度， len2 为数组 nums2 的长度， sumLen 为两个数组的总长度；
		int len1 = nums1.length, len2 = nums2.length, sumLen = len1 + len2;
		// 如果两个数组总长度是奇数，则返回两个数组第 sumLen / 2 + 1 个最小的数字；
		if (sumLen % 2 != 0) {
			return findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2 + 1);
		} 
		// 如果两个数组总长度是偶数，则返回两个数组第 sumLen / 2 个最小的数字和第 sumLen / 2 + 1 个最小的数字的平均数；
		else {
			return (findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2)
					+ findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2 + 1)) / 2.0;
		}

	}
}

package leetCode.Algorithms;

/**
 * @author qianzhihao
 * Q: Add Two Numbers
 *  You are given two non-empty linked lists 
 *  representing two non-negative（非负） integers.
 *  The  digits are stored in reverse order and 
 *  each of  their nodes contain a single digit. 
 *  Add the  two numbers and return it as a 
 *  linked list.
 *  
 *  You may assume the two numbers do not 
 *  contain any leading zero, except the number 
 *  0 itself.
 *  
 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 0 -> 8
 *  
 *  有两个链表作为输入，它们表示逆序的两个非负数。
 *  如下面的两个链表表示的是342和465这两个数。
 *  你需要计算它们的和并且用同样的方式逆序输出。
 *  如342+465 = 807,你需要把结果表达为7 ->0 ->8
 * 
 */
public class Solution2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode c1 = l1;
		ListNode c2 = l2;
		ListNode sentinel = new ListNode(0);
		ListNode d = sentinel;
		int sum = 0;
		while (c1 != null || c2 != null ) {
			sum /= 10;
			if (c1 != null) {
				sum += c1.val;
				c1 = c1.next;
			}
			if (c2 != null) {
				sum += c2.val;
				c2 = c2.next;
			}
			d.next = new ListNode(sum % 10);
			d = d.next;
		}
		if (sum / 10 == 1) {
			d.next = new ListNode(1);
		}
		return sentinel.next;
	}
}
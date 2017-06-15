package leetCode.Algorithms;
/*
 * 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.
*/
public class Solution24 {

public ListNode swapPairs(ListNode head) {
	// 如果链表为空或者只有一个元素，则返回原链表；
	if ((head == null) || (head.next == null)) {
		return head;
	}
	// 新建一个链表 n，将 head 从第二个元素开始赋值给 n；
	ListNode n = head.next;
	// 调用本函数，传入参数为链表 head 从第三个元素开始，返回值连接到链表 head 的下一个元素；
	head.next = swapPairs(head.next.next);
	// 将 head 连接到 n 的下一个元素；
	n.next = head;
	// 返回链表 n，即所求结果；
	return n;
}
}

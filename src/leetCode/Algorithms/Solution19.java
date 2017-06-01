package leetCode.Algorithms;

/**
 * @author HP
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
   
 */
public class Solution19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// 新建一个空链表 start，分别将该链表头节点地址赋值给链表 slow 和 fast；
		ListNode start = new ListNode(0);
		ListNode slow = start, fast = start;
		// 将链表 head 连接到链表 slow 的后面；
		slow.next = head;
		// for 循环，循环次数为（n+1）次；
		// 将链表 fast 移动到 slow 前面 n 个距离；
		for (int i = 1; i <= n + 1; i++) {
			// 链表 fast 各节点数字赋值给前一个节点；
			fast = fast.next;
		}
		// while 循环，循环条件是 fast 不为空；
		// 将链表 fast 移动到链表末尾，并保持和 slow 之间的距离；
		while (fast != null) {
			// 链表 slow 各节点数字赋值给前一个节点；
			slow = slow.next;
			// 链表 fast 各节点数字赋值给前一个节点；
			fast = fast.next;
		}
		// 跳过指定的节点；
		slow.next = slow.next.next;
		// 返回链表 start 从第二个节点开始的链表结果；
		return start.next;
	}
}

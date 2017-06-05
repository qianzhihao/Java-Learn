package leetCode.Algorithms;

/*Merge Two Sorted Lists 

Q: 
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
*/

public class Solution21 {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// 如果链表 l1 为空，则直接返回链表 l2；
		if (l1 == null) {
			return l2;
		}
		// 如果链表 l2 为空，则直接返回链表 l1；
		if (l2 == null) {
			return l1;
		}
		
		// 新建一个链表 mergeHead；
		ListNode mergeHead;
		// 比较链表的头节点的大小，如果 l1 比较小，则将链表 l1 头节点的值赋值给 链表 mergeHead，然后递归本函数，传入参数为去掉该节点的 l1 和 l2；
		if (l1.val < l2.val) {
			mergeHead = l1;
			mergeHead.next = mergeTwoLists(l1.next, l2);
		}
		// 比较链表的头节点的大小，如果 l2 比较小，则将链表 l2 头节点的值赋值给 链表 mergeHead，然后递归本函数,传入参数为 l1 和 去掉该节点的 l2；
		else {
			mergeHead = l2;
			mergeHead.next = mergeTwoLists(l1, l2.next);
		}
		// 返回链表 mergeHead，即为最终合并的链表结果；
		return mergeHead;
	}
}

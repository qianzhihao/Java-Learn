package leetCode.Algorithms;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Q：
 * Merge k Sorted Lists
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 */
public class Solution23 {
/*
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val < o2.val)
					return -1;
				else if (o1.val == o2.val)
					return 0;
				else
					return 1;
			}
		});
		
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		
		for (ListNode node : lists)
			if (node != null)
				queue.add(node);
		
		while (!queue.isEmpty()) {
			tail.next = queue.poll();
			tail = tail.next;
			
			if (tail.next != null)
				queue.add(tail.next);
		}
		
		return dummy.next;
	}*/

	// 合并K个数列，传入参数为数列；
	public static ListNode mergeKLists (ListNode[] lists) {
		// 返回方法 partion ，传入参数为数列，0，数列长度减1；
		return partion(lists, 0, lists.length - 1);
	}
	
	// 方法 partion，参数分别为数列和两个整数 s 和 e；
	public static ListNode partion (ListNode[] lists, int s, int e) {
		// 如果整数 s 和 e相等，则返回数列中第（s+1）个数；
		if (s == e)
			return lists[s];
		// 如果整数 s 小于 e，则运行一下代码；
		if (s < e) {
			// 新建一个整数 q，将 s 和 e 和的一半取整赋值给 q；
			int q = (s + e) / 2;
			// 新建一个链表 l1，调用函数partion（传入参数为lists，s，q），函数返回的结果赋值给链表 l1；
			ListNode l1 = partion(lists, s, q);
			// 新建一个链表 l2，调用函数partion（传入参数为lists，q+1，e），函数返回的结果赋值给链表 l2；
			ListNode l2 = partion(lists, q+1, e);
			// 调用函数 merge，将链表 l1 和链表 l2 合并；
			return merge(l1, l2);
		} else
			return null;
	}
	
	public static ListNode merge (ListNode l1, ListNode l2) {
		// 如果 l1 为空，则返回 l2；
		if (l1 == null)
			return l2;
		// 如果 l2 为空，则返回 l1；
		if (l2 == null)
			return l1;
		// 如果 l1 的值小于 l2 的值，则将 l1 第二个值开始的链表和 l2 合并，连接在 l1 第一个值的后面，并返回 l1；
		if (l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		} 
		// 否则就将 l1 和 l2 第二个值开始的链表进行合并，连接在 l2 的第一个值的后面
		else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}
}

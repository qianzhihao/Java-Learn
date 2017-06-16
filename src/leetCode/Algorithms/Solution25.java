package leetCode.Algorithms;

/*25 Reverse Nodes in k-Group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 * 
 * */

public class Solution25 {

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode curr = head;
		int count = 0;
		while (curr != null && count != k) {
			// find the k+1 node
			curr = curr.next;
			count++;
		}
		// if k+1 node is found
		if (count == k) {
			// reverse list with k+1 node as head
			// head - head-pointer to direct part, 
	        // curr - head-pointer to reversed part;
			curr = reverseKGroup(curr, k);
			// reverse current k-group: 
			while (count --> 0) {
				// tmp - next head in direct part
				ListNode tmp = head.next;
				// preappending "direct" head to the reversed lis
				head.next = curr;
				// move head of reversed part to a new node
				curr = head;
				// move "direct" head to the next node in direct part
				head = tmp;
			}
			head = curr;
		}
		return head;
	}
}

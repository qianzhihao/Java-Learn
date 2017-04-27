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
public class Solution2a {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;

		ListNode listNode = new ListNode(0);
//		新建一个链表 listNode 用来存放相加的结果

		ListNode p1 = l1, p2 = l2, p3 = listNode;
//		 p1, p2 分别为相加的两个数字链表

		while (p1 != null || p2 != null) {
//		 while 循环， p1 或者 p2 都为空跳出循环

			if (p1 != null) {
//			 if 判断， p1 不为空时运行以下两行代码

				carry += p1.val;
				p1 = p1.next;
			}
//			第一次循环执行到这里: 
//			carry: 0 >> 3;
//			p1: (2 -> 4 -> 3) 指针指向 4 
//			p2: (5 -> 6 -> 4) 指针指向 4 
//			p3: (null)
//			listNode: (null)
			
//			第二次循环执行到这里：
//			carry: 0 >> 4;
//			p1: (2 -> 4 -> 3) 指针指向 2 
//			p2: (5 -> 6 -> 4) 指针指向 6 
//			p3: (7)
//			listNode: (7)

//			第三次循环执行到这里：
//			carry: 1 >> 1 + 2 >> 3;
//			p1: (2 -> 4 -> 3) 指针指向 2 之前，即为空 
//			p2: (5 -> 6 -> 4) 指针指向 5 
//			p3: (7 -> 0 -> 1) 指针指向 1
//			listNode: (7 -> 0 -> 1)
				
			if (p2 != null) {
				carry += p2.val;
				p2 = p2.next;
			}
//			第一次循环执行到这里：
//			carry: 3 >> 3 + 4 >> 7;
//			p1: (2 -> 4 -> 3) 指针指向 4 
//			p2: (5 -> 6 -> 4) 指针指向 6 
//			p3: (null)
//			listNode: (null)
			
//			第二次循环执行到这里：
//			carry: 4 >> 4 + 6 >> 10;
//			p1: (2 -> 4 -> 3) 指针指向 2 
//			p2: (5 -> 6 -> 4) 指针指向 5 
//			p3: (7)
//			listNode: (7)

//			第三次循环执行到这里：
//			carry: 3 >> 3 + 5 >> 8;
//			p1: (2 -> 4 -> 3) 指针指向 2 之前，即为空 
//			p2: (5 -> 6 -> 4) 指针指向 5 之前，即为空
//			p3: (7 -> 0 -> 1) 指针指向 1
//			listNode: (7 -> 0 -> 1)
			
			p3.next = new ListNode(carry % 10);
			p3 = p3.next;
//			第一次循环执行到这里：
//			carry: 7;
//			p1: (2 -> 4 -> 3) 指针指向 4 
//			p2: (5 -> 6 -> 4) 指针指向 6 
//			p3: (7) 指针指向 7 之后
//			listNode: (7)
			
//			第二次循环执行到这里：
//			carry: 10;
//			p1: (2 -> 4 -> 3) 指针指向 2 
//			p2: (5 -> 6 -> 4) 指针指向 5 
//			p3: (7 -> 0) 指针指向 0 之后
//			listNode: (7 -> 0)

//			第三次循环执行到这里：
//			carry: 8;
//			p1: (2 -> 4 -> 3) 指针指向 2 之前，即为空 
//			p2: (5 -> 6 -> 4) 指针指向 5 之前，即为空
//			p3: (7 -> 0 -> 8) 指针指向 8
//			listNode: (7 -> 0 -> 8)
			
			carry /= 10;
//			第一次循环执行到这里：
//			carry: 7 / 10 >> 0;
//			p1: (2 -> 4 -> 3) 指针指向 4 
//			p2: (5 -> 6 -> 4) 指针指向 6 
//			p3: (7)
//			listNode: (7)
			
//			第二次循环执行到这里：
//			carry: 10 / 10 >> 1;
//			p1: (2 -> 4 -> 3) 指针指向 2 
//			p2: (5 -> 6 -> 4) 指针指向 5 
//			p3: (7 -> 0) 指针指向 0 之后
//			listNode: (7 -> 0)			

//			第三次循环执行到这里：
//			carry: 8 >> 8 / 10 >> 0;
//			p1: (2 -> 4 -> 3) 指针指向 2 之前，即为空 
//			p2: (5 -> 6 -> 4) 指针指向 5 之前，即为空
//			p3: (7 -> 0 -> 8) 指针指向 8
//			listNode: (7 -> 0 -> 8)
		}
		if (carry == 1) {
			p3.next = new ListNode(1);
		}
//		第一次循环不执行上面的 if 语句

//		第二次循环执行到这里：
//		carry: 1;
//		p1: (2 -> 4 -> 3) 指针指向 2 
//		p2: (5 -> 6 -> 4) 指针指向 5 
//		p3: (7 -> 0 -> 1) 指针指向 1
//		listNode: (7 -> 0 -> 1)

//		第三次循环不执行上面的 if 语句

		return listNode.next; 
//		第一次循环执行到这里：
//		carry: 7 / 10 >> 0;
//		p1: (2 -> 4 -> 3) 指针指向 4 
//		p2: (5 -> 6 -> 4) 指针指向 6 
//		p3: (7)
//		listNode: (7)

//		第二次循环执行到这里：
//		carry: 1;
//		p1: (2 -> 4 -> 3) 指针指向 2 
//		p2: (5 -> 6 -> 4) 指针指向 5 
//		p3: (7 -> 0 -> 1) 指针指向 1
//		listNode: (7 -> 0 -> 1)

//		第三次循环执行到这里：
//		carry: 0;
//		p1: (2 -> 4 -> 3) 指针指向 2 之前，即为空 
//		p2: (5 -> 6 -> 4) 指针指向 5 之前，即为空
//		p3: (7 -> 0 -> 8) 指针指向 8
//		listNode: (7 -> 0 -> 8)
	}
}
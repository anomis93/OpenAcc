package com.practice.algorithms;
public class RemoveElementFromEnd {
	
	static int count=0;
	static int count2 = 0;
	public static void main(String []arg) {
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
//		l.next.next = new ListNode(3);
//		l.next.next.next = new ListNode(4);
//		l.next.next.next.next = new ListNode(5);
		
/*		ListNode head = removeFromEnd(l, 3);
		while(head != null) {
			System.out.println(head.val);
			head=head.next;
		}*/
		ListNode head = removeItration(l, 1);
		while(head != null) {
			System.out.println(head.val);
			head=head.next;
		}
	}
	
/*	public static ListNode removeFromEnd(ListNode head, int n) {
		
		if (head ==null) {
			return head;
		} else {
			count++;
			removeFromEnd(head.next, n);
			count--;
			count2++;
			n=n-count2;
			if(count==0 && n==0) {
				ListNode temp = head.next;
				head = null;
				return temp;
			}else if (n == -1) {
				if (head.next.next !=null) {
					head.next = head.next.next;
				}else {
					head.next = null;
				}
			}
			
			return head;
		}
		
	}*/
	
	public static ListNode removeItration(ListNode head, int n) {
		ListNode first = head;
		ListNode second = head;
		ListNode third = head;
		
		int count=1;
		boolean isSecActivated = false;
		
		
		while (first.next != null) {

			if (count < n) {
				first = first.next;
				count++;
			} else if (!isSecActivated) {
				isSecActivated = true;
				second = second.next;
				first = first.next;
			} else {
				third = second;
				second = second.next;
				first = first.next;
			}
		}
		
		third.next = second.next;
		if(second == head) {
			head = second.next;
		}
		return head;
	}
		
}

class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
}

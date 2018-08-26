package com.practice.algorithms;
public class ReverseLinkList {
	
	public static void main(String []arg) {
		
		
		Node head = createList();	
		Node head2 = null;
		Node bak = null;
		Node current = head;
		Node next = null;
		Node start = null;
		Node end = null;
		Node dummy1 = null;
		Node dummy2 = null;
		
		int n=4;
		int counter = 1;
		boolean check = false;
		
		while(current != null) {
			
			if(dummy1==null) {
				dummy1 = new Node(current.val);
				dummy2=dummy1;
			} else {
				dummy1.next = new Node(current.val);
				dummy1 = dummy1.next;
			}
			check = false;
			next = current.next;
			current.next = bak;
			bak = current;
			current = next;
			
			if(counter==n) {
				dummy1 =null;
				dummy2=null;
				
				check = true;
				counter=0;
				if(start==null && end==null) {
					start = current;
					end = head;
					head2=bak;
				} else {
					end.next = bak;
					end = start;
					start = current;
				}
			}
			
			counter++;
		}
		if(end != null) {
			if (!check) {
				end.next = dummy2;
			} else {
				end.next = null;
			}
		} else {
			head2 = dummy2;
		}
		
		while(head2!=null) {
			System.out.println(head2.val);
			head2 = head2.next;
		}
	}
	
	
	static Node createList() {
		Node node1 = new Node(3);
		Node node2 = new Node(2);
		Node node3 = new Node(4);
//		Node node4 = new Node(1);
//		Node node5 = new Node(5);
//		Node node6 = new Node(6);
//		Node node7 = new Node(7);
		
		node1.next = node2;
		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
//		node5.next = node6;
//		node6.next = node7;
		
		return node1;
	}

}

class Node {
	int val;
	Node next;
	
	Node(int val){
		this.val = val;
	}
}

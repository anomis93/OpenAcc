package com.practice.algorithms;
public class MergeTwoSortedList {

	public static void main(String arg []) {
		
		ListNodeTemp l1 = new ListNodeTemp(1);
		l1.next = new ListNodeTemp(2);
		l1.next.next = new ListNodeTemp(4);
		
		ListNodeTemp l2 = new ListNodeTemp(1);
		l2.next = new ListNodeTemp(3);
		l2.next.next = new ListNodeTemp(4);
		
		ListNodeTemp res = mergeTwoLists(l1, l2);
		
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
	
	public static ListNodeTemp mergeTwoLists(ListNodeTemp l1, ListNodeTemp l2) {
        
		ListNodeTemp result = new ListNodeTemp(0);
		ListNodeTemp temp = result;
        
        while(l1!=null || l2!=null){
            
            if(l1!=null && l2!=null){
                if(l1.val < l2.val){
                
                    temp.next =  new ListNodeTemp(l1.val);
                    l1 = l1.next;
                    temp = temp.next;
                } else {
                    
                    temp.next =  new ListNodeTemp(l2.val);        
                    l2 = l2.next;
                    temp = temp.next;
                }
            }
            else {
                if(l1!=null){
                    temp.next =  new ListNodeTemp(l1.val);
                    l1 = l1.next;
                    temp = temp.next;
                } else {
                    temp.next =  new ListNodeTemp(l2.val);        
                    l2 = l2.next;
                    temp = temp.next;
                }
            }
          
        }
        return result.next;
    }
}

class ListNodeTemp {
     int val;
     ListNodeTemp next;
     ListNodeTemp(int x) { val = x; }
}

package com.thread.synchronizers;
 
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryover = 0;
        
        ListNode l1Temp = l1;
        ListNode l2Temp = l2;
        
        ListNode resultNode = null;
        ListNode prevNode = null;
        
        while(l1Temp !=  null && l2Temp != null){
            
            int sum = l1Temp.val + l2Temp.val + carryover;
            carryover = 0;
            if(sum >= 10)
            {
                carryover = 1;
                sum -= 10; 
            }
            
            ListNode sumNode = new ListNode(sum);
            if(resultNode == null){
                resultNode = sumNode;
                prevNode = resultNode;
            }
            else{
                prevNode.next = sumNode;
                prevNode = sumNode;
            }
            l1Temp = l1Temp.next;
            l2Temp = l2Temp.next;
        }
        
        ListNode remainingNode = (l1Temp != null)?l1Temp:l2Temp;
        
        if(remainingNode != null){
             while(remainingNode !=  null){
                 int sum = remainingNode.val + carryover;
                 
                 carryover = 0;
                if(sum >= 10);
                {
                    carryover = 1;
                    sum -= 10; 
                }
                  ListNode sumNode = new ListNode(sum);
                  prevNode.next = sumNode;
                  prevNode = sumNode;
             }
            
        }
        
        return resultNode;
        
    }
    
    public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		
		ListNode result = addTwoNumbers(l1,l2);
		
		while(result!= null){
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
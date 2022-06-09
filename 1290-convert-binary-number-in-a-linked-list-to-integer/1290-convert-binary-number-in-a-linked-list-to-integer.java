/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
  
    
    public int getDecimalValue(ListNode head) {
        ListNode p = head;
        ListNode p1 = head;
        int number = 0;
        int length = 0;
        while(p != null){
		    // calculate length
            length += 1;
            p = p.next;
        }
        for(int i = length - 1; i >= 0; i--){
		    // calculate the number using the formula
            number += p1.val * Math.pow(2, i);
            p1 = p1.next;
        }
      return number;  
    }
}
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
  
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp1=head;
        // ListNode temp2=head.next;
        ListNode temp=head;
        int t=1;
        
        int length = 0;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
        int pos=length-n;
        if(head==null){
            return null;
        }
        if(pos==0){
         return head.next;
        }
        if(head.next==null && n==1){
            return null;
        }
        
        // System.out.println(length);
        // System.out.println(pos);
        while(pos!=1){
            temp1=temp1.next;
            // temp2=temp2.next;
            pos--;
        }
         System.out.println(temp1.val);
        // System.out.println(temp2.val);
        temp1.next=temp1.next.next;
        
        return head;
    }
}
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
    
//     static ListNode reverse(ListNode head){
//         if(head==null || head.next==null){
//             return head;
//         }
//         ListNode newhead=reverse(head.next);
//         head.next.next=head;
//         head.next=null;
//         return newhead;
        
//     }
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode a=head;
        ListNode prev=null;
        while(a!=null){
            ListNode temp=a.next;
            a.next=prev;
            prev=a;
            a=temp;
            
        }
        return prev;
     
        
    }
}
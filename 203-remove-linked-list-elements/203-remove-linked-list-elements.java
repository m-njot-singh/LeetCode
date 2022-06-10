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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }
        if(head.val==val && head.next==null){
            return head.next;
        }
        if(head.val==val && head.next!=null){
             while(head.next!=null){
            if(head.val==val ){
            head=head.next;
        }
                 else{
                     break;
                 }
        }
        if(head.val==val && head.next==null){
            return head.next;
        }
        }
       
        
        ListNode ans=head;
        ListNode a=head;
        ListNode b=head.next;
        
        while(b!=null){
            if(b.val!=val){
                a=a.next;
                b=b.next;
            }
            else{
                a.next=b.next;
                b=b.next;
            }
        }
        return head;
    }
}
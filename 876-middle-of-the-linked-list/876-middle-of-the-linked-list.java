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
    public ListNode middleNode(ListNode head) {
        ListNode a=head;
        ListNode b=head.next;
        if(head.next==null){
            return a;
        }
        while(b.next!=null ){
            a=a.next;
            b=b.next.next;
            if(b==null){
            return a;
        }
        }
       
        return a.next;
    }
}
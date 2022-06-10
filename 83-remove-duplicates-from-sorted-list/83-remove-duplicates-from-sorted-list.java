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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans=head;
        if(head==null || head.next==null){
            return head;
        }
        ListNode a=head;
        ListNode b=head.next;
       
        while(b!=null){
            if(a.val==b.val){
                b=b.next;
                a.next=b;
            }
            else{
                a=a.next;
                b=b.next;
            }
        }
        return ans;
        
    }
}
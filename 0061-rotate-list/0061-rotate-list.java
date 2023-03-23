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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)return head;
        ListNode t=head;
        int length=0;
        while(t!=null){
            length++;
            t=t.next;
        }
        k=k%length;
        while(k-->0){
            ListNode temp=head;
            ListNode nxt=head.next;
            while(nxt.next!=null){
                temp=temp.next;
                nxt=nxt.next;
            }
            temp.next=null;
            nxt.next=head;
            head=nxt;
        }
       return head;
    }
}
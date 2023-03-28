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
    public static ListNode reverse(ListNode head){
        if(head==null || head.next==null)return head;
        ListNode temp=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return temp;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next==null || head==null){
            return head;
        }
        int l=1;
        int r=1;
        ListNode temp=new ListNode(0);
        temp.next=head;
        ListNode prev=temp;
        ListNode nxt=head;
        ListNode last=nxt.next;
       while(l!=left){
           prev=prev.next;
           l++;
       }
        while(r!=right){
            nxt=nxt.next;
            last=nxt.next;
            r++;
        }
        // System.out.println(prev.val +" "+nxt.val+" "+last.val);
        nxt.next=null;
        ListNode curr=prev.next;
        ListNode ans=reverse(curr);
        prev.next=ans;
        curr.next=last;
        return temp.next;
    }
}
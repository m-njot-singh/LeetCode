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
        if(head==null || head.next==null)return head;
        ListNode itr=new ListNode(0);
        itr.next=head;
        ListNode curr=head.next;
        head=itr;
        while(curr!=null){
            boolean islooprun=false;
            while( curr!=null && curr.val==itr.next.val ){
                islooprun=true;
                curr=curr.next;
            }
            
            if(islooprun==true){
                itr.next=curr;
            }
            else{
                itr=itr.next;
            }
            
            if(curr!=null)curr=curr.next;
                
        }
        return head.next;
    }
}
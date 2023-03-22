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
    public static ListNode help(ListNode head){
        if(head==null || head.next==null)return head;
        ListNode temphead=help(head.next);
        head.next.next=head;
        head.next=null;
        return temphead;
        
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)return head;
         int i=0;
        int j=0;
        ListNode ans=null;
        ListNode curr=null;
        ListNode temphead=head;
        ListNode newhead=null;
        while(temphead!=null){
            while(temphead!=null && i<2){
                if(i==0){
                    curr=temphead;
                }
                else{
                    curr=curr.next;
                }
                
                temphead=curr.next;
                i++;
            }
            if(i==2){
                curr.next=null;
            if(j==0){
                ans=curr;
                j++;
            }
            else{
                head.next=curr;
                head=newhead;
            }
            help(head);
            newhead=temphead;
            i=0;
            }
            else{
                head.next=newhead;
            }
        }
        return ans;
    }
}
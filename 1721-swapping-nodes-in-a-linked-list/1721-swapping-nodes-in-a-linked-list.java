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
    public ListNode swapNodes(ListNode head, int k) {
        int len=0;
        ListNode temphead=head;
        // ListNode prev1=head;
        ListNode firstnum=head;
        // ListNode prev2=head;
        ListNode secondnum=head;
        while(temphead!=null){
            len++;
            temphead=temphead.next;
        }
        for(int i=1;i<k;i++){
            // if(i<k-1){
            //     prev1=prev1.next;
            // }
            firstnum=firstnum.next;
        }
        for(int i=0;i<len-k;i++){
            // if(i>len-k){
            //     prev2=prev2.next;
            // }
            secondnum=secondnum.next;
        }
        // System.out.println(firstnum.val +" "+ secondnum.val);
        // prev1.next=secondnum;
        // prev2.next=firstnum;
        // firstnum.enxt=secondnum.next;
        
        // secondnum.next=
        int temp=firstnum.val;
        firstnum.val=secondnum.val;
        secondnum.val=temp;
        return head;
    }
}
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)return null;
        ListNode temp=head;
        while(temp!=null){
            if(temp.val==Integer.MIN_VALUE){
                break;
            }
            temp.val=Integer.MIN_VALUE;
            temp=temp.next;
            
        }
        if(temp==null || temp.next==null)return null;
        return temp;
    }
}
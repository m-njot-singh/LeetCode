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
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode q=head;
        int a=-100000;
        while(q.next!=null){
            q.val=a;
            q=q.next;
            if(q.val==a){
                return true;
            }
        }
        return false;
        
    }
}
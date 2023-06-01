/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
       ListNode temp=node.next;
        ListNode curr=node;
        while(temp.next!=null){
           curr.val=temp.val;
           curr=curr.next;
            temp=temp.next;
        }
        curr.val=temp.val;
        curr.next=null;
    }
}
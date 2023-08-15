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
    public ListNode partition(ListNode head, int x) {
        ListNode temp=head;
        ListNode list1=new ListNode(0);
        ListNode list2=new ListNode(0);
        
        ListNode l1=list1;
        ListNode l2=list2;
        
        while(temp!=null){
            if(temp.val<x){
                l1.next=temp;
                l1=l1.next;
            }
            else{
                l2.next=temp;
                l2=l2.next;
            }
            temp=temp.next;
        }
        l1.next=list2.next;
        l2.next=null;
        
        return list1.next;
        
    }
}
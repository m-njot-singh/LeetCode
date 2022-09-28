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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return null;
        int length=0;
        int mid=0;
        ListNode temp=head;
        ListNode temp1=head;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        mid=length/2;
        System.out.println(length);
        System.out.println(mid);
        for(int i=0;i<mid-1;i++){ 
            
            temp1=temp1.next;
           System.out.println(temp1.val);
        }
        temp1.next=temp1.next.next;
        return head;
        
    }
}
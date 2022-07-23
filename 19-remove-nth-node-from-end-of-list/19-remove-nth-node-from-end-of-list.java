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
    public int length(ListNode head) {

		ListNode temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp1=head;
        ListNode temp2=head.next;
        int t=1;
        int length=length(head);
        int pos=length-n;
        if(head==null){
            return null;
        }
        if(pos==0){
         return head.next;
        }
        if(head.next==null && n==1){
            return null;
        }
        
        // System.out.println(length);
        // System.out.println(pos);
        while(t<pos){
            temp1=temp1.next;
            temp2=temp2.next;
            t++;
        }
         System.out.println(temp1.val);
        System.out.println(temp2.val);
        temp1.next=temp2.next;
        
        return head;
    }
}
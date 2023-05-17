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
    public int pairSum(ListNode head) {
        int max=Integer.MIN_VALUE;
        List<Integer> l=new ArrayList<>();
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null){
            l.add(slow.val);
            slow=slow.next;
            fast=fast.next.next;
        }
        Collections.reverse(l);
        // System.out.println(l);
        // slow=slow.next;
        ListNode newhead=head;
        int i=0;
        while(slow!=null){
            int sum=slow.val+l.get(i);
            // System.out.println(slow.val+" "+l.get(i));
            // System.out.println(sum);
            max=Math.max(max,sum);
            // System.out.println(max);
            i++;
            slow=slow.next;
        }
        
        return max;
    }
}
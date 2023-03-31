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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            ListNode temp=lists[i];
            while(temp!=null){
                l.add(temp.val);
                temp=temp.next;
            }
        }
        Collections.sort(l);
        // System.out.println(l);
        ListNode ans=new ListNode(0);
        ListNode newans=ans;
        for(int i=0;i<l.size();i++){
            ListNode t=new ListNode(l.get(i));
            ans.next=t;
            ans=ans.next;
        }
        return newans.next;
    }
}
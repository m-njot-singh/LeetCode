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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static TreeNode bst(List<Integer> l,int start,int end){
        if(start>=end)return null;
        int mid=(start+end)/2;
        // System.out.println(l.get(mid));
        TreeNode root=new TreeNode(l.get(mid));
        root.left=bst(l,start,mid);
        root.right=bst(l,mid+1,end);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode ans=new TreeNode();
        List<Integer> l=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){
            l.add(curr.val);
            curr=curr.next;
        }
        // System.out.println(l);
        ans=bst(l,0,l.size());
        return ans;
    }
}
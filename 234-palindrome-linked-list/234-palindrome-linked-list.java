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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        int num=0;
        ListNode size=head;
        while(size!=null){
            size=size.next;
            num++;
        }
        int []arr=new int[num];
        int j=0;
        while(head!=null){
            
            arr[j]=head.val;
            head=head.next;
            j++;
        }
        
        
         int flag = 0;
 
        // Loop till array size n/2.
        for (int i = 0; i <= num / 2 && num != 0; i++) {
 
            // Check if first and last element are different
            // Then set flag to 1.
            if (arr[i] != arr[num - i - 1]) {
                flag = 1;
                break;
            }
        }
 
        // If flag is set then print Not Palindrome
        // else print Palindrome.
        if (flag == 1)
            return false;
       
    
        return true;
    }
}
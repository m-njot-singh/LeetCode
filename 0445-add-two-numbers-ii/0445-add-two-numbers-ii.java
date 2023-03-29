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
    public static ListNode reverse(ListNode head){
        if(head==null || head.next==null)return head;
        ListNode temp=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return temp;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode x1=reverse(l1);
       ListNode x2=reverse(l2);
        // while(x1!=null){
        //     System.out.println(x1.val);
        // System.out.println(x2.val);
        //     x1=x1.next;
        //     x2=x2.next;
        // }
        
        ListNode ans=new ListNode(0);
        ListNode newhead=ans;
        int carry=0;
        while(x1!=null && x2!=null){
            int a=x1.val + x2.val+carry;
            // System.out.println(a);
            if(a>=10){
                a=a%10;
                carry=1;
            }
            else{
                a=a;
                carry=0;
            }
            ListNode temp=new ListNode(a);
            // System.out.println(temp.val);
            ans.next=temp;
            ans=ans.next;
            x1=x1.next;
            x2=x2.next;
        }
        // System.out.println(carry);
        if(x1==null && x2==null){
            if(carry==1){
                ans.next=new ListNode(1);
                ans=ans.next;
                ans.next=null;
            }
        }
        else if(x1==null && x2!=null){
             while(carry==1){ 
                 if(x2==null){
                   ans.next=new ListNode(1);
                   ans=ans.next;
                   ans.next=null;
                   return reverse(newhead.next);
               }
               ans.next=x2;
               ans=ans.next;
               x2=x2.next;
               // ans.val=ans.val+1;
               if((ans.val+1)>=10){
                   ans.val=(ans.val+1)%10;
                   carry=1;
               }
               else{
                   ans.val=(ans.val+1);
                    carry=0;
               }
              
           }
            ans.next=x2;
        }
       else if(x2==null && x1!=null){
           while(carry==1){
               // System.out.println(x1.val);
               // System.out.println(ans.val);
               if(x1==null){
                   ans.next=new ListNode(1);
                   ans=ans.next;
                   ans.next=null;
                   return reverse(newhead.next);
               }
               ans.next=x1;
               ans=ans.next;
               x1=x1.next;
               // ans.val=ans.val+1;
               if((ans.val+1)>=10){
                   ans.val=(ans.val+1)%10;
                   carry=1;
               }
               else{
                   ans.val=(ans.val+1);
                    carry=0;
               }
              
           }
           ans.next=x1;
        }
        return reverse(newhead.next);
    }
}
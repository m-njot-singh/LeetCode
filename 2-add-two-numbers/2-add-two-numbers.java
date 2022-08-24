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
    
//     static ListNode reverse(ListNode head){
//         ListNode prev=null;
//         ListNode curr=head;
//         while(prev!=null){
//             ListNode temp=curr.next;
//             curr.next=prev;
//             prev=curr;
//             curr=temp;
//         }
//         return prev;
//     }
    
    // static int nums(ListNode head){
    //     int num=0;
    //     while(head!=null){
    //         num=num*10+head.val;
    //         head=head.next;
    //     }
    //     return num;
    // }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // if(l1==null && l2==null){
        //     return null;
        // }
        // ListNode l1rev=reverse(l1);
        // ListNode l2rev=reverse(l2);
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode lx=l1;
        ListNode ly=l2;
        ListNode list=new ListNode(0);
        ListNode itr=list;
        // int num1=nums(l1);
        // int num2=nums(l2);
        // int ans=num1+num2;
        // System.out.println(num1);
        // System.out.println(num2);
        //  System.out.println(ans);
        int carry=0;
        while(lx!=null && ly!=null){
            int val=lx.val+ly.val+carry;
            carry=0;
            if(val>9){
                val=val%10;
                carry=1;
            }
            itr.next=new ListNode(val);
            lx=lx.next;
            ly=ly.next;
            itr=itr.next;
        }
        
        if(lx!=null){
            ListNode tail=lx;
            while(tail!=null){
                 int val=tail.val+carry;
            carry=0;
             if(val>9){
                val=val%10;
                carry=1;
            }
            tail.val=val;
            tail=tail.next;
            }
            itr.next=lx;
           
            
        }
        
         if(ly!=null){
            ListNode tail=ly;
            while(tail!=null){
                 int val=tail.val+carry;
            carry=0;
             if(val>9){
                val=val%10;
                carry=1;
            }
            tail.val=val;
            tail=tail.next;
            }
            itr.next=ly;
           
            
        }
        
        if(carry==1){
            ListNode last=list;
            while(last.next!=null){
                last=last.next;
            }
            last.next=new ListNode(carry);
            
        }
        // if(l1.next==null && l2.next==null){
        //     ListNode ll=new ListNode();
        //     ll.next=new ListNode(l1.val+l2.val);
        //     return ll.next;
        // }
        // while(ans>0){
        //     list.next=new ListNode(ans%10);
        //     System.out.println(list.val);
        //     list=list.next;
        //     ans=ans/10;
        // }
        
        return list.next;
    }
}
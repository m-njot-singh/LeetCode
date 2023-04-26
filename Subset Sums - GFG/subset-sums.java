//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    public static void solve(int i,int n,int sum,ArrayList<Integer> arr,ArrayList<Integer> ans){
        if(i==n){
            // System.out.println(sum);
            ans.add(sum);
            return;
        }
        solve(i+1,n,sum+arr.get(i),arr,ans);
        // sum-=arr.get(i);
        solve(i+1,n,sum,arr,ans);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        int sum=0;
        solve(0,N,sum,arr,ans);
        return ans;
    }
}
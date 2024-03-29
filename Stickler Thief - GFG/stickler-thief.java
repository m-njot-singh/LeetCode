//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    // public static int dfs(int n,int [] arr,int [] dp){
    //     if(n==0)return arr[n];
    //     if(n<0)return 0;
    //     if(dp[n]!=-1)return dp[n];
    //     int pick=arr[n]+dfs(n-2,arr,dp);
    //     int not_pick=0+dfs(n-1,arr,dp);
    //     return dp[n]=Math.max(pick,not_pick);
    // }
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int prev1=arr[0];
        int prev2=0;
        for(int i=1;i<n;i++){
            int pick=arr[i];
            if(i>1)pick+=prev2;
            int not_pick=0+prev1;
            int curr=Math.max(pick,not_pick);
            prev2=prev1;
            prev1=curr;
        }
        
        
        return prev1;
    }
}
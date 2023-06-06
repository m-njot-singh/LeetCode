//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    // public static int dfs(int ind,int target,int[] wt,int[] val,int[][] dp){
    //     if(ind==0){
    //         if(wt[ind]<=target)return val[ind];
    //         return 0;
    //     }
    //     if(dp[ind][target]!=-1)return dp[ind][target];
    //     int not_pick=0+dfs(ind-1,target,wt,val,dp);
    //     int pick=0;
    //     if(wt[ind]<=target){
    //         pick=val[ind]+dfs(ind-1,target-wt[ind],wt,val,dp);
    //     }
    //     return dp[ind][target]=Math.max(not_pick,pick);
    // }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int[][] dp=new int[n][W+1];
        for(int i=wt[0];i<=W;i++){
            dp[0][i]=val[0];
        }
        for(int ind=1;ind<n;ind++){
            for(int target=0;target<=W;target++ ){
                int not_pick=0+dp[ind-1][target];
            int pick=Integer.MIN_VALUE;
            if(wt[ind]<=target){
                pick=val[ind]+dp[ind-1][target-wt[ind]];
            }
            dp[ind][target]=Math.max(not_pick,pick);
            }
            
        }
         // your code here 
         return dp[n-1][W];
    } 
}



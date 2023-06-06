//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    public static int knapSack1(int W, int wt[], int val[], int n) 
    { 
        int[][] dp=new int[n][W+1];
        for(int i=0;i<=W;i++){
            dp[0][i]=((int)(i/wt[0]))*val[0];
        }
        for(int ind=1;ind<n;ind++){
            for(int target=0;target<=W;target++ ){
                int not_pick=0+dp[ind-1][target];
            int pick=Integer.MIN_VALUE;
            if(wt[ind]<=target){
                pick=val[ind]+dp[ind][target-wt[ind]];
            }
            dp[ind][target]=Math.max(not_pick,pick);
            }
            
        }
         // your code here 
         return dp[n-1][W];
    } 
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        return knapSack1(W,wt,val,N);
    }
}
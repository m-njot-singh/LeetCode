//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public static int dfs(int ind,int target,int[] price,int [][] dp){
        if(ind==0){
            return target*price[0];
        }
        if(dp[ind][target]!=-1)return dp[ind][target];
        int not_pick=0+dfs(ind-1,target,price,dp);
        int pick=Integer.MIN_VALUE;
        int rodlength=ind+1;
        if(rodlength<=target){
            pick=price[ind]+dfs(ind,target-rodlength,price,dp);
        }
        return dp[ind][target]=Math.max(pick,not_pick);
    }
    public int cutRod(int price[], int n) {
        //code here
        int[][] dp=new int[n][n+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return dfs(n-1,n,price,dp);
    }
}
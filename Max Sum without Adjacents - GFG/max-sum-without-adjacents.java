//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    // public static int dfs(int n,int [] arr,int [] dp){
    //     if(n==0)return arr[n];
    //     if(n<0)return 0;
    //     if(dp[n]!=-1)return dp[n];
    //     int pick=arr[n]+dfs(n-2,arr,dp);
    //     int not_pick=0+dfs(n-1,arr,dp);
    //     return dp[n]=Math.max(pick,not_pick);
    // }
    int findMaxSum(int arr[], int n) {
        // code here
        // int dp[]=new int[n+1];
        // dp[0]=arr[0];
        // int neg=0;
        // for(int i=1;i<n;i++){
        //     int pick=arr[i];
        //     if(i>1)pick+=dp[i-2];
        //     int not_pick=0+dp[i-1];
        //     dp[i]=Math.max(pick,not_pick);
        // }
        // return dp[n-1];
        
        int prev2=0;
        int prev1=arr[0];
        int curr=0;
        
        for(int i=1;i<n;i++){
            int pick=arr[i];
            if(i>1)pick+=prev2;
            int not_pick=0+prev1;
            
            curr=Math.max(pick,not_pick);
            prev2=prev1;
            prev1=curr;
            
        }
        
        return prev1;
    }
}
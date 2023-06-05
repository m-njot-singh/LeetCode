//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    // public static boolean dfs(int ind,int target,int n,int arr[],int[][] dp){
    //     if(target==0)return true;
    //     if(ind==0){
    //         return (arr[0]==target);
    //     }
    //     if(dp[ind][target]!=-1){
    //         if(dp[ind][target]==0)return false;
    //         return true;
    //     }
    //     boolean not_pick=dfs(ind-1,target,n,arr,dp);
    //     boolean pick=false;
    //     if(target>=arr[ind]){
    //         pick=dfs(ind-1,target-arr[ind],n,arr,dp);
    //     }
    //     if((not_pick || pick)==true){
    //         dp[ind][target]=1;
    //     }else{
    //         dp[ind][target]=0;
    //     }
        
    //     return (not_pick || pick);
    // }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        boolean[][] dp=new boolean[N][sum+1];
        for(int i=0;i<N;i++)dp[i][0]=true;
        if(arr[0]<=sum){
            dp[0][arr[0]]=true;
        }
        
        for(int i=1;i<N;i++){
            for(int target=1;target<=sum;target++){
                boolean not_pick=dp[i-1][target];
                boolean pick=false;
                if(target>=arr[i]){
                    pick=dp[i-1][target-arr[i]];
                }
                
                dp[i][target]=(not_pick||pick);
            }
        }
        return dp[N-1][sum];
    }
}
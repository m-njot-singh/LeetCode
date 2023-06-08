//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            ArrayList<Integer>ans=obj.longestIncreasingSubsequence(N, arr);
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int nums[]){
        int[] dp=new int[n];
        int[] hash=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
            hash[i]=1;
        }
        int max=-1;
        int lastIndex=-1;
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && dp[j]+1>dp[i]){
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
            if(dp[i]>max){
                max=dp[i];
                lastIndex=i;
            }
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(nums[lastIndex]);
        while(hash[lastIndex]!=lastIndex){
            lastIndex=hash[lastIndex];
            ans.add(nums[lastIndex]);
        }
        Collections.reverse(ans);
        return ans;
    }
}

class Solution {
    public static int dfs(int ind,int target,int[] arr,int[][] dp){
        if(target==0)return 1;
        if(ind==0){
            if(target%arr[0]==0)return 1;
            return 0;
        }
        if(dp[ind][target]!=-1)return dp[ind][target];
        int not_pick=0+dfs(ind-1,target,arr,dp);
        int pick=0;
        if(arr[ind]<=target){
            pick=dfs(ind,target-arr[ind],arr,dp);
        }
        return dp[ind][target]=pick+not_pick;
    }
    public int change(int target, int[] arr) {
        int n=arr.length;
        int[][] dp=new int[n][target+1];
        for(int i=0;i<=target;i++){
            if(i%arr[0]==0)dp[0][i]=1;
            else{
                dp[0][i]=0;
            }
        }
        
        for(int ind=1;ind<n;ind++){
            for(int t=0;t<=target;t++){
                
                int not_pick=dp[ind-1][t];
                int pick=0;
                if(arr[ind]<=t){
                    pick=dp[ind][t-arr[ind]];
                }
                dp[ind][t]=pick+not_pick;
                
                
            }
        }
        
        
       return dp[n-1][target];
    }
}
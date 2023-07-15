class Solution {
    public static int dfs(int i,int n,int k,int[][] events,int[][] dp){
        int j=0;
        if(i>=n || k==0){
            return 0; 
        }
        if(dp[i][k]!=-1)return dp[i][k];
        for(j=i+1;j<n;j++){
            if(events[j][0]>events[i][1]){
                break;
            }
        }
        int pick=events[i][2]+dfs(j,n,k-1,events,dp);
        int notpick=dfs(i+1,n,k,events,dp);
        return dp[i][k]=Math.max(pick,notpick);
    }
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int[][] dp=new int[events.length][k+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        
        return dfs(0,events.length,k,events,dp);
    }
}
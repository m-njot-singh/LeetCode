class Solution {
    public static int binary(int[][] events,int i){
        int l=i+1;  int h=events.length-1 ; int check=events[i][1];
        int ans=Integer.MAX_VALUE;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(events[mid][0]>check){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    public static int dfs(int i,int n,int k,int[][] events,int[][] dp){
        if(i>=n || k==0){
            return 0; 
        }
        if(dp[i][k]!=-1)return dp[i][k];
        // for(j=i+1;j<n;j++){
        //     if(events[j][0]>events[i][1]){
        //         break;
        //     }
        // }
        int j=binary(events,i);
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
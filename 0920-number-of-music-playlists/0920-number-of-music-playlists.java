class Solution {
    static int mod=1000000007;
    public static long count_playList(int count_songs,int count_uni,int goal,int k,int n,long[][] dp){
        if(count_songs==goal){
            if(count_uni==n){
                return 1;
            }
            return 0;
        }
        if(dp[count_songs][count_uni]!=-1)return dp[count_songs][count_uni];
        long result=0;
        if(count_uni<n){
            result+=(n-count_uni)*(count_playList(count_songs+1,count_uni+1,goal,k,n,dp));
        }
        if(count_uni>k){
            result+=(count_uni-k)*(count_playList(count_songs+1,count_uni,goal,k,n,dp));
        }
        
        return dp[count_songs][count_uni]=result%mod;
    }
    public int numMusicPlaylists(int n, int goal, int k) {
        long[][] dp=new long[goal+1][n+1];
        for(long[] it:dp){
            Arrays.fill(it,-1);
        }
       return  (int)count_playList(0,0,goal,k,n,dp);
    }
}
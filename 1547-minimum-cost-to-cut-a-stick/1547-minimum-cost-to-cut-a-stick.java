class Solution {
    // public static int dfs(int i,int j,int[] cuts,int[][] dp){
    //     if(i>j)return 0;
    //     if(dp[i][j]!=-1)return dp[i][j];
    //     int min=Integer.MAX_VALUE;
    //     for(int k=i;k<=j;k++){
    //         int cut=(cuts[j+1]-cuts[i-1])+dfs(i,k-1,cuts,dp)+dfs(k+1,j,cuts,dp);
    //         min=Math.min(min,cut);
    //     }
    //     return dp[i][j]=min;
    // }
    
    public static int mincost(int n,int c,int[]newcuts){
        int[][] dp=new int[c+2][c+2];
        for(int i=c;i>=1;i--){
            for(int j=1;j<=c;j++){
                if(i>j)continue;
                int min=Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int cut=(newcuts[j+1]-newcuts[i-1])+dp[i][k-1]+dp[k+1][j];
                    min=Math.min(min,cut);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][c];
    }
    
    
    public int minCost(int n, int[] cuts) {
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<cuts.length;i++){
            l.add(cuts[i]);
        }
        l.add(n);
        l.add(0);
        Collections.sort(l);
        int[] newcuts=new int[l.size()];
        for(int i=0;i<l.size();i++){
            newcuts[i]=l.get(i);
        }
        Arrays.sort(newcuts);
        
        return mincost(n,cuts.length,newcuts);
        
    }
}
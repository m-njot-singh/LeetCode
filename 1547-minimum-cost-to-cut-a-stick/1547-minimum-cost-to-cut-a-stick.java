class Solution {
    public static int dfs(int i,int j,int[] cuts,int[][] dp){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cut=(cuts[j+1]-cuts[i-1])+dfs(i,k-1,cuts,dp)+dfs(k+1,j,cuts,dp);
            min=Math.min(min,cut);
        }
        return dp[i][j]=min;
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
        int[][] dp=new int[newcuts.length][newcuts.length];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return dfs(1,cuts.length,newcuts,dp);
    }
}
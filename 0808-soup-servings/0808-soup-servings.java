class Solution {
    public static double rec(int a,int b,double[][] dp){
        if(a<=0 && b<=0)return 0.5;
        if(a<=0)return 1.0;
        if(b<=0)return 0.0;
        if(dp[a][b]!=-1)return dp[a][b];
        return dp[a][b]=0.25*(rec(a-100,b-0,dp)+rec(a-75,b-25,dp)+rec(a-50,b-50,dp)+rec(a-25,b-75,dp));
    }
    public double soupServings(int n) {
        if(n>=5000)return 1;
        double[][] dp=new double[n+1][n+1];
        for(double[] it:dp){
            Arrays.fill(it,-1);
        }
        return rec(n,n,dp);
    }
}
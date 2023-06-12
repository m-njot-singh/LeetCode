class Solution {
    
    public static int dfs(int i,int j,int[] nums,int[][] dp){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int max=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int cost=(nums[i-1]*nums[k]*nums[j+1])+dfs(i,k-1,nums,dp)+dfs(k+1,j,nums,dp);
            max=Math.max(max,cost);
        }
        return dp[i][j]=max;
    }
    
    public static int max(int n,int[] nums){
        int[][] dp=new int[n+2][n+2];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return dfs(1,n,nums,dp);
    }
    
    
    public int maxCoins(int[] nums) {
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            l.add(nums[i]);
        }
        l.add(0,1);
        l.add(1);
        int[] newnums=new int[l.size()];
        for(int i=0;i<l.size();i++){
            newnums[i]=l.get(i);
        }
        return max(nums.length,newnums);
    }
}
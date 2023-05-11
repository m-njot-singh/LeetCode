class Solution {
    public static int dfs(int i,int j,int[][] dp,int[] nums1,int[] nums2){
       if(i==nums1.length || j==nums2.length)return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int count=0;
        if(nums1[i]==nums2[j]){
            count=1+dfs(i+1,j+1,dp,nums1,nums2);
        }
        int a=dfs(i+1,j,dp,nums1,nums2);
        int b=dfs(i,j+1,dp,nums1,nums2);
        return dp[i][j]=Math.max(count,Math.max(a,b));
}
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
       // int count=0;
        int ans=0;
        int[][]dp=new int[nums1.length][nums2.length];
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                dp[i][j]=-1;
            }
        }
        ans=dfs(0,0,dp,nums1,nums2);
        return ans;
    }
}
class Solution {
    public long[] findPrefixScore(int[] nums) {
        long[] ans=new long[nums.length];
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            if(i==0){
                ans[i]=nums[i]+max;
            }
            else{
                ans[i]=ans[i-1]+nums[i]+max;
            }
        }
        return ans;
    }
}
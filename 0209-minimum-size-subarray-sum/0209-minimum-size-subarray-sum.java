class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums==null || nums.length==0)return 0;
        int i=0;
        int j=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        while(j<nums.length){
            sum+=nums[j++];
            while(sum>=target){
                min=Math.min(min,j-i);
                sum-=nums[i++];
            }
        }
        
        if(min==Integer.MAX_VALUE)return 0;
        return min;
        
        
    }
}
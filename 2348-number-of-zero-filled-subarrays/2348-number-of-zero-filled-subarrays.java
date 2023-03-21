class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int j=0;
        long ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)j=i+1;
            else if(nums[j]!=0){
                j++;
            }
            else if(nums[j]==0){
                ans+=i-j+1;
            }
        }
        
        return ans;
    }
}
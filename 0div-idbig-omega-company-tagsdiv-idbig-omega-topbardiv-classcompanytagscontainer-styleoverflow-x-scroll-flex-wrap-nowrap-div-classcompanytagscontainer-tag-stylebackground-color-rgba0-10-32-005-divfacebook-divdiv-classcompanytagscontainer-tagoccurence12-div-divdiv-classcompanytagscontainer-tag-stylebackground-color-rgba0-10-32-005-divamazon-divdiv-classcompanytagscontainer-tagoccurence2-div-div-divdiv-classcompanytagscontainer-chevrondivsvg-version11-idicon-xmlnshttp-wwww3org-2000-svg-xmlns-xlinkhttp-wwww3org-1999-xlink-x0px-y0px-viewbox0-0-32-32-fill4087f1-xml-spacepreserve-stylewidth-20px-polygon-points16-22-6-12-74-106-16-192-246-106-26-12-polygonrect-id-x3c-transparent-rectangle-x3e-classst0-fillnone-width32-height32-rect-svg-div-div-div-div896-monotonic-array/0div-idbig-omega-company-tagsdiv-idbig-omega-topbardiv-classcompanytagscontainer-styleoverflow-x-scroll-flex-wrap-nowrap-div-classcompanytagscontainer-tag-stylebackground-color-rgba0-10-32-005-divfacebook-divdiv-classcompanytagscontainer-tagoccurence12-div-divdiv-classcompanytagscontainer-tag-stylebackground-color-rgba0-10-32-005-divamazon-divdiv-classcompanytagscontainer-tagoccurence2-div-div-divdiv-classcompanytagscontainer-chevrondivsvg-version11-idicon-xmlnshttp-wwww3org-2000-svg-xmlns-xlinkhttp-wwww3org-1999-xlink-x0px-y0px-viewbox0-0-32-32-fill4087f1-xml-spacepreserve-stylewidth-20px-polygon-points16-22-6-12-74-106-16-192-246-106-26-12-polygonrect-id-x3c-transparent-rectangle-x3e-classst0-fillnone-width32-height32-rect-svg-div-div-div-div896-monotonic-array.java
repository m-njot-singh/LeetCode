class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length<=1)return true;
        int start=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                start=i;
                break;
            }
            else if(nums[i]>nums[i+1]){
                start=i;
                break;
            }
        }
        if(nums[start]<nums[start+1]){
            for(int i=start;i<nums.length-1;i++){
                if(nums[i]>nums[i+1])return false;
            }
        }
        else{
            for(int i=start;i<nums.length-1;i++){
                if(nums[i]<nums[i+1])return false;
            }
        }
        return true;
    }
}
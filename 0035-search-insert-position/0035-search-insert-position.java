class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target>nums[nums.length-1])return nums.length;
        if(target<nums[0])return 0;
        int j=0;
        while(j<nums.length){
            if(nums[j]==target || nums[j]>target) return j;
            if(nums[j]<target)j++;
        }
        return j;
    }
}
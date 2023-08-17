class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)return 0;
        if(nums[0]>nums[1])return 0;
        if(nums[nums.length-1]>nums[nums.length-2])return nums.length-1;
        
        int i=1;
        int j=nums.length-2;
        int ans=0;
        while(i<=j){
            int mid=i+(j-i)/2;
            // if(nums[i]==nums[j]){
            //     i++;
            //     j--;
            // }
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                ans=mid;
                break;
            }
            else if(nums[mid]>nums[mid-1] && nums[mid]<nums[mid+1]){
                i=mid+1;
            }
            else {
                j=mid-1;
            }
        }
        
        return ans;
    }
}
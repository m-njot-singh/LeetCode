class Solution {
    public boolean search(int[] nums, int target) {
         int i=0;
        int j=nums.length-1;
     while(i<=j){
         int mid=i+(j-i)/2;
         if(nums[mid]==target)return true;
         if(nums[mid]==nums[i] && nums[j]==nums[mid]){
             i++;
             j--;
         }
         else if(nums[i]<=nums[mid]){
             if(target>=nums[i] && target< nums[mid]){
                 j=mid-1;
             }
             else{
                 i=mid+1;
             }
         }
         else {
             if(target > nums[mid] && target <= nums[j]){
                 i=mid+1;
             }
             else{
                 j=mid-1;
             }
         }
     }
        
        return false;
    }
}
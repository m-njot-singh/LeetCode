class Solution {
    public int findClosestNumber(int[] nums) {
        int min=nums[0];
        for(int i=1;i<nums.length;i++){
            int a=Math.abs(nums[i]);
            int b=Math.abs(nums[i-1]);
            if(a>b){
                if(b<Math.abs(min)){
                    min=nums[i-1];
                }
            }
            else if(a==b){
                if(nums[i]>nums[i-1]){
                    min=nums[i];
                }
                else{
                    min=nums[i-1];
                }
            }
            else{
                if(a<Math.abs(min)){
                    min=nums[i];
                }
            }
        }
        return min;
        
    }
}
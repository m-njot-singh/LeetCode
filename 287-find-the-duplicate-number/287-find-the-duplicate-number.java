class Solution {
    public int findDuplicate(int[] nums) {
        int ans=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                ans=nums[i];
            }
        }
        return ans;
        
        
        
        
        
        
        
        
        // for(int i=0;i<nums.length;i++){
        //     for(int j=0;j<nums.length;j++){
        //         if(nums[i]==nums[j]){
        //             count++;
        //         }
        //         if(count==2){
        //             ans=nums[j];
        //             break;
        //         }
        //     }
        //     count=0;
        // }
        // return ans;
    }
}
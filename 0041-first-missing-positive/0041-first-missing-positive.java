class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int element=nums[i];
            
            if(element>0 && element<=n){
                int pos=element-1;
                if(nums[pos]!=element){
                    int temp = nums[pos];
                    nums[pos] = nums[i];
                    nums[i] = temp;
                    i--;
                }
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        
        return n+1;
    }
}
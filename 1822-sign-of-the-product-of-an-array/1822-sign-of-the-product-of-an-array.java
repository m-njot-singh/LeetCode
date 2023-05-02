class Solution {
    public int arraySign(int[] nums) {
        long product=1;
        for(int i=0;i<nums.length;i++){
            product*=nums[i];
            if(product>0){
                product=1;
            }
            if(product==0)return 0;
        }
       if(product>0)return 1;
        return -1;
        
    }
}
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)return 0;
        int i=0;
        int j=0;
        int mul=1;
        int count=0;
        while(j<nums.length){
            mul*=nums[j];
           while(mul>=k){
                mul/=nums[i++];
            }
            count+=(j-i)+1;
                j++;
        }
        return count;
    }
}
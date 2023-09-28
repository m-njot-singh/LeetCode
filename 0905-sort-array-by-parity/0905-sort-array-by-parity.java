class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if(nums.length<=1)return nums;
        int ind=0;
        int temp=0;
        int i=0;
        int j=nums.length-1;
        while(i<j){
            if(nums[j]%2==0){
                if(nums[i]%2!=0){
                    temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    i++;
                    j--;
                }else{
                    i++;
                }
                
            }
            else{
                j--;
            }
        }
        return nums;
    }
}
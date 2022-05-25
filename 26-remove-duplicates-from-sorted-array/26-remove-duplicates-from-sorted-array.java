class Solution {
    public int removeDuplicates(int[] nums) {
        int count=1;
        int num=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=num){
                count++;
                num=nums[i];
            }
            else if(nums[i]==num){
                nums[i]=101;
            }
            
            
        }
        Arrays.sort(nums);
        return count;
    }
}
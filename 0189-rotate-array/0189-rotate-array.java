class Solution {
    public void rotate(int[] nums, int k) {
      int temp=0;
        int n=nums.length;
        int[] q=new int[nums.length];
        for(int i=0;i<n;i++){
            q[(i+k)%n]=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=q[i];
        }
    }
}
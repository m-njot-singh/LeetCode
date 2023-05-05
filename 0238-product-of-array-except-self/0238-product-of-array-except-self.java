class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
       int[] left=new int[n];
       int[] right=new int[n];
        int i=0;
        int j=n-1;
        int leftmul=1;
        int rightmul=1;
        while(i<n && j>=0){
            leftmul*=nums[i];
            left[i]=leftmul;
            rightmul*=nums[j];
            right[j]=rightmul;
            i++;
            j--;
        }
        for(int q=0;q<n;q++){
            if(q==0){
                nums[q]=right[q+1];
            }
            else if(q==n-1){
                nums[q]=left[q-1];
            }
            else{
                nums[q]=left[q-1]*right[q+1];
            }
        }
        return nums;
    }
}
class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int ans=Integer.MIN_VALUE;;
        for(int i=0;i<nums.length;i++){
            if(st.isEmpty()){
                st.push(i);
            }
            if(!st.isEmpty() && nums[i]<nums[st.peek()]){
                st.push(i);
            }
        }
        
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                ans=Math.max(ans,i-st.peek());
                st.pop();
            }
        }
        if(ans==Integer.MIN_VALUE)return 0;
        return ans;
    }
}
class Solution {
    public int[] asteroidCollision(int[] nums) {
        Stack<Integer> s=new Stack<>();
       
        for(int i=0;i<nums.length;i++){
           if(s.isEmpty() || nums[i]>0){
               s.push(nums[i]);
           }
            else{
                while(true){
                    int peek=s.peek();
                    if(peek<0){
                        s.push(nums[i]);
                        break;
                    }
                    else if(peek==-nums[i]){
                        s.pop();
                        break;
                    }
                    else if(peek>-nums[i]){
                        break;
                    }
                    
                    else{
                        s.pop();
                        if(s.isEmpty()){
                            s.push(nums[i]);
                            break;
                        }
                    }
                }
            }
        }
         int [] ans=new int[s.size()];
        for(int i=s.size()-1;i>=0;i--){
            ans[i]=s.pop();
        }
        // Collections.reverse(Arrays.asList(ans));
        return ans;
    }
}
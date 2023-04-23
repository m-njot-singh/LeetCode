class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int i=0;
        int j=0;
        int idx=0;
        int [] ans=new int[nums.length-k+1];
        TreeMap<Integer,Integer> ts=new TreeMap<>();
        while(j<nums.length){
            ts.put(nums[j],ts.getOrDefault(nums[j],0)+1);
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                
               // System.out.println(ts);
                int count=0;
                for(Map.Entry<Integer,Integer> m:ts.entrySet()){
                    count+=m.getValue();
                    if(count>=x){
                        // System.out.println(m.getKey());
                        ans[idx++]=Math.min(m.getKey(),0);
                        break;
                    }
                   
                } 
                ts.put(nums[i],ts.get(nums[i])-1);
                    if(ts.get(nums[i])==0){
                        ts.remove(nums[i]);
                    }
                i++;
                j++;
            }
        }
       
        return ans;
    }
}
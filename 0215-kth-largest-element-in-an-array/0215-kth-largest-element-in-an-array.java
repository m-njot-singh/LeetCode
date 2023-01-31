class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap=new PriorityQueue<>(); 
        int i=0;
        while(i<k){
            maxheap.add(nums[i]);
            i++;
        }
        
        for(int j=k;j<nums.length;j++){
            if(maxheap.peek()<nums[j]){
                maxheap.poll();
                maxheap.add(nums[j]);
            }
                
        }
        
        return maxheap.peek();
    }
}
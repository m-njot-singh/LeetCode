class Solution {
    public int maximizeSum(int[] nums, int k) {
        int sum=0;
        PriorityQueue<Integer> maxheap=new PriorityQueue<>(Collections.reverseOrder());
        for(int a:nums){
            maxheap.add(a);
        }
        for(int i=k;i>0;i--){
            sum+=maxheap.peek();
            maxheap.add(maxheap.poll()+1);
        }
        
        return sum;
    }
}
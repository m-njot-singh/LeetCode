class Solution {
    public static int check(ArrayList<Integer> arr,int m,int mid){
        int count=1;
        int sum=arr.get(0);
        for(int i=1;i<arr.size();i++){
            if(sum+arr.get(i)<=mid){
                sum+=arr.get(i);
            }
            else{
                count++;
                sum=arr.get(i);
            }
        }
        return count;
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if(m>n)return -1;
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int it:arr){
            low=Math.max(low,it);
            high+=it;
        }
        while(low<=high){
            int mid=(low+high)/2;
            int temp=check(arr,m,mid);
            if(temp>m){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return low;
        

    }
    public int splitArray(int[] nums, int k) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int it:nums){
            arr.add(it);
        }
        return findPages(arr,arr.size(),k);
    }
}
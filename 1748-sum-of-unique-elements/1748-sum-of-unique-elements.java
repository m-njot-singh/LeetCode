class Solution {
    public int sumOfUnique(int[] arr) {
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(h.containsKey(arr[i])){
                h.put(arr[i], h.get(arr[i]) + 1);
            } else {
                h.put(arr[i], 1);
            }
        }
          int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            if(h.get(arr[i])==1)
                sum=sum+arr[i];
        }
        return  sum;
        
    }
}
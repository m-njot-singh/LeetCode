class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int a=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            if(a==Integer.MAX_VALUE){
                a=arr[i+1]-arr[i];
            }
            if(arr[i+1]-arr[i]!=a)return false;
        }
        return true;
    }
}
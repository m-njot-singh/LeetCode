class Solution {
    public long putMarbles(int[] weights, int k) {
        if(k==1)return 0;
        long[] l=new long[weights.length-1];
        long min=0;
        long max=0;
        for(int i=0;i<weights.length-1;i++){
            l[i]=weights[i]+weights[i+1];
        }
        Arrays.sort(l);
        for(int i=0;i<k-1;i++){
            min+=l[i];
            max+=l[l.length-1-i];
        }
        
        return max-min;
    }
}
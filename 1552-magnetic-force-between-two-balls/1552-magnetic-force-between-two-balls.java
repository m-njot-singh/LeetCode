class Solution {
    public static boolean check(int[]pos,int m,int mid){
        int count=1,last=pos[0];
        for(int i=1;i<pos.length;i++){
            if(pos[i]-last>=mid){
                count++;
                last=pos[i];
            }
            if(count>=m)return true;
        }
        return false;
    }
    public int maxDistance(int[] pos, int m) {
        Arrays.sort(pos);
        int  n=pos.length-1;
        int low=0;
        int high=pos[n]-pos[0];
        while(low<=high){
            int mid=(low+high)/2;
            if(check(pos,m,mid)==true){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        
        return high;
    }
}
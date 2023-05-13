class Solution {
    public static boolean bfs(int [] row,int i,int j,int target){
        int mid=0;
        while(i<=j){
            mid=i+(j-i)/2;
            if(target<row[mid]){
                j=mid-1;
            }
            else if(target>row[mid]){
                i=mid+1;
            }
            else{
                return true;
            }
        }
        // if(mid==0 && row[mid]==target)return true;
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] a:matrix){
            if(bfs(a,0,a.length-1,target)==true)return true;
        }
        return false;
    }
}
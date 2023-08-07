class Solution {
    public static boolean bsR(int start,int end,int row,int[][] matrix,int target){
        if(start>end)return false;
        int mid=start+(end-start)/2;
        
        if(target==matrix[row][mid])return true;
        else if(target>matrix[row][mid]){
            return bsR(mid+1,end,row,matrix,target);
        }
        else if(target<matrix[row][mid]){
            return bsR(start,mid-1,row,matrix,target);
        }
        return false;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length-1;
        
        int start=0;
        int end=m;
        
        for(int i=0;i<n;i++){
            if(bsR(start,end,i,matrix,target)==true)return true;
        }
        return false;
    }
}
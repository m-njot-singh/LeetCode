class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row=0;
        for(int i=0;i<matrix.length;i++){
            while(i<matrix.length && matrix[i][0]<target){
                row=i;
                i++;
            }
            if(i<matrix.length && matrix[i][0]==target){
                return true;
            }
        }
        
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[row][j]==target){
                return true;
            }
        }
        return false;
    }
}
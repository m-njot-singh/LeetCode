class Solution {
    public void setZeroes(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    for(int k=0;k<matrix.length;k++){
                        if(matrix[k][j]!=0){
                            matrix[k][j]=Integer.MIN_VALUE+1;
                        }
                         
                    }
                    for(int a=0;a<matrix[0].length;a++){
                        if(matrix[i][a]!=0){
                            matrix[i][a]=Integer.MIN_VALUE+1;
                        }
                        
                    }
                   
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==Integer.MIN_VALUE+1){
                    matrix[i][j]=0;
                }
            }
        }
        return;
    }
}
class Solution {
    public int diagonalSum(int[][] mat) {
        int sum=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
                if(i==j){
                    sum+=mat[i][j];
                }
            }
        }
        // System.out.println(sum);
        for(int i=0;i<mat.length;i++){
            for(int j=mat.length-1;j>=0;j--){
                sum+=mat[i][j];
                i++;
                // System.out.println(sum);
            }
        }
        
        if(mat.length%2!=0){
            int row=mat.length/2;
            int col=mat[0].length/2;
            return sum-mat[row][col];
        }
        return sum;
    }
}
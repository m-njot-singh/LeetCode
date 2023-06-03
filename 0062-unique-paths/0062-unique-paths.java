class Solution {
   
    public int uniquePaths(int n, int m) {
        int [] prev=new int [n];
        for(int i=0;i<m;i++){
            int[] temp=new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    temp[j]=1;
                    continue;
                }
                int down=0;
                if(i>0){
                    down=prev[j];
                } 
                int right=0;
                if(j>0){
                    right=temp[j-1];
                }
                temp[j]=down+right;
            }
            prev=temp;
        }
        return prev[n-1];
        
    }
}
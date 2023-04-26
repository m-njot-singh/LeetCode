class Solution {
    public List<String> printVertically(String s) {
        List<String> ans=new ArrayList<>();
        int m=Integer.MIN_VALUE;
        String [] temp=s.split(" ");
        for(String a:temp){
           m=Math.max(m,a.length());
        }
        char[][] matrix=new char[temp.length][m];
        for(char[] w:matrix){
            Arrays.fill(w,'0');
        }
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[i].length();j++){
                // System.out.print(temp[i].charAt(j)+" ");
                // if(temp[i].charAt(j)){
                     matrix[i][j]=temp[i].charAt(j);
                // }
               
            }
            // System.out.println();
        }
        for(int j=0;j<matrix[0].length;j++){
            String q="";
            String y="";
            int count=0;
            for(int i=0;i<matrix.length;i++){
                if(matrix[i][j]!='0'){
                    // System.out.print(matrix[i][j]+" ");
                    q=q+y+matrix[i][j];
                    y="";
                }
                else{
                    y+=" ";
                }
            }
            // System.out.println();
            ans.add(q);
        }
        return ans;
    }
}
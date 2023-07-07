class Solution {
    public static int help(String ans,int k , char c){
        int i=0;
        int j=0;
        int res=0;
        while(j<ans.length()){
            char a=ans.charAt(j);
            if(a!=c)k--;
            while(k<0){
                if(ans.charAt(i)==c)i++;
                else{
                    i++;
                    k++;
                }
            }
            res=Math.max(res,j-i+1);
            j++;
        }
        return res;
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
     return Math.max(help(answerKey,k,'T'),help(answerKey,k,'F'));   
    }
}
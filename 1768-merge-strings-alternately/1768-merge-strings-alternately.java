class Solution {
    public String mergeAlternately(String word1, String word2) {
        String ans="";
        int i=0;
        while(i<word1.length() && i<word2.length()){
            ans+=word1.charAt(i);
            ans+=word2.charAt(i);
            i++;
        }
        while(i<word1.length() || i<word2.length()){
            if(word1.length()>i){
                ans+=word1.charAt(i);
            }
            else{
                ans+=word2.charAt(i);
            }
            i++;
        }
        
        return ans;
    }
}
class Solution {
    public String reverseWords(String s) {
        s+=" ";
        String curr="";
        String prev="";
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                 if(prev!=""){
                    curr=prev+" "+curr;
                    prev="";
                }
            }
            else{
               
                prev+=s.charAt(i);
            }
        }
        
        return curr.substring(0,curr.length()-1);

    }
}
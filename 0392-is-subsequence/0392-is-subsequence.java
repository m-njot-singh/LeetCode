class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.equals(""))return true;
        if(t.equals(""))return false;
        int i=0;
        int j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        
        if(i<s.length())return false;
        return true;
    }
}
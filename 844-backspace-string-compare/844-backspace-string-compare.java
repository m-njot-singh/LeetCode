class Solution {
    public boolean backspaceCompare(String s, String t) {
        ArrayList a=new ArrayList<>();
        ArrayList b=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#' && a.size()>=1){
                a.remove(a.size()-1);
            }
            else if(s.charAt(i)!='#'){
                a.add(s.charAt(i));
            }
            
        }
         for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='#'&& b.size()>=1){
                b.remove(b.size()-1);
            }
            else if(t.charAt(i)!='#'){
                b.add(t.charAt(i));
            }
        }
        
        return a.equals(b);
    }
}
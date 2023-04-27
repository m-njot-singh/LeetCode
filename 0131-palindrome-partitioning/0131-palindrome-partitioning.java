class Solution {
   
    public static boolean valid(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public static void solve(String s,int idx,List<List<String>> ans,List<String> l){
        if(idx==s.length()){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(valid(s,idx,i)){
                l.add(s.substring(idx,i+1));
                solve(s,i+1,ans,l);
                l.remove(l.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> l=new ArrayList<>();
        solve(s,0,ans,l);
        return ans;
    }
}
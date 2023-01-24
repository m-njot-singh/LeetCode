class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> l=new HashSet<>();
        HashSet<String> ans=new HashSet<>();
        int start=0;
        while(start+10<=s.length()){
            String a=s.substring(start,start+10);
            if(l.contains(a)){
                ans.add(a);
            }
            else{
                l.add(a);
            }
            start++;
        }
        
        return new ArrayList<>(ans);
    }
}
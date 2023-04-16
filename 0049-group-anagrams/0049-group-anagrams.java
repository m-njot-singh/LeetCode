class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        List<List<String>> l=new ArrayList<>();
        for(String a:strs){
          char charArray[] = a.toCharArray();
          Arrays.sort(charArray);
            String s=new String(charArray);
            ArrayList<String> ll=map.getOrDefault(s,new ArrayList<String>());
            ll.add(a);
            map.put(s,ll);
        }
        for(Map.Entry<String,ArrayList<String>> e:map.entrySet()){
            l.add(e.getValue());
        }
        
        return l;
    }
}
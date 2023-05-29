class Pair{
    String first;
    int second;
    Pair(String _first,int _second){
        this.first=_first;
        this.second=_second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        for(String a:wordList){
            set.add(a);
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        
        while(!q.isEmpty()){
            String node=q.peek().first;
            int sum=q.peek().second;
            q.remove();
            if(node.equals(endWord)==true)return sum;
            for(int i=0;i<node.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char newstring[]= node.toCharArray();
                    newstring[i]=ch;
                    String s=new String(newstring);
                    if(set.contains(s)==true){
                        set.remove(s);
                        q.add(new Pair(s,sum+1));
                    }
                }
            }
            
        }
        return 0;
    }
}
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] news=s.split(" ");
        if(pattern.length()!=news.length)return false;
        HashMap<Character,String> map1=new HashMap<>();
        HashMap<String,Character> map2=new HashMap<>();
        
        for(int i=0;i<pattern.length();i++){
            if(map1.containsKey(pattern.charAt(i))){
                if(!map1.get(pattern.charAt(i)).equals(news[i]))return false;
            }
            else{
                map1.put(pattern.charAt(i),news[i]);
            }
             if(map2.containsKey(news[i])){
                if(map2.get(news[i])!=pattern.charAt(i))return false;
            }
            else{
                map2.put(news[i],pattern.charAt(i));
            }
        }
        
        return true;
    }
}
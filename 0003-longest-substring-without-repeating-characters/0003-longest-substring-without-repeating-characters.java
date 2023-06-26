class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int start=0;
        int end=0;
        int max=0;
        while(start<s.length()){
            
            if(set.contains(s.charAt(start))){
                
                set.remove(s.charAt(end));
                end++;
                
            }
            else{
                set.add(s.charAt(start));
                if(start-end+1>max){
                    max=start-end+1;
                    System.out.println(max);
                }
                start++;



                
            }
        }
        

    return max;
    }
}
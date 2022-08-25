class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
         Map<Character, Integer> hm2
            = new HashMap<Character, Integer>();
        char[] strArray1 = ransomNote.toCharArray();
                char[] strArray2 = magazine.toCharArray();
         
         for (char c : strArray2) {
            if (hm2.containsKey(c)) {
               
                // If char is present in charCountMap,
                // incrementing it's count by 1
                hm2.put(c, hm2.get(c) + 1);
            }
            else {
 
                // If char is not present in charCountMap,
                // putting this char to charCountMap with 1 as it's value
                hm2.put(c, 1);
            }
        }
        for (char c : strArray1) {
            if (!hm2.containsKey(c) || hm2.get(c)==0) {
               
                // If char is present in charCountMap,
                // incrementing it's count by 1
                return false;
            }
            else {
 
                // If char is not present in charCountMap,
                // putting this char to charCountMap with 1 as it's value
                hm2.put(c,hm2.get(c)-1);
            }
        }
        
        
         return true;
        
        
    }
}
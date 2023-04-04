class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        
        // Hashmap to store cards and the number of times they occurr
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        // Loop through the deck building the hashmap
        for (int i = 0; i < deck.length; i++) {
            hash.put(deck[i], hash.getOrDefault(deck[i], 0)+1);
        }
        
        // Get the lowest count value of a card
        int lowest = Integer.MAX_VALUE;
        for (int i : hash.keySet()) {
            lowest = Math.min(lowest, hash.get(i));
        }
        
        // Iterate from lowest integer down to 2 to see if a least common denominator exists
        for (int i = lowest; i >= 2; i--) {
            // Flag to detect if a number is a lcd
            boolean lcd = true;
            
            // Loop through the HashMap
            for (int j : hash.keySet()) {
                if (hash.get(j) % i != 0) lcd = false;
            }
            
            // If lcd is true, then the j value can divide all items in hash
            if (lcd == true) return true;
        }
        
        return false;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//         if(deck.length==1)return false;
//         HashMap<Integer,Integer> map=new HashMap<>();
//         for(int i=0;i<deck.length;i++){
//             map.put(deck[i],map.getOrDefault(deck[i],0)+1);
//         }
//         int cmp=0;
//         for(int i: map.keySet() ){
//             if(cmp==0){
//                 // System.out.println(map.get(i));
//                 cmp=map.get(i);
//             }
//             else{
//                 // System.out.println(map.get(i));
//                 if(map.get(i)==1)return false;
//                 if()
//                 if(map.get(i)%cmp!=0){
//                     return false;
//                 }
//             }
            
//         }
//         return true;
    }
}
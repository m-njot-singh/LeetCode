class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> l=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        // System.out.println(map);
        PriorityQueue<String> p=new PriorityQueue<>((a,b)->{
             // System.out.println(map.get(b) +" "+map.get(a)); 
               if(map.get(b)==map.get(a)){
                   // System.out.println("NO");
                   return a.compareTo(b);
               } 
            else{
                // System.out.println("YES");
                return map.get(b)-map.get(a);
            } 
        }
               
                                                     
                                                     // {
        //     if(a.getValue()==b.getValue()){
        //       return  b.getKey.compareTo(a.getKey());
        //      }
        //      else{
        //        return b.getValue()-a.getValue();
        //      }
        // }  
        );
        for(String n:map.keySet()){
            p.add(n);
        }
        
        for(int i=0;i<k;i++){
            l.add(p.peek());
            p.poll();
        }
         // Collections.sort(l);
        return l;
    }
}
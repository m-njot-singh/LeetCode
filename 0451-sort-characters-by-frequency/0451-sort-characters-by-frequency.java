class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        // System.out.println(map);
        PriorityQueue<Character> p=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(Character n:map.keySet()){
            p.add(n);
             // System.out.println(n + " "+ map.get(n));
        }
        // System.out.println(p);
        while(!p.isEmpty()){
            int count=map.get(p.peek());
            while(count>0){
                sb.append(p.peek());
                count--;
            }
            p.poll();
        }
        return sb.toString();
    }
}
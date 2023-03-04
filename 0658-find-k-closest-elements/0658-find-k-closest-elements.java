class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> l=new ArrayList<>();
        PriorityQueue<Pair<Integer,Integer>> pq=new PriorityQueue<>((a,b)->{
            // System.out.println("a=" + a);
            // System.out.println("b=" + b);
            // System.out.println("a.getKey="+a.getKey());
            // System.out.println("a.getValue="+a.getValue());
            // System.out.println("b.getKey="+b.getKey());
            // System.out.println("b.getValue="+b.getValue());
            if(a.getValue() == b.getValue()) return b.getKey()- a.getKey();
            return b.getValue()-a.getValue();
        });
        int j=0;
        for(int i=0;i<arr.length;i++){
            Pair<Integer,Integer> pair=new Pair<>(arr[i],Math.abs(x-arr[i]));
            if(pq.size()<k){
                pq.add(pair);
            }
           
            // System.out.println(pair);
            else{
                // System.out.println(pq.peek());
                if(pq.peek().getValue()> Math.abs(x-arr[i])){
                    pq.remove();
                    pq.add(pair);
                }
                
            }
            
        }
        
        while(pq.size()>0){
            // System.out.println(pq.poll().getKey());
            l.add(pq.peek().getKey());
            // System.out.println(pq.peek());
            
            pq.poll();
        }
        Collections.sort(l);
        return l;
    }
}
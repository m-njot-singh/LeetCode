class Solution {
  
    public String getPermutation(int n, int k) {
       List<Integer> l=new ArrayList<>();
        int fact=1;
        for(int i=1;i<n;i++){
            fact=fact*i;
            l.add(i);
        }
        l.add(n);
        String s="";
        k=k-1;
        while(true){
            s=s+l.get(k/fact);
            l.remove(k/fact);
            if(l.size()==0){
                break;
            }
            k=k%fact;
            fact=fact/l.size();
        }
        return s;
    }
}
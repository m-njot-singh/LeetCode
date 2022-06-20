class Solution {
    public List<String> buildArray(int[] target, int n) {
        ArrayList a=new ArrayList<Character>();
        int q=1;
        for(int i=1;i<n+1;i++){
            if(q>target.length){
                return a;
            }
            if(target[q-1]==i){
                a.add("Push");
                q++;
            }
            else{
                a.add("Push");
                a.add("Pop");
            }
        }
        
        return a;
    }
}
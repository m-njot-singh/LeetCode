class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> R=new LinkedList<>();
        Queue<Integer> D=new LinkedList<>();
        int n=senate.length();
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R'){
                R.add(i);
            }
            if(senate.charAt(i)=='D'){
                D.add(i);
            }
        }
         if(R.isEmpty())return "Dire";
         if(D.isEmpty())return "Radiant";
        while(!R.isEmpty() && !D.isEmpty()){
            if(R.peek()>D.peek()){
                R.remove();
                int a=D.peek();
                D.add(a+n);
                D.remove();
            }
            else{
                D.remove();
                int a=R.peek();
                R.add(a+n);
                R.remove();
            }
        }
        
        if(R.isEmpty())return "Dire";
        return "Radiant";
       
    }
}
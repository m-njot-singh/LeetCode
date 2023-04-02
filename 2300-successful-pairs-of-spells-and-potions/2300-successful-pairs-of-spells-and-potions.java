class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        Arrays.sort(potions);
        List<Integer> l=new ArrayList<>();
        long ifmax=0;
        int count=0;;
        for(int i=0;i<spells.length;i++){
            int left=0;
            int right=potions.length-1;
            while(left<=right){
                int mid=(left+right)/2;
                ifmax=(long)spells[i]*potions[mid];
                if(ifmax<success){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
            
            l.add(potions.length-left);
        }
        // System.out.println(l);
        int[]ans=new int[spells.length];
        for(int i=0;i<spells.length;i++){
            ans[i]=l.get(i);
        }
        
        return ans;
    }
}
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> set=new HashSet<>();
        List<Integer> l=new ArrayList<>();
        int count=0;
        for(int i=0;i<A.length;i++){
            int j=0;
            while(j<=i){
                set.add(A[j]);
                j++;
            }
            j=0;
            while(j<=i){
                if(set.contains(B[j]))count++;
                j++;
            }
            j=0;
            l.add(count);
            // System.out.println(count);
            count=0;
        }
        int[] ans=new int[l.size()];
        int i=0;
        for(int a:l){
            ans[i]=a;
            i++;
        }
        return ans;
    }
}
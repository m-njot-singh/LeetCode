class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length==0)return 0;
        if(fruits.length==1)return 1;
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        int max=0;
        int j=0;
        int i=0;
        int flag=0;
        while(j<fruits.length){
            map.put(fruits[j],map.getOrDefault(fruits[j], 0)+1);
            count++;
            if(map.size()<2){
              j++ ; 
            }
            if(map.size()==2){
                flag=1;
                max=Math.max(count,max);
                j++;
            }
            else if(map.size()>2) {
                while(map.size()>2){
                    if(map.containsKey(fruits[i])){
                        map.put(fruits[i],map.get(fruits[i])-1);
                        count--;
                    }
                    if(map.get(fruits[i])==0){
                        map.remove(fruits[i]);
                    }
                    i++;
                }
                j++;
            }
            
        }
        if(flag==0){
            return count;
        }
        return max;
    }
}
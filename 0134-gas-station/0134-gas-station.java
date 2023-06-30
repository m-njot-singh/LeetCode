
class Solution {
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int gassum=0;
        for(int i:gas){
            gassum+=i;
        }
        int costsum=0;
        for(int i:cost){
            costsum+=i;
        }
        if(costsum>gassum)return -1;
        
        int ans=0;
        int remaining_fuel=0;
        for(int i=0;i<gas.length;i++){
            remaining_fuel+=gas[i]-cost[i];
            
            if(remaining_fuel<0){
                ans=i+1;
               remaining_fuel=0; 
            }
        }
        return ans;
    }
}
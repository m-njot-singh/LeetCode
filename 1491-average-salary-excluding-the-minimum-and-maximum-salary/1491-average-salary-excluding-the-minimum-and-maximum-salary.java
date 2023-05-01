class Solution {
    public double average(int[] salary) {
        double ans=0;
        double avg=salary.length-2;
        Arrays.sort(salary);
        for(int i=1;i<salary.length-1;i++){
            ans+=salary[i];
        }
        return ans/avg;
    }
}
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int left=0;
        for(int i=0;i<gas.length;i++)
        {
            left=left + gas[i]-cost[i];
        }
        if(left<0)
        return -1;
        int start=0;
        int rem =0;
        for(int i=0;i<gas.length;i++)
        {
        int current=gas[i]+rem;
        int cc = cost[i];
        rem=current-cc;
        if(rem<0){
            rem=0;
            start=i+1;
        }
        }
        return start;
    }
}
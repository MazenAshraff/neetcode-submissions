class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int total = 0;
        int j = 0;
        for(int i = 0; i < gas.length;i++){
            if(sum < 0){
                sum = 0;
                j = i;
            }
            total+= (gas[i] - cost[i]);
            sum+=(gas[i] - cost[i]);
        }
        if(total < 0) return -1;

        return j;
    }
}

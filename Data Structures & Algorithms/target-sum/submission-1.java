class Solution {
    private int target;
    private HashMap<String,Integer> dp;
    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;
        dp = new HashMap<>();
        return solve(nums,0, 0);
    }

    public int solve(int nums[], int i, int cur){
        String state = state(i, cur);
        if(dp.containsKey(state)) return dp.get(state);
        if(cur == target && i == nums.length) return 1;
        if(i == nums.length) return 0;
        int result = solve(nums,i+1, cur + nums[i]) + solve(nums, i+1, cur - nums[i]);
        dp.put(state, result);
        return result;
    }

    private String state(int i, int cur){
        return i +" "+cur;
    }


}

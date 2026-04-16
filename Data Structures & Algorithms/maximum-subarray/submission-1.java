class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int max = nums[0];
        boolean zeroExists = false;
        int maxResult = result;
        for(int i = 1;i < nums.length;i++){
            if(result + nums[i] >=0){
                result+=nums[i];
            }
            else{
                maxResult = Math.max(result,maxResult);
                result = 0;
            }
            max = Math.max(max, nums[i]);
            maxResult = Math.max(maxResult, result);
            if(nums[i] == 0){
                zeroExists = true;
            }
        }
        if(zeroExists || maxResult>0){
            return Math.max(maxResult,max);
        }
        return max;
    }
}

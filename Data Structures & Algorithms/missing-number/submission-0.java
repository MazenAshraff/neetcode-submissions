class Solution {
    public int missingNumber(int[] nums) {
       int sumTotal = nums.length*(nums.length+1)/2;
       for(int i = 0; i < nums.length;i++){
        sumTotal-= nums[i];
       }
       return sumTotal; 
    }
}

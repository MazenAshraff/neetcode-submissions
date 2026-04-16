class Solution {
    public int missingNumber(int[] nums) {
    int sumTotal = 0;
       for(int i = 0; i < nums.length;i++){
        sumTotal^= nums[i] ^ i;
       }
       sumTotal^= nums.length;
       return sumTotal; 
    }
}

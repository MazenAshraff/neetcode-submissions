class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] result = new int[nums.length];
        Arrays.fill(result, 1);
        for(int i = 1 ;i< result.length;i++){
            result[i] = result[i-1] * nums[i-1];
        }
        int suffix = nums[nums.length - 1];
        for(int j = nums.length - 2; j>-1;j--){
            result[j] = result[j] * suffix;
            suffix*= nums[j];
        }
        return result;
    }
}  

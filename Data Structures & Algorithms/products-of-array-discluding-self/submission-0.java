class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefixMul [] = new int [nums.length];
        int postfixMul [] = new int[nums.length];
        prefixMul[0] = nums[0];
        postfixMul[nums.length - 1] = nums[nums.length - 1];
        for(int i = 1, j = nums.length - 2; j >= 0; j--,i++){
            prefixMul[i] = prefixMul[i - 1] * nums[i];
            postfixMul[j] = postfixMul[j + 1] * nums[j];
        }
        int res []= new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                res[i] = postfixMul[1];
            }
            else{
                if(i == nums.length - 1){
                    res[nums.length - 1] = prefixMul[nums.length - 2];
                }
                else{
                    res[i] = prefixMul[i - 1] * postfixMul[i + 1];
                }
            }
        }
        return res;
    }
}  

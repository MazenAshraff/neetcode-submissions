class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length -  1;
        int end = nums[high];
        while(low<=high){
            int mid = low + high >> 1;
            if (nums[mid] > end){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return nums[high+1];
    }
}

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length -  1;
        int start = nums[low];
        int ans = start;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] >= start){
                low = mid + 1;
            }
            else{
                ans = nums[mid];
                high = mid - 1;
            }
        }
        return ans;
    }
}

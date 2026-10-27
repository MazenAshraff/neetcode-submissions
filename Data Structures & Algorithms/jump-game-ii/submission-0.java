class Solution {
    public int jump(int[] nums) {
        int left = 0;
        int right = 0;
        int farthestIndex = 0;
        int steps = 0;
        while(right < nums.length-1){
            while(left <= right){
                farthestIndex = Math.max(farthestIndex,left + nums[left]);
                left++;
            }
            steps++;
            right = farthestIndex;
        }
        return steps;
    }
}

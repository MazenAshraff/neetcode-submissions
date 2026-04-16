class Solution {
    public boolean canJump(int[] nums) {
    int canReach = 0;
    for(int i = 0;i<nums.length;i++){
        if(canReach>=i)
            canReach = Math.max(canReach, i + nums[i]);
    }
    return canReach>=nums.length - 1;
    }
}

class Solution {
    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> currentSum = new LinkedList<>();
        addAnotherCombination(nums, currentSum, target, 0);
        return results;
    }

    public void addAnotherCombination(int [] nums,List<Integer> currentSum, int currentTarget, int currentIndex){
        if (currentTarget == 0){
            List<Integer> dest = new LinkedList<>();
            currentSum.forEach(current -> dest.add(current));
            results.add(dest);
            return;
        }
        if(currentIndex >= nums.length){
            return;
        }
        if(nums[currentIndex]<= currentTarget){
            currentSum.add(nums[currentIndex]);
            addAnotherCombination(nums, currentSum, currentTarget - nums[currentIndex], currentIndex);
            currentSum.removeLast();
        }
        addAnotherCombination(nums,currentSum, currentTarget, currentIndex + 1);
    }

}

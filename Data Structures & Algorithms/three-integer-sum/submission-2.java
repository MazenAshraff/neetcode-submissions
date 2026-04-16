class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i< nums.length;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }
        for(int i = 0;i < nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1; j < nums.length; j++){
                if(j> i+1 && nums[j] == nums[j-1]) continue;
                int target = - (nums[i] + nums[j]);
                int targetCount = hm.getOrDefault(target, 0);
                targetCount = nums[i] == target && nums[j] == target
                ? targetCount - 2
                :nums[i] == target || nums[j] == target
                ? targetCount - 1 
                : targetCount;
                if(targetCount > 0 && target>= nums[j]){
                    result.add(List.of(nums[i], nums[j], target));
                }
            }
        }
        return result;
    }
}

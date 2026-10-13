class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();

        for(int i = nums.length - 1; i >= 0; i--){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i], i);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j = i+1; j < nums.length; j++){
                if(j>i+1 && nums[j] == nums[j-1])
                    continue;
                int target = -nums[i]-nums[j];
                if(hm.containsKey(target) && hm.get(target) > j){
                    ans.add(List.of(nums[i], nums[j], target));
                }
            }
        }
        return ans;
    }
}

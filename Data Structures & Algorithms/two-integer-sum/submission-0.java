class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        for (int i = 0;i < nums.length; i++){
            hs.put(nums[i], i);
        }
        for(int i = 0;i<nums.length; i++){
            int searchingFor = target - nums[i];
            if(hs.containsKey(searchingFor)){
                int candidateIndex = hs.get(searchingFor);
                if(candidateIndex != i){
                    return new int[]{i, candidateIndex};
                }
            }
        }
        return new int[2];

    }
}

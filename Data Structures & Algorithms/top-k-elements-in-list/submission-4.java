class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i : nums){
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        int [] kth = new int [k];
        int [] distinct = new int[hm.size()];
        int i = 0;
        for( int key : hm.keySet()){
            distinct[i++] = key;
        }

        quickSelect(distinct,0, distinct.length - 1, k, hm);
        for(i = 0; i<k;i++){
            kth[i] = distinct[i];
        }
        System.out.println(Arrays.toString(distinct));
        return kth;

    }

    public int partition(int nums [], int low, int high, int k, HashMap<Integer,Integer> hm){
        int pivotFreq = hm.get(nums[high]);
        int i =  low;
        for(int j = low; j < high; j++){
            if(pivotFreq < hm.get(nums[j])){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i, high);
        return i;
    }

    public void quickSelect(int nums [], int low, int high, int k,HashMap<Integer,Integer> hm){
        if(low>high) return;
        int partition = partition(nums, low, high, k, hm);
        if(partition == k - 1){
            return;
        }
        if(partition>= k){
            quickSelect(nums, low, partition - 1, k , hm);
        }
        else{
            quickSelect(nums,partition + 1, high, k , hm);
        }
    }

    public void swap(int nums[], int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

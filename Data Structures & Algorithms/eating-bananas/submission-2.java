class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = max(piles);
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            long timeNeededWithMid = findHoursWithRate(piles, mid);
            if(timeNeededWithMid <=h){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public int max(int [] piles){
        int max = piles[0];
        for(int cur : piles){
            if(cur > max){
                max = cur;
            }
        }
        return max;
    }
    public long findHoursWithRate(int [] piles, int k){
        long t = 0l;
        for(int i = 0; i < piles.length; i++){
            int timeForPile = (piles[i])/k;
            timeForPile += (piles[i]%k == 0)? 0 : 1;
            t+=timeForPile;
        }
        return t;
    }
}

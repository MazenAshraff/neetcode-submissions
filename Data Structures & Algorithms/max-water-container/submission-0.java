class Solution {
    public int maxArea(int[] heights) {
        int right = 0;
        int left = heights.length - 1;
        int maxArea = 0;
        while(right < left){
            int currentArea = (left - right) * Math.min(heights[right], heights[left]);
            maxArea = Math.max(currentArea, maxArea);
            if(heights[right] <= heights[left]){
                right++;
            }
            else{
                left--;
            }

        }
        return maxArea; 
    }
}

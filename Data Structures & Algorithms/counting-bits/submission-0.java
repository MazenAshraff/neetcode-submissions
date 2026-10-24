class Solution {
    public int[] countBits(int n) {
        int [] count = new int[n+1];
        for(int i = 0; i<=n;i++){
            int c= 0;
            for(int j = 0;j < 32;j++){
                if((i&1<<j)!=0) c++;
            }
            count[i] = c;
        }
        return count;
    }
}

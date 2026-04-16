class Solution {
    public int reverseBits(int n) {
        int i = 31;
        int result = 0;
        int j = 0;
        while(j<32){
            if((n & 1<<j)!=0){
            result |= (1 << i);
            }
            i--;
            j++;
        }
        return result;
    }
}

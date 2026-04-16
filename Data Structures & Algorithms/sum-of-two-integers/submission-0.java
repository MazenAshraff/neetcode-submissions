class Solution {
    public int getSum(int a, int b) {
        int result = 0;
        int carry = 0;
       for(int i = 0;i<32;i++){
        int x = a & (1<<i);
        int y = b & (1<<i);
        if(((x&y)&carry) != 0){
            result |= 1<<i;
            carry = 1<<(i+1);
        }
        else{
            if((x&y) !=0 || (x&carry)!=0 || (y&carry)!=0  ){
                carry = 1<<(i+1);
            }
            else{
                if(x!=0 | y!=0 | carry!=0){
                    result |= 1<<i;
                    carry = 0;
                }
            }
        }
       }
       return result; 
    }
}

class Solution {
    public int getSum(int a, int b) {
        int result = 0;
        boolean carry = false;
        for (int i = 0; i < 32; i++) {
            boolean aHas1 = (a & (1 << i)) != 0;
            boolean bHas1 = (b & (1 << i)) != 0;
            boolean willSet = aHas1 ^ bHas1 ^ carry;
            carry = aHas1 & bHas1 | aHas1&carry | bHas1 & carry;
            if (willSet) {
                result |= (1 << i);
            }
        }
        return result;
    }
}

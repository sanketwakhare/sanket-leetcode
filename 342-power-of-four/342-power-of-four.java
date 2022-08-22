class Solution {
    public boolean isPowerOfFour(int n) {
        // check if n is power of 2 and take AND with 10101010101010101010101010101010
        return n > 0 && (n & (n-1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }
}
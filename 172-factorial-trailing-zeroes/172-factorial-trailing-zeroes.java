class Solution {
    public int trailingZeroes(int n) {
     
        // observation: whenever we encounter multiple of 5 the trailing 0 increases by 1.
        // So problem becomes, find no of trailing 0s
        return n == 0 ? 0 : trailingZeroes(n/5) + n/5;
    }
}
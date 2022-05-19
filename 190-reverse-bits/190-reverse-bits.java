public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        int answer = 0;
        for(int i=0; i<32; i++) {
            // get ith bit value
            int ithBitValue = (n>>i) & 1;
            // keep adding the value from start of the result
            answer = answer | ithBitValue << (31 - i);
        }
        return answer;
    }
}